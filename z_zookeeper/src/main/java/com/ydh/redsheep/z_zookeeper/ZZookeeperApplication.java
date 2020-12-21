//package com.ydh.redsheep.z_zookeeper;
//
//import com.ydh.redsheep.z_zookeeper.zk.util.CuratorClientFactory;
//import com.ydh.redsheep.z_zookeeper.zk.util.DistributeLockFactory;
//import org.apache.curator.framework.CuratorFramework;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class ZZookeeperApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ZZookeeperApplication.class, args);
//	}
//
//	@Value("${zookeeper.zkServer}")
//	private String zkServer;
//
//	@Bean
//	public CuratorFramework getCuratorFramework(){
//		return new CuratorClientFactory(zkServer).getCuratorClient();
//	}
//
//	@Autowired
//	private CuratorFramework curatorFramework;
//
//	@Bean
//	public DistributeLockFactory getDistributeLockFactory(){
//		return new DistributeLockFactory(curatorFramework);
//	}
//
//}
