/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hoanghao.pojo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Admin
 */
@Getter
@Setter
public class Question {
    private String iD;
    private String conTent;
    private int category_ID;
    private List<Choice> choices;
}
