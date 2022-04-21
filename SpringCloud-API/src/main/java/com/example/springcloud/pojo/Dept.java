package com.example.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lambda
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    /**SpringCloud中的所有的实体类都必须要实现序列化*/
    private long dbptno;
    private String dename;
    /**
     * 查看某个数据是存在哪个数据库的字段
     */
    private String db_source;

    public Dept(String dename) {
        this.dename = dename;
    }

    /**
     * @Accessors(chain = true)
     * 表示链式写法*/
}


