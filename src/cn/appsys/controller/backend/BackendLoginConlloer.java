package cn.appsys.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BanckendService;

@Controller
@RequestMapping("/manage")
public class BackendLoginConlloer {
	
	//注入BanckendService对象
	@Resource
	private BanckendService banckendService;
	
	
	//跳转到后台登录页面
	@RequestMapping("/login")
	public String login(){
		return "backendlogin";
	}
	
	@RequestMapping("/dologin")
	public String doLogin(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,
			HttpSession session,HttpServletRequest request){
		//调用业务层方法，获取到后台用户对象
		BackendUser user = banckendService.login(userCode);
		//进行判断
		if(user.getUserPassword().equals(userPassword)){
			session.setAttribute("userSession", user);
			return "/backend/main";
		}else {
			request.setAttribute("error", "用户名或密码错误！");
			return "backendlogin";
		}
		
	}
}
