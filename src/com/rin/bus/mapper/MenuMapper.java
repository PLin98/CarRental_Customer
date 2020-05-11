package com.rin.bus.mapper;

import java.util.List;


import com.rin.bus.domain.Menu;

public interface MenuMapper {
  
    
    /**
     * 查询所有菜单
     */
    List<Menu> queryAllMenu(Menu menu);

}