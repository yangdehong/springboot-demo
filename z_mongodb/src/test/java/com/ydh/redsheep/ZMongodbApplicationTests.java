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
		for (int i=0; i<100; i++) {
			Resume resume  = new Resume();
			resume.setName("ydh"+i);
			resume.setExpectSalary(100*i);
			resume.setCity("bj"+i);
			resumeRepository.save(resume);
		}
		System.out.println(resumeRepository.findAll());
//			System.out.println(resumeRepository.findByNameEquals("zhangsan"));
//			System.out.println(resumeRepository.findByNameAndExpectSalary("zhangsan",25000));
	}

}
