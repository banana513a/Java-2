package com.blackybear.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: ConfigInfoManager
 * Author: qinweitao
 * CopyRight: blackybear
 * Create Date: 2017-12-04
 */
public class ConfigInfoManager  extends PropertyPlaceholderConfigurer {
    /**
     * 全局配置哈希表
     */
    private static ConcurrentHashMap<String, Object> configInfos = null;
    public static ConcurrentHashMap<String, Object> getConfigInfos(){
        return configInfos;
    }

    static {
        configInfos = new ConcurrentHashMap<>();
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        loadConfigInfo(props);
        System.out.println("======>Config load OK!");
    }

    /**
     * 从全局配置哈希表中获取配置项
     * @param key
     * @return
     */
    public static Object getConfigInfo(String key) {
        if (!configInfos.containsKey(key)) {
            return null;
        }
        return configInfos.get(key).toString();
    }

    /**
     * 设置配置项到全局配置哈希表
     * @param key
     * @param value
     */
    public static void setConfigInfo(String key, Object value){
        if(key == null || value == null){
            return;
        }
        configInfos.put(key, value);
    }

    /**
     * 加载properties到全局配置哈希
     * @param props
     * @return
     */
    private static boolean loadConfigInfo(Properties props) {
        if(props == null)
            return false;
        Map.Entry<Object, Object> entry;
        for (Iterator<Map.Entry<Object, Object>> iterator = props.entrySet().iterator(); iterator.hasNext();) {
            entry =  iterator.next();
            configInfos.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return true;
    }
}
