package com.ydh.redsheep.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("resume")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    private String id;
    private String name;
    private String city;
    private Date birthday;
    private  double  expectSalary;
}
