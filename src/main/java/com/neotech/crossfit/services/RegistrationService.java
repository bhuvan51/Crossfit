package com.neotech.crossfit.services;

import com.neotech.crossfit.dao.RegistrationDao;
import com.neotech.crossfit.entity.RegistrationRequestEntity;
import com.neotech.crossfit.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vinna on 11/8/2017.
 */
@Component
public class RegistrationService {

    @Autowired
    RegistrationDao registrationDao;

    public Object[] getregistrationdetails(RegistrationRequest registrationRequest){

        String errorCode= "";
        RegistrationRequestEntity requestEntity  = registrationDao.getUserNames(registrationRequest);

        if(requestEntity == null){
            errorCode = "200";
            RegistrationRequestEntity registrationRequestEntity = registrationDao.InsertUserRegistration(registrationRequest);
        }else{
            errorCode = "500";
        }
        return  new Object[]{errorCode};
    }
}
