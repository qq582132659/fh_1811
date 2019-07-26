package com.fh.shop.api.utils;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    //调用redis设置set方法
    public static void set(String key,String value){
        Jedis resource = null;
        try {
            resource = RedisPool.getResourcr();
            resource.set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
            throw new RuntimeException(e);
        } finally {
            if(null != resource){
                resource.close();
            }
        }
    }
    //调用redis设置get方法
    public static String get(String key){
        Jedis resource = null;
        String value;
        try {
            resource = RedisPool.getResourcr();
            value = resource.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
            throw new RuntimeException(e);
        } finally {
            if(null != resource){
                resource.close();
            }
        }
        return value;
    }
    //调用redis设置exists方法
    public static boolean exists(String key){
        Jedis resource = null;
        Boolean exists;
        try {
            resource = RedisPool.getResourcr();
            exists = resource.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
            throw new RuntimeException(e);
        } finally {
            if(null != resource){
                resource.close();
            }
        }
        return exists;
    }
    //调用redis设置del方法
    public static void del(String key){
        Jedis resource = null;
        try {
            resource = RedisPool.getResourcr();
            resource.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
            throw new RuntimeException(e);
        } finally {
            //关闭连接释放资源
            if(null != resource){
                resource.close();
            }
        }
    }
    //调用redis设置key过期时间定时方法
    public static void setEx(String key,int ss,String value){
        Jedis resource = null;
        try {
            resource = RedisPool.getResourcr();
            resource.setex(key,ss,value);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
            throw new RuntimeException(e);
        } finally {
            if(null != resource){
                resource.close();
            }
        }
    }
    //调用redis设置key的生命周期
    public static void expire(String key,int ss){
        Jedis resource = null;
        try {
            resource = RedisPool.getResourcr();
            resource.expire(key,ss);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
            throw new RuntimeException(e);
        } finally {
            if(null != resource){
                resource.close();
            }
        }
    }
}
