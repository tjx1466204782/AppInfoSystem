package cn.appsys.dao.dev;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevMapper {
	
	//后台用户登录(获取用户编码)
	public DevUser getDevByCode(@Param("devCode")String devCode);
}
