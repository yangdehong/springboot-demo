package com.ydh.redsheep.zes.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="position")
@Document(indexName = "position")
@Mapping(mappingPath = "es/position.json") //指向映射文件
public class Position implements Serializable {
    //主键
    @Id	//主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    private String id;

    //公司名称
    private String companyName;

    //职位名称
    private String positionName;

    //职位诱惑
    private String  positionAdvantage;

    //薪资
    private String salary;

    //薪资下限
    private int salaryMin;

    //薪资上限
    private int salaryMax;

    //学历
    private String education;

    //工作年限
    private String workYear;

    //发布时间
    private String publishTime;

    //工作城市
    private String city;

    //工作地点
    private String workAddress;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //工作模式
    private String jobNature;
}
