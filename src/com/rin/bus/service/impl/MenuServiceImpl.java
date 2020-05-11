package com.rin.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rin.bus.domain.Menu;
import com.rin.bus.mapper.MenuMapper;
import com.rin.bus.service.MenuService;
import com.rin.bus.vo.MenuVo;

@Service
public class MenuServiceImpl implements MenuService {
	
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> queryAllMenuForList(MenuVo menuVo) {
		return menuMapper.queryAllMenu(menuVo);
	}

}
