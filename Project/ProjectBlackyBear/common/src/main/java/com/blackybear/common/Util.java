package com.blackybear.common;

import java.io.IOException;
import java.util.Properties;

/**
 * Description: Utility
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class Util {
    /**
     * Get properties from properties files
     * @param clazz
     * @param filePath
     * @return
     */
    public static Properties getProperties(Class<?> clazz, String filePath) {
        Properties properties = new Properties();
        try {
            properties.load(clazz.getResourceAsStream(filePath));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return properties;
    }


    public static String getHTML(String title, String htmlBody) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>\n");
        stringBuilder.append("<html>\n");
        stringBuilder.append("<head>\n");
        stringBuilder.append("<title>");
        stringBuilder.append(title);
        stringBuilder.append("</title>\n");
        stringBuilder.append("</head>\n");
        stringBuilder.append("<body>\n");
        stringBuilder.append(htmlBody);
        stringBuilder.append("\n");
        stringBuilder.append("</body>\n");
        stringBuilder.append("</html>");

//		System.out.println(mStringBuilder.toString());
        return stringBuilder.toString();
    }
}

