package com.rin.bus.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rin.bus.domain.Customer;
import com.rin.bus.service.CustomerService;
import com.rin.bus.utils.WebUtils;


@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	/**
	 * 检查旧密码
	 */
	
	@RequestMapping("getOldPwd")
	public Map<String,String> getOldPwd(String oldPwd){
		Customer customer=(Customer) WebUtils.getHttpSession().getAttribute("customer");
		String identity = customer.getIdentity();
		oldPwd = DigestUtils.md5Hex(oldPwd); 
		Customer result=customerService.getOldPwd(identity,oldPwd);
		Map<String,String> data =new HashMap<String,String>();
		 	if(result!=null){
		 		data.put("msg", "1");
			}else{  
				data.put("msg", "0");
			}  
	    return data;
	  
	}
	
	/**
	 * 修改密码
	 */
	@RequestMapping("changePwd")
	public Map<String,String> changePwd(String oldPwd,String confirmPwd){
		Customer customer=(Customer) WebUtils.getHttpSession().getAttribute("customer");
		String identity = customer.getIdentity();
		oldPwd = DigestUtils.md5Hex(oldPwd);
		confirmPwd = DigestUtils.md5Hex(confirmPwd); 
		int result = customerService.changePwd(identity,oldPwd,confirmPwd);
		Map<String,String> data =new HashMap<String,String>();
	 	if(result>0){
	 		data.put("msg", "0"); 
		}else{  
			data.put("msg", "1");
		}  
	 	return data; 
	}
	
	/**
	 * 修改资料
	 */
	@ResponseBody
	@RequestMapping("changeUser")
	public Map<String,String> changeUser(String realname,String sex,String phone,String province){
		Customer customer=(Customer) WebUtils.getHttpSession().getAttribute("customer");
		String identity = customer.getIdentity();
		Integer usersex;
		if(sex.equals("男")) {
			usersex=1;
		}else if(sex.equals("女")){
			usersex=0;
		}else {
			usersex=2;
		}
		int result = customerService.changeUser(identity,realname,usersex,phone,province);
		Map<String,String> data =new HashMap<String,String>();
	 	if(result>0){
	 		data.put("msg", "0");
		}else{  
			data.put("msg", "1");
		}  
        return data;
	}
	
}
