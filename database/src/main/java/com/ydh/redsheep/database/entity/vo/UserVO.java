package com.ydh.redsheep.database.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-08-25 16:37:53
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {
    private static final long serialVersionUID = 586495604025421958L;
    /**
     * id
     */
    private Long id;

    private String name;

    private Integer age;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime birthDay;

    private Integer version;

    private Integer isDeleted;

}
