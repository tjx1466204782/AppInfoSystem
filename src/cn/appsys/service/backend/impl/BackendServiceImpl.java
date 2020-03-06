package cn.appsys.service.backend.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backend.BackendMapper;
import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BanckendService;

@Service
public class BackendServiceImpl implements BanckendService {
	
	//注入后台数据访问层对象
	@Resource
	private BackendMapper backendMapper;
	
	
	@Override
	public BackendUser login(String userCode) {
		return backendMapper.getBackendByCode(userCode);
	}

}
