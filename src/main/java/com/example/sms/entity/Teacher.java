package com.example.ketangpai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 名称
 * @date 2022/8/29 14:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private String uid;
    private String name;
    private String tid;

    public Teacher(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }
}
