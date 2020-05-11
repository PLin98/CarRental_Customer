 package com.rin.bus.service;

import com.rin.bus.vo.CarVo;
import com.rin.bus.utils.DataGridView;

/**
 * 车辆管理的服务接口
 * @author Rin
 *
 */
public interface CarService {
	/**
	 * 查询所有车辆
	 * @param carVo
	 * @return
	 */
	public DataGridView queryAllCar(CarVo carVo);
	
	/**
	 * 修改车辆
	 * @param carVo
	 */
	public void updateCar(CarVo carVo);
}
