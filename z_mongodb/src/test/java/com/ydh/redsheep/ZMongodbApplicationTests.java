package com.ydh.redsheep;

import com.ydh.redsheep.bean.Resume;
import com.ydh.redsheep.repository.ResumeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZMongodbApplicationTests {

	@Resource
	private MongoTemplate mongoTemplate;
	@Resource
	private ResumeRepository resumeRepository;

	@Test
	public void test() {
		List list = mongoTemplate.findAll(Object.class, "test");
		System.out.println(list);
	}
	@Test
	public void test2() {
		Resume resume  = new Resume();
		resume.setName("chengdaotest");
		resume.setExpectSalary(1);
		resume.setCity("bj");
		resumeRepository.save(resume);
		System.out.println(resumeRepository.findAll());
		System.out.println(resumeRepository.findByNameEquals("zhangsan"));
		System.out.println(resumeRepository.findByNameAndExpectSalary("zhangsan",25000));
	}

}
