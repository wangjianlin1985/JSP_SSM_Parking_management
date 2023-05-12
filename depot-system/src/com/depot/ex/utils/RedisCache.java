// 
// 
// 

package com.depot.ex.utils;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import redis.clients.jedis.exceptions.JedisConnectionException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.slf4j.LoggerFactory;
import java.util.concurrent.locks.ReadWriteLock;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.slf4j.Logger;
import org.apache.ibatis.cache.Cache;

public class RedisCache implements Cache
{
    private static final Logger logger;
    private static JedisConnectionFactory jedisConnectionFactory;
    private final String id;
    private final ReadWriteLock readWriteLock;
    
    static {
        logger = LoggerFactory.getLogger((Class)RedisCache.class);
    }
    
    public RedisCache(final String id) {
        this.readWriteLock = new ReentrantReadWriteLock();
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        RedisCache.logger.debug("MybatisRedisCache:id=" + id);
        this.id = id;
    }
    
    public void clear() {
        JedisConnection connection = null;
        try {
            connection = RedisCache.jedisConnectionFactory.getConnection();
            connection.flushDb();
            connection.flushAll();
        }
        catch (JedisConnectionException e) {
            e.printStackTrace();
            return;
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }
        /*
        if (connection != null) {
            connection.close();
        }*/
    }
    
    public String getId() {
        return this.id;
    }
    
    public Object getObject(final Object key) {
        Object result = null;
        JedisConnection connection = null;
        try {
            connection = RedisCache.jedisConnectionFactory.getConnection();
            final RedisSerializer<Object> serializer = (RedisSerializer<Object>)new JdkSerializationRedisSerializer();
            result = serializer.deserialize(connection.get(serializer.serialize(key)));
        }
        catch (JedisConnectionException e) {
            e.printStackTrace();
            return result;
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }
        /*
        if (connection != null) {
            connection.close();
        }*/
        return result;
    }
    
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
    
    public int getSize() {
        int result = 0;
        JedisConnection connection = null;
        try {
            connection = RedisCache.jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        }
        catch (JedisConnectionException e) {
            e.printStackTrace();
            return result;
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }
        /*
        if (connection != null) {
            connection.close();
        }*/
        return result;
    }
    
    public void putObject(final Object key, final Object value) {
        JedisConnection connection = null;
        try {
            connection = RedisCache.jedisConnectionFactory.getConnection();
            final RedisSerializer<Object> serializer = (RedisSerializer<Object>)new JdkSerializationRedisSerializer();
            connection.set(serializer.serialize(key), serializer.serialize(value));
        }
        catch (JedisConnectionException e) {
            e.printStackTrace();
            return;
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }
        /*
        if (connection != null) {
            connection.close();
        }*/
    }
    
    public Object removeObject(final Object key) {
        JedisConnection connection = null;
        Object result = null;
        try {
            connection = RedisCache.jedisConnectionFactory.getConnection();
            final RedisSerializer<Object> serializer = (RedisSerializer<Object>)new JdkSerializationRedisSerializer();
            result = connection.expire(serializer.serialize(key), 0L);
        }
        catch (JedisConnectionException e) {
            e.printStackTrace();
            return result;
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }
        /*
        if (connection != null) {
            connection.close();
        }*/
        return result;
    }
    
    public static void setJedisConnectionFactory(final JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }
}
