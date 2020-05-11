package com.rin.bus.service;


import com.rin.bus.domain.Customer;
import com.rin.bus.vo.CustomerVo;

/**
 * 客户管理的服务接口
 * @author Rin
 *
 */
public interface CustomerService {
	Customer login(CustomerVo customerVo);

	Customer getOldPwd(String identity, String oldPwd);

	int changePwd(String identity, String oldPwd, String confirmPwd);

	int changeUser(String identity, String realname, Integer usersex, String phone, String province);
	

}
