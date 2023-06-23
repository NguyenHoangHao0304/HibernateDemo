/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.hoanghao.hibernatedemo;

import com.hoanghao.pojo.Product;
import com.hoanghao.repository.ProductRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
        ProductRepository pro = new ProductRepository();
        pro.getProducts(null).forEach(p -> System.out.printf("%d - %s\n",p.getId(),p.getName()));
    }
}
