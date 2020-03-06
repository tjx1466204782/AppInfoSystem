package cn.appsys.service.backend;

import cn.appsys.pojo.BackendUser;

public interface BanckendService {
	//登录方法
	public BackendUser login(String userCode);
}
