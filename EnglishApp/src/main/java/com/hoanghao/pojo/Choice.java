/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hoanghao.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
    @Getter
    @Setter
public class Choice {
    private String id;
    private String content;
    private boolean correct;
    private String question_id;
}
