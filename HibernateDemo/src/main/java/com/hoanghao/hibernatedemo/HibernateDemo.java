/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.hoanghao.hibernatedemo;

import com.hoanghao.pojo.Product;
import com.hoanghao.repository.ProductRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
        Map<String,String> params = new HashMap<>();
//        params.put("toPrice", "50000000");
        params.put("fromPrice", "30000000");
//        params.put("cateId", "1");
        ProductRepository pro = new ProductRepository();
        pro.getProducts(params).forEach(p -> System.out.printf("%d - %s - %.1f\n",
                p.getId(),p.getName(),p.getPrice()));
    }
}
