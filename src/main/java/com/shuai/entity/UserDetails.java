package com.shuai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetails {
    private Integer id;
    private Integer uid;
    private String Details;
    private Date createDate;
}
