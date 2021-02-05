package com.ydh.redsheep.cluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

public class ClusterTest {

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("172.16.131.10", 7001));
        jedisClusterNode.add(new HostAndPort("172.16.131.10", 7002));
        jedisClusterNode.add(new HostAndPort("172.16.131.10", 7003));
        jedisClusterNode.add(new HostAndPort("172.16.131.10", 7004));
        jedisClusterNode.add(new HostAndPort("172.16.131.10", 7005));
        jedisClusterNode.add(new HostAndPort("172.16.131.10", 7006));
        jedisClusterNode.add(new HostAndPort("172.16.131.10", 7007));
        jedisClusterNode.add(new HostAndPort("172.16.131.10", 7008));
        JedisCluster jcd = new JedisCluster(jedisClusterNode, config);
        jcd.set("name:099","testkey");
        String value = jcd.get("name:099");
        System.out.println(value);
    }

}
