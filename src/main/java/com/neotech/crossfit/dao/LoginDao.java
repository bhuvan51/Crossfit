package com.neotech.crossfit.dao;

import com.neotech.crossfit.entity.LoginRequestEntity;
import com.neotech.crossfit.persistence.HibernateUtil;
import com.neotech.crossfit.request.LoginRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

/**
 * Created by vinna on 11/13/2017.
 */
@Component
public class LoginDao {

    public LoginRequestEntity getUserNames(LoginRequest loginRequest)
    {
        LoginRequestEntity loginEntity=null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.flush();
        Criteria criteria = session.createCriteria(LoginRequestEntity.class)
                .add(Restrictions.eq("userName", loginRequest.getUserName()))
                .add(Restrictions.eq("password", loginRequest.getPassword()));

        // Convenience method to return a single instance that matches the
        // query, or null if the query returns no results.
        Object result = criteria.uniqueResult();
//        List result = criteria.list();
        if (result != null) {
            loginEntity = (LoginRequestEntity) result;
        }
        session.getTransaction().commit();
        return loginEntity;
    }
}
