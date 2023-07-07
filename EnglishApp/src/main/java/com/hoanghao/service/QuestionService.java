/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hoanghao.service;

import com.hoanghao.pojo.Choice;
import com.hoanghao.pojo.Question;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Admin
 */
public class QuestionService {
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    private static JdbcTemplate t = (JdbcTemplate) ctx.getBean("t");
    
    public static List<Question> getQuestion(int n){
        return t.query("SELECT * FROM question LIMIT ?", (rs, num)->{
            Question q = new Question();
            String id = rs.getString("id");
            q.setID(id);
            q.setConTent(rs.getString("content"));
            q.setCategory_ID(rs.getInt("category_id"));
            q.setChoices(getChoice(id));
            
            return q;
        },n);
    }
    public static List<Choice> getChoice(String questionId){
        return t.query("SELECT * FROM choice WHERE question_id =?", (rs, num) ->{
            Choice c = new Choice();
            c.setId(rs.getString("id"));
            c.setContent(rs.getString("content"));
            c.setCorrect(rs.getBoolean("is_correct"));
            c.setQuestion_id(questionId);
            
            return c;
        },questionId);
    }
}
