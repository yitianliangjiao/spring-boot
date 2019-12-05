package com.wrh.springboot.AOPDemo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

@Aspect
@Component
public class BeforeExample {
    @Autowired
    HttpServletResponse response;

    @Around("com.wrh.springboot.AOPDemo.NotVeryUsefulAspect.dataAccessOperation()")
    public Object doAccessCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        response.setContentType("application/json;charset=utf-8");
        Object[] args = joinPoint.getArgs();
        Object result = joinPoint.proceed(args);
        Object[] args2 = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class[] types = signature.getParameterTypes();
        Object[] names = signature.getParameterNames();
        Object[] methodtypes = method.getParameterTypes();
        Annotation[] Annotations = method.getAnnotations();
        HashMap<String,Object> maps = new HashMap<>();
        for (int i=0;i<types.length;i++)
        {
           if( "org.springframework.ui.ModelMap".equals(types[i].getName()))
           {
               ModelMap map = (ModelMap) args2[i];
               for(Map.Entry<String, Object> s :map.entrySet())
               {
                   maps.put(s.getKey(),s.getValue());
               }
           }
        }
        System.out.println("我就试试行不行11");
        System.out.println("我就试试行不行11");
        String a = JSON.toJSONString(maps);
        response.setContentLength(a.getBytes().length);
        response.getOutputStream().write(a.getBytes());
        return  null;
    }
}
