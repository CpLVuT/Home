package com.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class user {
    private String user_name;
    private int user_no;
    private String password;
    private boolean id_del;
}
