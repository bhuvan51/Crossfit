package com.neotech.crossfit.dao;

import com.neotech.crossfit.entity.RegistrationRequestEntity;
import com.neotech.crossfit.persistence.HibernateUtil;
import com.neotech.crossfit.request.LoginRequest;
import com.neotech.crossfit.request.RegistrationRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vinna on 11/13/2017.
 */
@Component
public class RegistrationDao {

    public RegistrationRequestEntity getUserNames(RegistrationRequest registrationRequest)
    {
        RegistrationRequestEntity requestEntity=null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.flush();
        Criteria criteria = session.createCriteria(RegistrationRequestEntity.class)
                .add(Restrictions.eq("userName", registrationRequest.getUserName()));

        // Convenience method to return a single instance that matches the
        // query, or null if the query returns no results.
        Object result = criteria.uniqueResult();
//        List result = criteria.list();
        if (result != null) {
            requestEntity = (RegistrationRequestEntity) result;
        }
        session.getTransaction().commit();
        return requestEntity;
    }

    public RegistrationRequestEntity InsertUserRegistration(RegistrationRequest registrationRequest)
    {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        RegistrationRequestEntity registrationRequestEntity = new RegistrationRequestEntity();
        registrationRequestEntity.setRegistration_id(registrationRequest.getRegistration_id());
        registrationRequestEntity.setUserName(registrationRequest.getUserName());
        registrationRequestEntity.setPassword(registrationRequest.getPassword());
        registrationRequestEntity.setSex(registrationRequest.getSex());
        registrationRequestEntity.setType(registrationRequest.getType());
        registrationRequestEntity.setAge(registrationRequest.getAge());

        session.save(registrationRequestEntity);
        session.getTransaction().commit();
        return registrationRequestEntity;
    }
}
