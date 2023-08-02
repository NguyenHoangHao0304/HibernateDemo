/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.hoanghao.hibernatedemo;

import com.hoanghao.pojo.Category;
import com.hoanghao.pojo.Product;
import com.hoanghao.repository.ProductRepository;
import com.hoanghao.repository.StatsRepository;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) throws ParseException {
        //TEST StatsRepository
//        StatsRepository s = new StatsRepository();
//        Map<String, String> params = new HashMap<>();
//        params.put("fromDate", "2020-11-17");
//        params.put("toDate", "2020-11-18");
//
//        params.put("quarter", "1");
//        params.put("year", "2020");
//        
//        s.statsRevenue(params).forEach(o -> System.out.printf("%d - %s - %d\n", o[0], o[1], o[2]));
//        s.statsRevenue(null).forEach(o -> System.out.printf("%d - %s - %d\n", o[0], o[1], o[2]));
//        s.countProductByCate().forEach(o -> System.out.printf("%d - %s - %d\n", o[0], o[1], o[2]));
            //TEST INSERT
//        Product p1 = new Product();
//        p1.setName("IP 13ProMax 513GB");
//        p1.setId(38);
//        p1.setActive(true);
//        p1.setPrice(60000000L);
//        Category c = ProductRepository.getCategoryID(1);
//        p1.setCategoryId(c);
//        ProductRepository.addProduct(p1);

            //TEST UPDATE
//            Product p = ProductRepository.getProductID(18);
//            Category c = ProductRepository.getCategoryID(2);
//            p.setName("iPhone 12 Pro");
//            p.setPrice(3323232L);
//            p.setCategoryId(c);
//            ProductRepository.updateProduct(p);
                //Test từ params
//              ProductRepository pro = new ProductRepository();
//              Map<String, String> params = new HashMap<>();
//              params.put("ProId", "18");
//              Product p = pro.getProducts(params).get(0);
//              p.setName("iPhone 12 Pro");
//              pro.updateProduct(p);
              
            //TEST DELETE
//              Product p = ProductRepository.getProductID(23);
//              ProductRepository.deleteProduct(p);

            //TEST ProductRepository
//        Map<String,String> params = new HashMap<>();
//        params.put("kw", "Galaxy");
//        params.put("toPrice", "50000000");
//        params.put("fromPrice", "30000000");
//        params.put("cateId", "2");
//        ProductRepository pro = new ProductRepository();
//        pro.getProducts(params).forEach(p -> System.out.printf("%d - %s - %s\n",
//                p.getId(),p.getName(),p.getPrice()));
            //TEST getALL
//            ProductRepository pro = new ProductRepository();
//            Map<String,String> params = new HashMap<>();
//            pro.getProducts(params).forEach(p -> System.out.printf("%d - %s - %s\n",
//                p.getId(),p.getName(),p.getPrice()));
    }
}
