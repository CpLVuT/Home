package com.example.familytree.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class PersonRelationView {
    /**
     *
     */
    private Integer id;

    private Integer personId1;

    /**
     *
     */
    private String personName1;

    private Integer personId2;

    /**
     *
     */
    private String personName2;

    private Integer personTypeId;

    /**
     *
     */
    private String personTypeName;

    /**
     *
     */
    private String isDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
