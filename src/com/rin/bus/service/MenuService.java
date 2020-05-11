package com.rin.bus.service;

import java.util.List;

import com.rin.bus.domain.Menu;
import com.rin.bus.vo.MenuVo;


/**
 * 菜单管理的服务接口
 * @author Rin
 *
 */
public interface MenuService {

	/**
	 * 查询所有菜单返回
	 * List<Menu>
	 */
	public List<Menu> queryAllMenuForList(MenuVo menuVo);
	
	
}
