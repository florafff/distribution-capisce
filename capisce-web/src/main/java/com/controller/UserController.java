package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.capisce.entity.NetValueEntity;
import com.capisce.entity.SelectPageEntity;
import com.capisce.entity.UserInfoEntity;
import com.capisce.entrance.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Reference(version = "1.0.0")
    private IUserService userService;

    @RequestMapping(value = "createNewAccount", method = RequestMethod.POST)
    public Boolean createNewAccount(@RequestBody UserInfoEntity userInfoEntity){
        return userService.createNewAccount(userInfoEntity);
    }

    @RequestMapping(value = "getNetValueSample", method = RequestMethod.POST)
    public List<NetValueEntity> getNetValueSample(@RequestBody SelectPageEntity selectPageEntity){
        return userService.getNetValueSample(selectPageEntity);
    }

    @RequestMapping(value = "insertMockNetValue", method = RequestMethod.POST)
    public int insertMockNetValue(@RequestBody NetValueEntity netValueEntity) throws ParseException {
        return userService.insertMockNetValue(netValueEntity);
    }
}
