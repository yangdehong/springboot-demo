package com.ydh.redsheep.sharding.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_order")
public class TOrder {

    private long id;

    private Integer companyId;

    private long positionId;

    private Integer userId;

    private Integer publishUserId;

    private Integer resumeType;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime operateTime;

    private String workYear;

    private String name;

    private String positionName;

    private Integer resumeId;

}
