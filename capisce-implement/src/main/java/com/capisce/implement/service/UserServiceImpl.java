package com.capisce.implement.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.capisce.entity.NetValueEntity;
import com.capisce.entity.SelectPageEntity;
import com.capisce.entrance.IUserService;
import com.capisce.implement.dao.UserDao;
import com.capisce.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@Service(version = "1.0.0", interfaceClass = IUserService.class, timeout = 15000)
@Component
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public boolean createNewAccount(@RequestBody UserInfoEntity userInfoEntity) {
        return userDao.insert(userInfoEntity);
    }

    @Override
    public List<NetValueEntity> getNetValueSample(SelectPageEntity selectPageEntity) {
        return null;
    }

    @Override
    public int insertMockNetValue(NetValueEntity netValueEntity) throws ParseException {
        return 0;
    }
}
