/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hoanghao.repository;

import com.hoanghao.hibernatedemo.HibernateUtils;
import com.hoanghao.pojo.Category;
import com.hoanghao.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepository {

    public List<Product> getProducts(Map<String, String> params) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();
                
                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()) {
                    predicates.add(b.like(root.get("name"),
                            String.format("%%%s%%", kw)));
                }

                String fromPrice = params.get("fromPrice");
                if (fromPrice != null && !fromPrice.isEmpty()) {
                    predicates.add(b.greaterThanOrEqualTo(root.get("price"),
                            Double.parseDouble(fromPrice)));
                }

                String toPrice = params.get("toPrice");
                if (toPrice != null && !toPrice.isEmpty()) {
                    predicates.add(b.lessThanOrEqualTo(root.get("price"),
                            Double.parseDouble(toPrice)));
                }

                String cateId = params.get("cateId");
                if (cateId != null && !cateId.isEmpty()) {
                    predicates.add(b.lessThanOrEqualTo(root.get("categoryId"),
                            Integer.parseInt(cateId)));
                }
                String ProductId = params.get("ProId");
                if (ProductId != null && !ProductId.isEmpty()) {
                    predicates.add(b.equal(root.get("id"),
                            Integer.parseInt(ProductId)));
                }

                q.where(predicates.toArray(Predicate[]::new));
            }

            q.orderBy(b.desc(root.get("id")));
            Query query = session.createQuery(q);
            return query.getResultList();
        }
    }

    public Product getProductByID(int id) {
        Product p;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            p = session.get(Product.class, id);
            session.close();
            return p;
        }
    }

    public Category getCategoryByID(int id) {
        Category p;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            p = session.get(Category.class, id);
            session.close();
            return p;
        }
    }

    public void insertProduct(Product product) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            session.getTransaction().begin();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public void deleteProduct(Product product) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            session.getTransaction().begin();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public void updateProduct(Product product) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            session.getTransaction().begin();
            session.update(product);
            session.getTransaction().commit();
        }
    }

}
