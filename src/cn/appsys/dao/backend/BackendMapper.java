package cn.appsys.dao.backend;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

public interface BackendMapper {
	
	//后台用户登录(获取用户编码)
	public BackendUser getBackendByCode(@Param("userCode")String userCode);
}
