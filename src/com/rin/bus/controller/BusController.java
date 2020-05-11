package com.rin.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 业务管理的路由控制器
 * @author Rin
 *
 */
@Controller
@RequestMapping("bus")
public class BusController {

	
	
	/**
	 * 跳转到车辆管理的页面
	 */
	@RequestMapping("toCarManager")
	public String toCarManager() {
		return "carManager";
	}
	

	/**
	 *
	/**
	 * 跳转到出租单管理的页面
	 */
	@RequestMapping("toRentManager")
	public String toRentManager() {
		return "rentManager";
	}
	
	
}
