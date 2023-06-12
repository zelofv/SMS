package com.example.sms.service;

import com.example.sms.entity.Classes;

/**
 * @projectName: SMS
 * @author: zelofv
 * @date: 2023/6/5 19:20
 */
public interface ClassesService {

    Classes getClassesByTid(String tid);
}
