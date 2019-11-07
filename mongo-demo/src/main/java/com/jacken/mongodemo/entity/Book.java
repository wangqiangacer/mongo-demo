package com.jacken.mongodemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data

public class Book {
    @Id
    private String id;
    //价格
    private Integer price;
    //书名
    private String name;
    //简介
    private String info;
    //出版社
    private String publish;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
