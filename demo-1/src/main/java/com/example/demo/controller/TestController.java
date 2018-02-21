package com.example.demo.controller;

import java.security.Principal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.UserVO;
import com.example.demo.repository.UserRepository;


@Controller
public class TestController {

	static Logger logger = Logger.getLogger(TestController.class);

	@Autowired
	public HttpSession httpSession;
	
	@Autowired
	public UserRepository userDao;

	@RequestMapping(value = "/user")
	public String user(Principal principal) {

		logger.info("Request user");
		Map<String, Object> details = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication()
				.getDetails();

		String email = (String) details.get("email");
		String name = (String) details.get("name");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("email", email);
		map.put("name", name);
		
		userDao.save(new UserVO(email, name, 0, new Date()));
		
		//UserVO userVO = userDao.save(entity)


		httpSession.setAttribute("email", map.get("email"));
		logger.info("getSession email :" + httpSession.getAttribute("email"));

		return "main";
	}

	@RequestMapping(value = "/logout")
	public String logout() {

		logger.info("!!!!!!!!!!! logout1");
		logger.info("getSession email1 :" + httpSession.getAttribute("email"));
		
		if (httpSession.getAttribute("email") != null) {
			httpSession.invalidate();
		}
		
		logger.info("!!!!!!!!!!! logout2");
		logger.info("getSession email2 :" + httpSession.getAttribute("email"));
		
		return "logout";
	}
	
	@RequestMapping(value = "")
	public String login() {

		return "login";
	}

}
