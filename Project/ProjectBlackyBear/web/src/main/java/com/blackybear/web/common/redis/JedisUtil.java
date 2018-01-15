package com.blackybear.web.common.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;
import redis.clients.util.Slowlog;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description: RedisUtil
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2018-01-04
 */
@Slf4j
@Component
public class JedisUtil {
    @Autowired
    private JedisPool jedisPool;

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    //region Connection
    public String auth(String password) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.auth(password);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String echo(String message) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.echo(message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] echo(byte[] message) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.echo(message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String ping() {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.ping();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String quit() {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.quit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String select(int index) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.select(index);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region Server
    public String bgrewriteaof(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bgrewriteaof();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String bgsave(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bgsave();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String clientgetname(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.clientGetname();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String clientkill(String client) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.clientKill(client);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String clientkill(byte[] client) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.clientKill(client);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String clientlist() {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.clientList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String clientsetnam(String name){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.clientSetname(name);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String clientsetname(byte[] name){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.clientSetname(name);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> configget(String pattern){
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.configGet(pattern);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> configget(byte[] pattern){
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.configGet(pattern);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String configresetstat(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.configResetStat();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String configset(String parameter, String value){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.configSet(parameter, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] configset(byte[] parameter, byte[] value){
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.configSet(parameter, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long dbSize() {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.dbSize();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String debug(DebugParams params){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.debug(params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String flushAll() {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.flushAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String flushDB() {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.flushDB();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String info() {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.info();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String info(String section) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.info(section);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long lastsave(){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lastsave();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public void monitor(JedisMonitor jedisMonitor){
        Jedis jedis = getJedis();
        if (jedis == null)
            return;
        try {
            jedis.monitor(jedisMonitor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
    }

    public String save(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.save();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String shutdown(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.shutdown();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String slaveof(String host, int port){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.slaveof(host, port);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long slowloglen(){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.slowlogLen();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<Slowlog> slowlogget(){
        List<Slowlog> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.slowlogGet();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<Slowlog> slowlogget(long entries){
        List<Slowlog> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.slowlogGet(entries);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> slowloggetbinary(){
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.slowlogGetBinary();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> slowloggetbinary(long entries){
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.slowlogGetBinary(entries);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String slowlogreset(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.slowlogReset();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public void sync(){
        Jedis jedis = getJedis();
        if (jedis == null)
            return;
        try {
            jedis.sync();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
    }

    public List<String> time(){
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.time();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region Keys
    public Long del(String... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.del(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long del(byte[]... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.del(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long del(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.del(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long del(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.del(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] dump(String key) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.dump(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] dump(byte[] key) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.dump(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean exists(String key) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.exists(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean exists(byte[] key) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.exists(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long exists(String... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.exists(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long exists(byte[]... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.exists(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long expire(String key, int seconds) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.expire(key, seconds);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long expire(byte[] key, int seconds) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.expire(key, seconds);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long expireAt(String key, long unixTime) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.expireAt(key, unixTime);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long expireAt(byte[] key, long unixTime) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.expireAt(key, unixTime);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> keys(String pattern) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.keys(pattern);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> keys(byte[] pattern) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.keys(pattern);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String migrate(String host, int port, String key, int destDb, int timeout) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.migrate(host, port, key, destDb, timeout);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String migrate(byte[] host, int port, byte[] key, int destDb, int timeout) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.migrate(host, port, key, destDb, timeout);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long move(String key, int dbIndex) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.move(key, dbIndex);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long move(byte[] key, int dbIndex) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.move(key, dbIndex);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String objectEncoding(String key) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.objectEncoding(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] objectEncoding(byte[] key) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.objectEncoding(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long objectIdletime(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.objectIdletime(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long objectIdletime(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.objectIdletime(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long objectRefcount(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.objectRefcount(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long objectRefcount(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.objectRefcount(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long persist(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.persist(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long persist(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.persist(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pexpire(String key, long milliseconds) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pexpire(key, milliseconds);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pexpire(byte[] key, long milliseconds) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pexpire(key, milliseconds);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pexpireAt(String key, long millisecondsTimestamp) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pexpireAt(key, millisecondsTimestamp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pexpireAt(byte[] key, long millisecondsTimestamp) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pexpireAt(key, millisecondsTimestamp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pttl(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pttl(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pttl(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pttl(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String randomKey() {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.randomKey();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] randomBinaryKey() {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.randomBinaryKey();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String rename(String oldKey, String newKey) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rename(oldKey, newKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String rename(byte[] oldKey, byte[] newKey) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rename(oldKey, newKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long renamenx(String oldKey, String newKey) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.renamenx(oldKey, newKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long renamenx(byte[] oldKey, byte[] newKey) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.renamenx(oldKey, newKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String restore(String key, int ttl, byte[] serializedValue) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.restore(key, ttl, serializedValue);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String restore(byte[] key, int ttl, byte[] serializedValue) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.restore(key, ttl, serializedValue);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> sort(String key) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sort(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> sort(String key, SortingParams sortingParams) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sort(key, sortingParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sort(String key, String destKey) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sort(key, destKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sort(String key, SortingParams sortingParams, String destKey) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sort(key, sortingParams, destKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> sort(byte[] key) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sort(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> sort(byte[] key, SortingParams sortingParams) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sort(key, sortingParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sort(byte[] key, byte[] destKey) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sort(key, destKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sort(byte[] key, SortingParams sortingParams, byte[] destKey) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sort(key, sortingParams, destKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long ttl(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.ttl(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long ttl(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.ttl(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String type(String key) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.type(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String type(byte[] key) {

        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.type(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<String> scan(String cursor) {
        ScanResult<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scan(cursor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<String> scan(String cursor, ScanParams scanParams) {
        ScanResult<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scan(cursor, scanParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<byte[]> scan(byte[] cursor) {
        ScanResult<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scan(cursor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<byte[]> scan(byte[] cursor, ScanParams scanParams) {
        ScanResult<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scan(cursor, scanParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region String
    public Long append(String key, String value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.append(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long append(byte[] key, byte[] value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.append(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long bitcount(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bitcount(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long bitcount(String key, long start, long end) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bitcount(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long bitcount(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bitcount(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long bitcount(byte[] key, long start, long end) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bitcount(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long bitop(BitOP op, String destKey, String... srcKeys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bitop(op, destKey, srcKeys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long bitop(BitOP op, byte[] destKey, byte[]... srcKeys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bitop(op, destKey, srcKeys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<Long> bitfield(String key, String... arguments) {
        List<Long> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bitfield(key, arguments);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> bitfield(byte[] key, byte[]... arguments) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.bitfield(key, arguments);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long decr(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.decr(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long decr(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.decr(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long decrby(String key, long count) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.decrBy(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long decrby(byte[] key, long count) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.decrBy(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String get(String key) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.get(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] get(byte[] key) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.get(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean getbit(String key, long offSet) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.getbit(key, offSet);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean getbit(byte[] key, long offSet) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.getbit(key, offSet);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String getrange(String key, long start, long end) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.getrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] getrange(byte[] key, long start, long end) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.getrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String getset(String key, String value) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.getSet(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] getset(byte[] key, byte[] value) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.getSet(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long incr(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.incr(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long incr(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.incr(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long incrby(String key, int count) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.incrBy(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long incrby(byte[] key, int count) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.incrBy(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double incrbyfloat(String key, double count) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.incrByFloat(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double incrbyfloat(byte[] key, double count) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.incrByFloat(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> mget(String... keys) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.mget(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> mget(byte[]... keys) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.mget(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String mset(String... keysvalues) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.mset(keysvalues);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String mset(byte[]... keysvalues) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.mset(keysvalues);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long msetnx(String... keysvalues) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.msetnx(keysvalues);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long msetnx(byte[]... keysvalues) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.msetnx(keysvalues);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String psetex(String key, long milliSeconds, String value) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.psetex(key, milliSeconds, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String psetex(byte[] key, long milliSeconds, byte[] value) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.psetex(key, milliSeconds, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String set(String key, String value) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String set(String key, String value, String nxxx) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.set(key, value, nxxx);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String set(String key, String value, String nxxx, String expx, int time) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.set(key, value, nxxx, expx, time);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String set(String key, String value, String nxxx, String expx, long time) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.set(key, value, nxxx, expx, time);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String set(byte[] key, byte[] value) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String set(byte[] key, byte[] value, byte[] nxxx) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.set(key, value, nxxx);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, int time) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.set(key, value, nxxx, expx, time);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.set(key, value, nxxx, expx, time);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean setbit(String key, long offset, String value) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.setbit(key, offset, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean setbit(String key, long offset, boolean value) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.setbit(key, offset, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean setbit(byte[] key, long offset, byte[] value) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.setbit(key, offset, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean setbit(byte[] key, long offset, boolean value) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.setbit(key, offset, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String setex(String key, int seconds, String value) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.setex(key, seconds, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String setex(byte[] key, int seconds, byte[] value) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.setex(key, seconds, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long setnx(String key, String value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.setnx(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long setnx(byte[] key, byte[] value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.setnx(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long setrange(String key, long offset, String value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.setrange(key, offset, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long setrange(byte[] key, long offset, byte[] value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.setrange(key, offset, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long strlen(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.strlen(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long strlen(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.strlen(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region Hash
    public Long hdel(String key, String... fields) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hdel(key, fields);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long hdel(byte[] key, byte[]... fields) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hdel(key, fields);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean hexists(String key, String field) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.hexists(key, field);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean hexists(byte[] key, byte[] field) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.hexists(key, field);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String hget(String key, String field) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hget(key, field);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] hget(byte[] key, byte[] field) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hget(key, field);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Map<String, String> hgetall(String key) {
        Map<String, String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hgetAll(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Map<byte[], byte[]> hgetall(byte[] key) {
        Map<byte[], byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hgetAll(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long hincrby(String key, String field, long value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hincrBy(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long hincrby(byte[] key, byte[] field, long value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hincrBy(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double hincrbyfloat(String key, String field, double value) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hincrByFloat(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double hincrbyfloat(byte[] key, byte[] field, double value) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hincrByFloat(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> hkeys(String key) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hkeys(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> hkeys(byte[] key) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hkeys(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long hlen(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hlen(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long hlen(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hlen(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> hmget(String key, String... fields) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hmget(key, fields);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hmget(key, fields);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String hmset(String key, Map<String, String> hash) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hmset(key, hash);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hmset(key, hash);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long hset(String key, String field, String value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hset(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long hset(byte[] key, byte[] field, byte[] value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hset(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long hsetnx(String key, String field, String value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hsetnx(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hsetnx(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> hvals(String key) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hvals(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> hvals(byte[] key) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hvals(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        ScanResult<Map.Entry<String, String>> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hscan(key, cursor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams scanParams) {
        ScanResult<Map.Entry<String, String>> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hscan(key, cursor, scanParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor) {
        ScanResult<Map.Entry<byte[], byte[]>> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hscan(key, cursor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor, ScanParams scanParams) {
        ScanResult<Map.Entry<byte[], byte[]>> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.hscan(key, cursor, scanParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region List
    public List<String> blpop(String... args) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.blpop(args);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> blpop(byte[]... args) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.blpop(args);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> blpop(int timeout, String key) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.blpop(timeout, key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> blpop(int timeout, String... keys) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.blpop(timeout, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> blpop(int timeout, byte[]... keys) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.blpop(timeout, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> brpop(String... args) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.brpop(args);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> brpop(byte[]... args) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.brpop(args);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> brpop(int timeout, String key) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.brpop(timeout, key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> brpop(int timeout, String... keys) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.brpop(timeout, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> brpop(int timeout, byte[]... keys) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.brpop(timeout, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String brpoplpush(String src, String dest, int timeout) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.brpoplpush(src, dest, timeout);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] brpoplpush(byte[] src, byte[] dest, int timeout) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.brpoplpush(src, dest, timeout);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String lindex(String key, long index) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lindex(key, index);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] lindex(byte[] key, long index) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lindex(key, index);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.linsert(key, where, pivot, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long linsert(byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.linsert(key, where, pivot, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long llen(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.llen(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long llen(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.llen(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String lpop(String key) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lpop(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] lpop(byte[] key) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lpop(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long lpush(String key, String... values) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lpush(key, values);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long lpush(byte[] key, byte[]... values) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lpush(key, values);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long lpushx(String key, String... values) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lpushx(key, values);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long lpushx(byte[] key, byte[]... values) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lpushx(key, values);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> lrange(String key, long start, long end) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> lrange(byte[] key, long start, long end) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long lrem(String key, long count, String value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lrem(key, count, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long lrem(byte[] key, long count, byte[] value) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lrem(key, count, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String lset(String key, long index, String value) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lset(key, index, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String lset(byte[] key, long index, byte[] value) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.lset(key, index, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String ltrim(String key, long start, long end) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.ltrim(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String ltrim(byte[] key, long start, long end) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.ltrim(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String rpop(String key) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rpop(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] rpop(byte[] key) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rpop(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String rpoplpush(String srcKey, String destKey) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rpoplpush(srcKey, destKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] rpoplpush(byte[] srcKey, byte[] destKey) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rpoplpush(srcKey, destKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long rpush(String key, String... values) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rpush(key, values);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long rpush(byte[] key, byte[]... values) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rpush(key, values);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long rpushx(String key, String... values) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rpushx(key, values);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long rpushx(byte[] key, byte[]... values) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.rpushx(key, values);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region Set
    public Long sadd(String key, String... members) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sadd(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sadd(byte[] key, byte[]... members) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sadd(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long scard(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scard(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long scard(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scard(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> sdiff(String... keys) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sdiff(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> sdiff(byte[]... keys) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sdiff(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sdiffstore(String destKey, String... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sdiffstore(destKey, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sdiffstore(byte[] destKey, byte[]... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sdiffstore(destKey, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> sinter(String... keys) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sinter(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> sinter(byte[]... keys) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sinter(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sinterstore(String destKey, String... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sinterstore(destKey, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sinterstore(byte[] destKey, byte[]... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sinterstore(destKey, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean sismember(String key, String member) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.sismember(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean sismember(byte[] key, byte[] member) {
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.sismember(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> smembers(String key) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.smembers(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> smembers(byte[] key) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.smembers(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long smove(String srcKey, String destKey, String member) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.smove(srcKey, destKey, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long smove(byte[] srcKey, byte[] destKey, byte[] member) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.smove(srcKey, destKey, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String spop(String key) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.spop(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] spop(byte[] key) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.spop(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> spop(String key, long count) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.spop(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> spop(byte[] key, long count) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.spop(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String srandmember(String key) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.srandmember(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] srandmember(byte[] key) {
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.srandmember(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> srandmember(String key, int count) {
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.srandmember(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> srandmember(byte[] key, int count) {
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.srandmember(key, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long srem(String key, String... members) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.srem(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long srem(byte[] key, byte[]... members) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.srem(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> sunion(String... keys) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sunion(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> sunion(byte[]... keys) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sunion(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sunionstore(String destKey, String... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sunionstore(destKey, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long sunionstore(byte[] destKey, byte[]... keys) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sunionstore(destKey, keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<String> sscan(String key, String cursor) {
        ScanResult<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sscan(key, cursor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor) {
        ScanResult<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sscan(key, cursor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<String> sscan(String key, String cursor, ScanParams scanParams) {
        ScanResult<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sscan(key, cursor, scanParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor, ScanParams scanParams) {
        ScanResult<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.sscan(key, cursor, scanParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region SortedSet
    public Long zadd(String key, double score, String member) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zadd(key, score, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zadd(String key, double score, String member, ZAddParams params) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zadd(key, score, member, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zadd(String key, Map<String, Double> scoreMembers) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zadd(key, scoreMembers);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zadd(key, scoreMembers, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zadd(byte[] key, double score, byte[] member) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zadd(key, score, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zadd(byte[] key, double score, byte[] member, ZAddParams params) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zadd(key, score, member, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zadd(key, scoreMembers);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers, ZAddParams params) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zadd(key, scoreMembers, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zcard(String key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zcard(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zcard(byte[] key) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zcard(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zcount(String key, double min, double max) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zcount(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zcount(String key, String min, String max) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zcount(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zcount(byte[] key, double min, double max) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zcount(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zcount(byte[] key, byte[] min, byte[] max) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zcount(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double zincrby(String key, double score, String member) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zincrby(key, score, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double zincrby(String key, double score, String member, ZIncrByParams params) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zincrby(key, score, member, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double zincrby(byte[] key, double score, byte[] member) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zincrby(key, score, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double zincrby(byte[] key, double score, byte[] member, ZIncrByParams params) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zincrby(key, score, member, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrange(String key, long start, long end) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrange(byte[] key, long start, long end) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrangebyscore(String key, double min, double max) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByScore(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrangebyscore(String key, String min, String max) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByScore(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrangebyscore(String key, double min, double max, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByScore(key, min, max, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrangebyscore(String key, String min, String max, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByScore(key, min, max, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrangebyscore(byte[] key, double min, double max) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByScore(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrangebyscore(byte[] key, byte[] min, byte[] max) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByScore(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrangebyscore(byte[] key, double min, double max, int offset, int count) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByScore(key, min, max, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrangebyscore(byte[] key, byte[] min, byte[] max, int offset, int count) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByScore(key, min, max, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zrank(String key, String member) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrank(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zrank(byte[] key, byte[] member) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrank(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zrem(String key, String... members) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrem(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zrem(byte[] key, byte[]... members) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrem(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zremrangebyrank(String key, long start, long end) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zremrangeByRank(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zremrangebyrank(byte[] key, long start, long end) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zremrangeByRank(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zremrangebyscore(String key, double start, double end) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zremrangebyscore(String key, String start, String end) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zremrangebyscore(byte[] key, double start, double end) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zremrangebyscore(byte[] key, byte[] start, byte[] end) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrevrange(String key, long start, long end) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrevrange(byte[] key, long start, long end) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrevrangebyscore(String key, double max, double min) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrevrangebyscore(String key, String max, String min) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrevrangebyscore(String key, double max, double min, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrevrangebyscore(String key, String max, String min, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrevrangebyscore(byte[] key, double max, double min) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrevrangebyscore(byte[] key, byte[] max, byte[] min) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrevrangebyscore(byte[] key, double max, double min, int offset, int count) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrevrangebyscore(byte[] key, byte[] max, byte[] min, int offset, int count) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zrevrank(String key, String member) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrank(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zrevrank(byte[] key, byte[] member) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrevrank(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double zscore(String key, String member) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zscore(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double zscore(byte[] key, byte[] member) {
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zscore(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zunionstore(String destKey, String... sets) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zunionstore(destKey, sets);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zunionstore(String destKey, ZParams params, String... sets) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zunionstore(destKey, params, sets);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zunionstore(byte[] destKey, byte[]... sets) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zunionstore(destKey, sets);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zunionstore(byte[] destKey, ZParams params, byte[]... sets) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zunionstore(destKey, params, sets);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zinterstore(String destKey, String... sets) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zinterstore(destKey, sets);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zinterstore(String destKey, ZParams params, String... sets) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zinterstore(destKey, params, sets);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zinterstore(byte[] destKey, byte[]... sets) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zinterstore(destKey, sets);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zinterstore(byte[] destKey, ZParams params, byte[]... sets) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zinterstore(destKey, params, sets);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<Tuple> zscan(String key, String cursor) {
        ScanResult<Tuple> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zscan(key, cursor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams scanParams) {
        ScanResult<Tuple> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zscan(key, cursor, scanParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor) {
        ScanResult<Tuple> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zscan(key, cursor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor, ScanParams scanParams) {
        ScanResult<Tuple> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zscan(key, cursor, scanParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrangebylex(String key, String min, String max) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByLex(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrangebylex(byte[] key, byte[] min, byte[] max) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByLex(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<String> zrangebylex(String key, String min, String max, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByLex(key, min, max, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Set<byte[]> zrangebylex(byte[] key, byte[] min, byte[] max, int offset, int count) {
        Set<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zrangeByLex(key, min, max, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zlexcount(String key, String min, String max) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zlexcount(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zlexcount(byte[] key, byte[] min, byte[] max) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zlexcount(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zremrangebylex(String key, String min, String max) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zremrangeByLex(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zremrangebylex(byte[] key, byte[] min, byte[] max) {
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.zremrangeByLex(key, min, max);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region HyperLogLog
    public Long pfadd(String key, String... elements){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pfadd(key, elements);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pfadd(byte[] key, byte[]... elements){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pfadd(key, elements);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pfcount(String key){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pfcount(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pfcount(byte[] key){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pfcount(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pfcount(String... key){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pfcount(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pfcount(byte[]... key){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pfcount(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String pfmerge(String destKey, String... srcKeys){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pfmerge(destKey, srcKeys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String pfmerge(byte[] destKey, byte[]... srcKeys) {
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pfmerge(destKey, srcKeys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region GEO
    public Long geoadd(String key, double lng, double lat, String member){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geoadd(key, lng, lat, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long geoadd(byte[] key, double lng, double lat, byte[] member){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geoadd(key, lng, lat, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geoadd(key, memberCoordinateMap);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long geoadd(byte[] key, Map<byte[], GeoCoordinate> memberCoordinateMap){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geoadd(key, memberCoordinateMap);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoCoordinate> geopos(String key, String... members){
        List<GeoCoordinate> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geopos(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoCoordinate> geopos(byte[] key, byte[]... members){
        List<GeoCoordinate> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geopos(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double geodist(String key, String member1, String member2){
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geodist(key, member1, member2);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double geodist(byte[] key, byte[] member1, byte[] member2){
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geodist(key, member1, member2);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double geodist(String key, String member1, String member2, GeoUnit geoUnit){
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geodist(key, member1, member2, geoUnit);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Double geodist(byte[] key, byte[] member1, byte[] member2, GeoUnit geoUnit){
        Double result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geodist(key, member1, member2, geoUnit);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoRadiusResponse> georadius(String key, double lng, double lat, double radius, GeoUnit unit){
        List<GeoRadiusResponse> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.georadius(key, lng, lat, radius, unit);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoRadiusResponse> georadius(byte[] key, double lng, double lat, double radius, GeoUnit unit){
        List<GeoRadiusResponse> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.georadius(key, lng, lat, radius, unit);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoRadiusResponse> georadius(String key, double lng, double lat, double radius, GeoUnit unit, GeoRadiusParam params){
        List<GeoRadiusResponse> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.georadius(key, lng, lat, radius, unit, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoRadiusResponse> georadius(byte[] key, double lng, double lat, double radius, GeoUnit unit, GeoRadiusParam params){
        List<GeoRadiusResponse> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.georadius(key, lng, lat, radius, unit, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoRadiusResponse> georadiusbymember(String key, String member, double radius, GeoUnit unit){
        List<GeoRadiusResponse> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.georadiusByMember(key, member, radius, unit);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoRadiusResponse> georadiusbymember(byte[] key, byte[] member, double radius, GeoUnit unit){
        List<GeoRadiusResponse> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.georadiusByMember(key, member, radius, unit);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoRadiusResponse> georadiusbymember(String key, String member, double radius, GeoUnit unit, GeoRadiusParam params){
        List<GeoRadiusResponse> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.georadiusByMember(key, member, radius, unit, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<GeoRadiusResponse> georadiusbymember(byte[] key, byte[] member, double radius, GeoUnit unit, GeoRadiusParam params){
        List<GeoRadiusResponse> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.georadiusByMember(key, member, radius, unit, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> geohash(String key, String... members){
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geohash(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<byte[]> geohash(byte[] key, byte[]... members){
        List<byte[]> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.geohash(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region Pub/Sub
    public void psubscribe(JedisPubSub jedisPubSub, String... patterns){
        Jedis jedis = getJedis();
        if (jedis == null)
            return;
        try {
            jedis.psubscribe(jedisPubSub, patterns);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
    }

    public void psubscribe(BinaryJedisPubSub binaryJedisPubSub, byte[]... patterns){
        Jedis jedis = getJedis();
        if (jedis == null)
            return;
        try {
            jedis.psubscribe(binaryJedisPubSub, patterns);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
    }

    public Long publish(String channel, String message){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.publish(channel, message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long publish(byte[] channel, byte[] message){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.publish(channel, message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<String> pubsubChannels(String pattern){
        List<String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pubsubChannels(pattern);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Map<String, String> pubsubNumSub(String... channels){
        Map<String, String> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pubsubNumSub(channels);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long pubsubNumPat(){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.pubsubNumPat();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public void subscribe(JedisPubSub jedisPubSub, String... channels){
        Jedis jedis = getJedis();
        if (jedis == null)
            return;
        try {
            jedis.subscribe(jedisPubSub, channels);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
    }

    public void subscribe(BinaryJedisPubSub binaryJedisPubSub, byte[]... channels){
        Jedis jedis = getJedis();
        if (jedis == null)
            return;
        try {
            jedis.subscribe(binaryJedisPubSub, channels);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
    }
    //endregion

    //region Transaction
    public Transaction multi(){
        Transaction result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.multi();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String watch(String... keys){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.watch(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String unwatch(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.unwatch();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion

    //region Script
    public Object eval(String script){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.eval(script);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object eval(String script, int keyCount, String... params){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.eval(script, keyCount, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object eval(String script, List<String> keys, List<String> args){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.eval(script, keys, args);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object eval(byte[] script){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.eval(script);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object eval(byte[] script, int keyCount, byte[] params){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.eval(script, keyCount, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object eval(byte[] script, byte[] keyCount, byte[]... params){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.eval(script, keyCount, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object eval(byte[] script, List<byte[]> keys, List<byte[]> args) {
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.eval(script, keys, args);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object evalsha(String script){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.evalsha(script);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object evalsha(String sha1, int keyCount, String... params){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.evalsha(sha1, keyCount, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object evalsha(String sha1, List<String> keys, List<String> args){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.evalsha(sha1, keys, args);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object evalsha(byte[] sha1){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.evalsha(sha1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object evalsha(byte[] sha1, int keyCount, byte[]... params){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.evalsha(sha1, keyCount, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Object evalsha(byte[] sha1, List<byte[]> keys, List<byte[]> args){
        Object result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.evalsha(sha1, keys, args);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public boolean scriptexists(String sha1){
        boolean result = false;
        Jedis jedis = getJedis();
        if (jedis == null)
            return false;
        try {
            result = jedis.scriptExists(sha1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long scriptexists(byte[] sha1){
        Long result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scriptExists(sha1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<Boolean> scriptexists(String... sha1){
        List<Boolean> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scriptExists(sha1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public List<Long> scriptexists(byte[]... sha1){
        List<Long> result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scriptExists(sha1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String scriptflush(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scriptFlush();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String scriptkill(){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scriptKill();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public String scriptload(String script){
        String result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scriptLoad(script);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public byte[] scriptload(byte[] script){
        byte[] result = null;
        Jedis jedis = getJedis();
        if (jedis == null)
            return null;
        try {
            result = jedis.scriptLoad(script);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }
    //endregion
}