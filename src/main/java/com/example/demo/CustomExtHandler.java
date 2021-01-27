package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.MyException;

@RestControllerAdvice
public class CustomExtHandler {


    @ExceptionHandler(value = {Exception.class})
    Object handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }
    
    @ExceptionHandler(value = {MyException.class})
    Object handleMyException(MyException e, HttpServletRequest request){
        //进行页面跳转
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error.html");
//        modelAndView.addObject("msg", e.getMsg());
//        return modelAndView;
    	 Map<String, Object> map = new HashMap<>();
         map.put("code", e.getCode());
         map.put("msg", e.getMsg());
         map.put("url", request.getRequestURL());
         return map;
    }

}
