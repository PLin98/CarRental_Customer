package com.rin.bus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rin.bus.constast.SysConstast;
import com.rin.bus.domain.Menu;
import com.rin.bus.service.MenuService;
import com.rin.bus.utils.TreeNode;
import com.rin.bus.utils.TreeNodeBuilder;
import com.rin.bus.vo.MenuVo;

/**
 * 菜单管理控制器
 * 
 * @author Rin
 *
 */
@RestController
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("loadIndexLeftMenuJson")
	public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo){
		//得到当前登陆的用户对象
		List<Menu> list=null;
		menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
		list=this.menuService.queryAllMenuForList(menuVo);
		List<TreeNode> nodes= new ArrayList<>();
		//把list里面的数据放到nodes
		for (Menu menu : list) {
			Integer id=menu.getId();
			Integer pid=menu.getPid();
			String title=menu.getTitle();
			String icon=menu.getIcon();
			String href=menu.getHref();
			Boolean spread=menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
			String target=menu.getTarget();
			nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
		}
		return TreeNodeBuilder.builder(nodes, 1);
	}
	
	
}
