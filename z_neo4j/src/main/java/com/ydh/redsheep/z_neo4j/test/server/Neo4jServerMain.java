package com.ydh.redsheep.z_neo4j.test.server;


import org.neo4j.driver.*;

import static org.neo4j.driver.Values.parameters;

public class Neo4jServerMain {
    public static void main(String[] args) {
        query1();
        query2();
    }

    private static void query1() {
        Driver driver = GraphDatabase.driver("bolt://172.16.131.10:7687",
                AuthTokens.basic("neo4j", "123456"));
        // 获取会话对象
        Session session = driver.session();
        String cql = "MATCH(p:Person) WHERE p.money > $money return p.name AS name,p.money AS money " +
                " order by p.money";
        Result result = session.run(cql, parameters("money", 100));
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record.get("name").asString() + "," + record.get("money").asDouble());
        }
        session.close();
        driver.close();
    }

    private static void query2() {
        Driver driver = GraphDatabase.driver("bolt://172.16.131.10:7687",
                AuthTokens.basic("neo4j", "123456"));
        // 获取会话对象
        Session session = driver.session();
        String cql = "MATCH p=shortestPath((person:Person{name:$startName})-[*1..4]-(person2:Person {name:$endName})) return p";
        Result result = session.run(cql, parameters("startName", "王启年", "endName", "九品射手燕小乙"));
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record);
        }
        session.close();
        driver.close();
    }


}
