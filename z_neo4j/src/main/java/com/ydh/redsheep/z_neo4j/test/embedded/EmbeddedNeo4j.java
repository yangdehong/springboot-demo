package com.ydh.redsheep.z_neo4j.test.embedded;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class EmbeddedNeo4j {
    private static final File databaseDirectory = new File("target/graph.db");

    public static void main(String[] args) {
        add();
        query();
    }

    private static void add() {
        // 创建数据库服务对象
        GraphDatabaseService graphDatabaseService = new GraphDatabaseFactory().newEmbeddedDatabase(databaseDirectory);
        System.out.println("database load!");
        // 获取事务  开启事务
        Transaction tx = graphDatabaseService.beginTx();
        // 方法一
        Node n1 = graphDatabaseService.createNode();
        n1.setProperty("name", "张三");
        n1.setProperty("character", "A");
        n1.setProperty("money", 1101);
        n1.addLabel(new Label() {
            @Override
            public String name() {
                return "Person";
            }
        });
        // 方法二，定义cql
        String cql = "CREATE(p:Person {name:'李四',character:'B',money:21000})";
        graphDatabaseService.execute(cql);
        tx.success();
        tx.close();
        graphDatabaseService.shutdown();
        System.out.println("database shutdown");
    }

    private static void query() {
        // 创建数据库服务对象
        GraphDatabaseService graphDatabaseService = new GraphDatabaseFactory().newEmbeddedDatabase(databaseDirectory);
        System.out.println("database load!");
        String cql = "MATCH(p:Person) where p.money < $money return p";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("money", 25000);
        // 获取事务  开启事务
        Transaction tx = graphDatabaseService.beginTx();
        Result result = graphDatabaseService.execute(cql, parameters);
        while (result.hasNext()) {
            Map<String, Object> row = result.next();
            System.out.println(row);
            for (String key : result.columns()) {
                Node nd = (Node) row.get(key);
                System.out.printf("%s=%s:%s%n", key, nd.getProperty("name"), nd.getProperty("money"));
            }
        }
        tx.success();
        tx.close();
        graphDatabaseService.shutdown();
    }


}
