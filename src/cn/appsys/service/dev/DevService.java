package cn.appsys.service.dev;

import cn.appsys.pojo.DevUser;

public interface DevService {
	
	//登录方法
	public DevUser login(String devCode);
}
