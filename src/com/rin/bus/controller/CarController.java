package com.rin.bus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rin.bus.service.CarService;
import com.rin.bus.vo.CarVo;
import com.rin.bus.utils.DataGridView;

/**
 * 车辆管理控制器
 * 
 * @author Rin
 *
 */
@RestController
@RequestMapping("car")
public class CarController {

	@Autowired
	private CarService carService;

	/**
	 * 加载车辆列表返回DataGridView
	 */
	@RequestMapping("loadAllCar")
	public DataGridView loadAllCar(CarVo carVo) {
		return this.carService.queryAllCar(carVo);
	}
	
}
