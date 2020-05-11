package com.rin.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rin.bus.domain.Car;
import com.rin.bus.domain.Rent;
import com.rin.bus.mapper.CarMapper;
import com.rin.bus.mapper.RentMapper;
import com.rin.bus.service.RentService;
import com.rin.bus.vo.RentVo;
import com.rin.bus.constast.SysConstast;
import com.rin.bus.utils.DataGridView;

@Service
public class RentServiceImpl implements RentService {
	
	@Autowired
	private RentMapper rentMapper;
	
	@Autowired
	private CarMapper carMapper;

	@Override
	public void addRent(RentVo rentVo) {
		this.rentMapper.insertSelective(rentVo);
		//更改车辆的出租状态
		Car car=new Car();
		car.setCarnumber(rentVo.getCarnumber());
		car.setIsrenting(SysConstast.RENT_CAR_TRUE);
		carMapper.updateByPrimaryKeySelective(car);
	}
	
	@Override
	public List<Rent> queryRent(String identity) {
		return this.rentMapper.queryRent(identity);
	}
	
	@Override
	public DataGridView queryAllRent(RentVo rentVo) {
		Page<Object> page=PageHelper.startPage(rentVo.getPage(), rentVo.getLimit());
		List<Rent> data = this.rentMapper.queryAllRent(rentVo);
		return new DataGridView(page.getTotal(), data);
	}


	@Override
	public void deleteRent(String rentid) {
		//更改汽车的状态
		Rent rent=this.rentMapper.selectByPrimaryKey(rentid);
		Car car=new Car();
		car.setCarnumber(rent.getCarnumber());
		car.setIsrenting(SysConstast.RENT_CAR_FALSE);
		carMapper.updateByPrimaryKeySelective(car);
		//删除出租单
		this.rentMapper.deleteByPrimaryKey(rentid);
	}

	@Override
	public Rent queryRentByRentId(String rentid) {
		return this.rentMapper.selectByPrimaryKey(rentid);
	}

	

}
