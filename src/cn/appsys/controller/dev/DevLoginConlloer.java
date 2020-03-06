package cn.appsys.controller.dev;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.dev.DevService;

@Controller
@RequestMapping("/dev")
public class DevLoginConlloer {
		
		@Resource
		private DevService devService;
	
		//跳转到后台登录页面
		@RequestMapping("/login")
		public String login(){
			return "devlogin";
		}
		
		
		//登录
		@RequestMapping("/dologin")
		public String dologin(@RequestParam("devCode")String devCode,
				@RequestParam("devPassword")String devPassword,
				HttpSession session,HttpServletRequest request){
			
			DevUser devUser = devService.login(devCode);
			if(devUser.getDevPassword().equals(devPassword)){
				session.setAttribute("devSession", devUser);
				return "/backend/main";
			}else {
				request.setAttribute("error", "用户名或密码错误！");
				return "devlogin";
			}
				
			
		}
}
