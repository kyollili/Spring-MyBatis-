package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.study.springboot.dto.SimpleBbsDto;

public class SimpleBbsValidator implements Validator{
	 @Override
	    public boolean supports(Class<?> arg0) {
	        return SimpleBbsDto.class.isAssignableFrom(arg0); // 검증할 객체의 클래스 타입 정보
	    }
	    
	    @Override
	    public void validate(Object obj, Errors errors) {
	    	SimpleBbsDto dto = (SimpleBbsDto)obj;
	        
	        String sWriter = dto.getWriter();
	        if(sWriter == null || sWriter.trim().isEmpty()) {
	            System.out.println("Writer is null or empty");
	            errors.rejectValue("writer", "trouble");
	        }
	        
	        String sContent = dto.getContent();
	        if(sContent == null || sContent.trim().isEmpty()) {
	            System.out.println("Content is null or empty");
	            errors.rejectValue("content", "trouble");
	        }
	    }
}
