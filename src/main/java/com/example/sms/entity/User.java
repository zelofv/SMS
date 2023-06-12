package com.example.ketangpai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 名称
 * @date 2022/8/28 21:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uid;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String avatar;
    private String identity;
    private String school;
    private String time;
    private String sid;
    private Boolean deleted;
}
