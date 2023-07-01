package com.example.familytree.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class PersonEventView {
    private Integer id;
    private Integer personId;
    private String personName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date eventDate;
    private String typeId;
    private String typeName;

    private String eventDesc;

}
