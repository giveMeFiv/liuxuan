package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.springbootlog.annotation.SystemControllerLog;
import com.example.demo.utils.ExecutionResult;
import com.example.demo.utils.ReturnCode;

import java.util.List;
/**
 *	查询用户信息 
 * 
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userService ;

    @RequestMapping(value = "/userlist")
    @SystemControllerLog(descrption = "查询用户信息",actionType = "4")
    public ExecutionResult getUserList(String id) throws Exception{

        ExecutionResult result = new ExecutionResult();
       
       List<User> users = userService.findAll() ;
       try {  result.setTotal(users.size());
            result.setResultCode(ReturnCode.RES_SUCCESS);
            result.setFlag(true);
            result.setData(users);
            result.setMsg("查询成功！");
            //异常处理
        //  int aa= 5/0;
            }catch (Exception e){
            result.setFlag(true);
            result.setData(null);
            result.setResultCode(ReturnCode.RES_FAILED);
            result.setMsg("查询失败！");
            throw e ;
        }
        return result ;
    }

}
