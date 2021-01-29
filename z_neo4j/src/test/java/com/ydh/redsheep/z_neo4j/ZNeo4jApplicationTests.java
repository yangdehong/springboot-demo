package com.ydh.redsheep.z_neo4j;

import com.ydh.redsheep.z_neo4j.pojo.Person;
import com.ydh.redsheep.z_neo4j.repository.PersonRepository;
import com.ydh.redsheep.z_neo4j.service.Neo4jPersonService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ZNeo4jApplicationTests {

    @Resource
    private Neo4jPersonService personService;

    @Test
    void contextLoads() {
        Person person = new Person();
        person.setName("testboot");
        person.setMoney(12345.45);
        person.setCharacter("A");
        person.setAge(11);
        Person p1 = personService.save(person);
        System.out.println(p1);
        System.out.println(personService.getAll());
        List<Person> personList = personService.personList(1000);
        System.out.println(personList);
        List<Person> personList2 = personService.shortestPath("王启年", "九品射手燕小乙");
        System.out.println(personList2);
        List<Person> personList3 = personService.personListDept("范闲");
        for (Person pe : personList3) {
            System.out.println(pe);
        }

    }

}
