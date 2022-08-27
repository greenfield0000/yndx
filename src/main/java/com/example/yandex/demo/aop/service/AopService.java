package com.example.yandex.demo.aop.service;

import com.example.yandex.demo.aop.aspects.logger.PointCutLogger;
import com.example.yandex.demo.aop.exception.CustopAopException;
import org.springframework.stereotype.Service;

/**
 * @author Ivanov Roman
 */
@Service
public class AopService {

    public String doAop1() {
        return "doAop1 OK!";
    }

    @PointCutLogger
    public String doAop2() {
        return "doAop2 OK!";
    }

    public String doAop3() {
        return "doAop3 OK!";
    }

    public void doAop4Throwing() throws CustopAopException {
        throw new CustopAopException("Call doAop4Throwing exception message");
    }

}
