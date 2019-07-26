package com.fh.shop.api.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
    //生成全局的连接公其他类直接调用
    private static JedisPool jedisPool;
    //声明私有方法进行连接redis
    public static void initResource(){
        //创建连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置总链接数
        jedisPoolConfig.setMaxTotal(1000);
        //设置闲置时最大连接
        jedisPoolConfig.setMaxIdle(100);
        //设置闲置时最小连接
        jedisPoolConfig.setMinIdle(100);
        //验证
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        //通过IP连接
        jedisPool = new JedisPool("192.168.124.29", 6379);
    }
    //静态语句块，类加载后第一个执行
    static {
        initResource();
    }
    //设置公共访问方法
    public static Jedis getResourcr(){
        return jedisPool.getResource();
    }
}
