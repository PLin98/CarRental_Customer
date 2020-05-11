package com.rin.bus.service;

import java.util.List;

import com.rin.bus.domain.Rent;
import com.rin.bus.vo.RentVo;
import com.rin.bus.utils.DataGridView;

public interface RentService {

	/**
	 * 保存出租单信息
	 * @param rentVo
	 */
	void addRent(RentVo rentVo);

	/**
	 * 查询
	 * @param rentVo
	 */
	DataGridView queryAllRent(RentVo rentVo);


	/**
	 * 删除出租单
	 * @param rentid
	 */
	void deleteRent(String rentid);

	/**
	 *  根据出租单号查询出租单信息
	 * @param rentid
	 * @return
	 */
	Rent queryRentByRentId(String rentid);

	List<Rent> queryRent(String identity);

}
