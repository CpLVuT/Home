package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.Access;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor//无参构造注解
@Component
public class  member extends Relation {
    private String Name;
    private String Sex;
    private String Birth;
    private String Death;
    private int Member_Id;
    private int Mother_ID;
    private int Father_ID;//如果到了最下方 则两个都为0
}
