package com.example.familytree.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName family
 */
@TableName(value ="family")
@Data
public class Family implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String familyDesc;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String isDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}