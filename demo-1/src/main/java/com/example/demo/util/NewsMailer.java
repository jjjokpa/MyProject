package com.example.demo.util;

import com.example.demo.domain.NewsVO;

public interface NewsMailer {
	
	public String sendMail(String mailAddress, NewsVO newsVo) ;

}
