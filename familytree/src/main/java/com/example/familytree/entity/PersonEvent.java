package com.example.familytree.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName person_event
 */
@TableName(value ="person_event")
@Data
public class PersonEvent implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 
     */
    private Integer personId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date eventDate;

    /**
     * 
     */
    private Integer typeId;

    /**
     * 
     */
    private String eventDesc;


    /**
     * 
     */
    private String isDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}