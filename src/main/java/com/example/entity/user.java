package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("users")
public class user {
    private String user_name;
    private int user_no;
    private String password;
    private boolean id_del;
}
