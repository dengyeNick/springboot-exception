package com.example.demo.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.MyException;

@RestController
public class ExceptionController {
	
	@RequestMapping(value = "/api/v1")
	public Object index(){
	    int i= 1/0;
	    return "成功";
	}
	
	@RequestMapping(value = "/api/v2")
	public Object index2(){
		if(1==1) {
			throw new MyException("501", "存在未知错误");
		}
		
		return "成功";
	}
}
