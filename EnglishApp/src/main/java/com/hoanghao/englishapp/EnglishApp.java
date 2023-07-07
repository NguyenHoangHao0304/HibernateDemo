/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.hoanghao.englishapp;

import com.hoanghao.service.JdbcUtils;
import com.hoanghao.service.QuestionService;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class EnglishApp {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        QuestionService.getQuestion(2).forEach(q -> {
            System.out.println(q.getConTent());
            
            for(int i = 0; i<q.getChoices().size(); i++)
                System.out.printf("%d - %s\n", i+1 , q.getChoices().get(i).getContent());
            System.out.print("Your choice = ");
            int idx = sc.nextByte();
            
            if(q.getChoices().get(idx - 1).isCorrect() == true)
                System.out.println("Correct !!!");
            else
                System.out.println("inCorrect !!!");
        });
//        try(Connection conn = JdbcUtils.getConn()){
//            CallableStatement stm = conn.prepareCall("{ CALL getQuestions(?)}");
//            stm.setString(1, "sua");
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()){
//                String content = rs.getString("content");
//                System.out.println(content);
//            }
//            CallableStatement stm2 = conn.prepareCall("{ CALL countQuestions(?,?) }");
//            stm2.setInt(1, 123);
//            stm2.registerOutParameter(2, Types.INTEGER);
//            stm2.execute();
//            
//            System.out.println(stm2.getInt(2));
//        }
    }
}
