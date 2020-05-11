package com.rin.bus.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.rin.bus.domain.Customer;
import com.rin.bus.mapper.CustomerMapper;
import com.rin.bus.service.CustomerService;
import com.rin.bus.vo.CustomerVo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Customer login(CustomerVo customerVo) {
		// 明文123456
		// 生成密文
		String pwd = DigestUtils.md5DigestAsHex(customerVo.getPwd().getBytes());
		customerVo.setPwd(pwd);
		return customerMapper.login(customerVo);
	}

	@Override
	public Customer getOldPwd(String identity, String oldPwd) {
		return this.customerMapper.getOldPwd(identity,oldPwd);
		
	}

	@Override
	public int changePwd(String identity, String oldPwd, String confirmPwd) {
		// TODO Auto-generated method stub
		return this.customerMapper.changePwd(identity,oldPwd,confirmPwd);
	}

	@Override
	public int changeUser(String identity, String realname, Integer usersex, String phone, String province) {
		// TODO Auto-generated method stub
		return this.customerMapper.changeUser(identity,realname,usersex,phone,province);
	}
}
