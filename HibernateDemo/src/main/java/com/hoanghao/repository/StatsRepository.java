/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hoanghao.repository;

import com.hoanghao.hibernatedemo.HibernateUtils;
import com.hoanghao.pojo.Category;
import com.hoanghao.pojo.OrderDetail;
import com.hoanghao.pojo.Product;
import com.hoanghao.pojo.SaleOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
 * @author Admin
 */
public class StatsRepository {

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public List<Object[]> countProductByCate() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root rP = q.from(Product.class);
            Root rC = q.from(Category.class);

            q.multiselect(rC.get("id"), rC.get("name"), b.count(rP.get("id")));

            q.where(b.equal(rP.get("categoryId"), rC.get("id")));
            q.groupBy(rC.get("id"));

            //Select c.id, c.name, count(p.id) From category c inner join product p on p.category_id = c.id group by c.id
            Query query = session.createQuery(q);
            return query.getResultList();
        }
    }

    public List<Object[]> statsRevenue(Map<String, String> params) throws ParseException {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root rP = q.from(Product.class);
            Root rD = q.from(OrderDetail.class);
            Root rO = q.from(SaleOrder.class);

            q.multiselect(rP.get("id"), rP.get("name"), b.sum(b.prod(rD.get("unitPrice"), rD.get("num"))));

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(b.equal(rD.get("productId"), rP.get("id")));
            predicates.add(b.equal(rD.get("orderId"), rO.get("id")));

            String fd = params.get("fromDate");
            if (fd != null && !fd.isEmpty()) {
                predicates.add(b.greaterThanOrEqualTo(rO.get("createdDate"), FORMAT.parse(fd)));
            }

            String td = params.get("toDate");
            if (td != null && !td.isEmpty()) {
                predicates.add(b.lessThanOrEqualTo(rO.get("createdDate"), FORMAT.parse(td)));
            }
            q.where(predicates.toArray(Predicate[]::new));

            String quarter = params.get("quarter");
            if (quarter != null && !quarter.isEmpty()) {
                String year = params.get("year");
                if (year != null && !year.isEmpty()) {
                    predicates.addAll(Arrays.asList(
                            b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), Integer.parseInt(year)),
                            b.equal(b.function("QUARTER", Integer.class, rO.get("createdDate")), Integer.parseInt(quarter))
                    ));
                }
            }

            q.groupBy(rP.get("id"));

            //Select c.id, c.name, count(p.id) From category c inner join product p on p.category_id = c.id group by c.id
            Query query = session.createQuery(q);
            return query.getResultList();
        }
    }
}
