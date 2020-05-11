package com.rin.bus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rin.bus.domain.Customer;

public interface CustomerMapper {
	/**
     * 登陆
     */
	Customer login(Customer customer);
    int deleteByPrimaryKey(String identity);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String identity);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    List<Customer> queryAllCustomer(Customer customer);
    
	Customer getOldPwd(@Param("identity")String identity, @Param("oldPwd")String oldPwd);
	
	int changePwd(@Param("identity")String identity,@Param("oldPwd") String oldPwd,@Param("confirmPwd") String confirmPwd);
	
	int changeUser(@Param("identity")String identity, @Param("realname")String realname, @Param("usersex")Integer usersex, @Param("phone")String phone,@Param("province") String province);
	
}