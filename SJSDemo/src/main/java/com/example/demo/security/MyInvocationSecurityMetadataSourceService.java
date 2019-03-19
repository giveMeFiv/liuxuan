package com.example.demo.security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AuthDao;
import com.example.demo.entity.Authority;

@Service
public class MyInvocationSecurityMetadataSourceService implements
        FilterInvocationSecurityMetadataSource{
    @Autowired
    private AuthDao authdao;

    private HashMap<String , Collection<ConfigAttribute>> map=null;
    
    /*
     * 系统启动后，首次有用户访问，加载权限表中所有权限。以便拦截无权放访问的用户请求。
     *
     * wzh增加了注释描述。
     */
    public void loadResourceDefine(){

        map=new HashMap<>();

        Collection<ConfigAttribute> array;

        ConfigAttribute cfg;

        List<Authority> permissions=authdao.findAll();
        System.out.println("我是MyInvocationSecurityMetadataSourceService的方法");
        for(Authority permission:permissions){

            array = new ArrayList<>();

            cfg=new SecurityConfig(permission.getName());
            System.out.println(permission.getName()+"++++++++++"+permission.getUrl());
            //此处只添加了权限的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。
            System.out.println(cfg.toString()+"++++++++"+"cfg");
            array.add(cfg);

            //用权限的getUrl（）作为map的key，用ConfigAttribute的集合作为value
            
            map.put(permission.getUrl(), array);

        }

    }

    /*

     * 此方法是为了判定用户请求的url是否再权限表中，如果在权限表中，则返回给decide方法，

     * 用来判定用户是否有此权限。如果不在权限表中则放行。

     *

     * 方法的目的是：确定该请求是否需要进行访问权限的判断，对于需要判断权限的请求，返回resUrl对应的权限数组，对于不需要

     * 进行权限判断的请求，返回Null

     */

     @Override

        public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

            if(map ==null) loadResourceDefine();

            HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
            //打印拦截器 
            System.out.println(((FilterInvocation) object).toString());

            AntPathRequestMatcher matcher;

            String resUrl;
            //将所有权限 以及url进行遍历  用resUrl 进行接受url的路径“/aaa/bbb” 用AntPathRequestMatcher 进行包装
            // 如果和请求的request匹配 说明有权限 return 权限
            for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {

                resUrl = iter.next();

                //当url里有？的时候  进行切割   

                if(resUrl.indexOf("?")>-1){

                    resUrl=resUrl.substring(0,resUrl.indexOf("?"));

                }

                matcher = new AntPathRequestMatcher(resUrl);

                if(matcher.matches(request)) {

                    return map.get(resUrl);

                }

            }

            return null; //

        }

 

        @Override

        public Collection<ConfigAttribute> getAllConfigAttributes() {

            return null;

        }

 

        @Override

        public boolean supports(Class<?> clazz) {

            return true;

        }

}
