package com.example.yandex.demo.aop.resource;

import com.example.yandex.demo.aop.aspects.logger.PointCutLogger;
import com.example.yandex.demo.aop.exception.CustopAopException;
import com.example.yandex.demo.aop.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivanov Roman
 */
@RestController
@RequestMapping(path = "/aop")
public class AopResource {

    private final AopService aopService;

    @Autowired
    public AopResource(AopService aopService) {
        this.aopService = aopService;
    }

    @ResponseBody
    @RequestMapping(path = "/test"
            , method = RequestMethod.GET
            , produces = "application/json"
    )
    public void doAop() {
        aopService.doAop1();
        aopService.doAop2();
        aopService.doAop3();
    }

    @RequestMapping(path = "throw"
            , consumes = "application/json"
            , method = RequestMethod.GET
    )
    public void AopThrowing() throws CustopAopException {
        aopService.doAop4Throwing();
    }

}
