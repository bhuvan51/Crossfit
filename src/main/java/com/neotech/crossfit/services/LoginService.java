package com.neotech.crossfit.services;

import com.neotech.crossfit.dao.LoginDao;
import com.neotech.crossfit.entity.LoginRequestEntity;
import com.neotech.crossfit.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vinna on 11/13/2017.
 */
@Component
public class LoginService {

    @Autowired
    LoginDao loginDao;

    public Object[] getLoginDetails(LoginRequest loginRequest){
        String errorCode= "";
        LoginRequestEntity loginEntity  = loginDao.getUserNames(loginRequest);

        if(loginEntity == null){
            errorCode = "200";

        }else{
            errorCode = "500";
        }
        return  new Object[]{errorCode};
    }
}
