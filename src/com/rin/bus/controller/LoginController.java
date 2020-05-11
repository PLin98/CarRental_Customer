package com.rin.bus.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rin.bus.constast.SysConstast;
import com.rin.bus.domain.Customer;
import com.rin.bus.service.CustomerService;
import com.rin.bus.service.LogInfoService;
import com.rin.bus.utils.WebUtils;
import com.rin.bus.vo.CustomerVo;
import com.rin.bus.vo.LogInfoVo;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

/**
 * 用户登陆控制器
 * 
 * @author Rin
 *
 */
@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private LogInfoService logInfoService;

	/**
	 * 跳转到登陆页面
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}

	/**
	 * 登陆方法
	 */
	@RequestMapping("login")
	public String login(CustomerVo customerVo, Model model) {
		String code=WebUtils.getHttpSession().getAttribute("code").toString();
		if(customerVo.getCode().equals(code)) {
			Customer customer = this.customerService.login(customerVo);
			if (null != customer) {
				// 放到session
				WebUtils.getHttpSession().setAttribute("customer", customer);
				// 记录登陆日志 向sys_login_log里面插入数据
				LogInfoVo logInfoVo = new LogInfoVo();
				logInfoVo.setLogintime(new Date());
				logInfoVo.setLoginname(customer.getCustname() + "-" + customer.getLoginname());
				logInfoVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());

				logInfoService.addLogInfo(logInfoVo);
				return "index";
			} else {
				model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);
				return "login";
			}
		}else {
			model.addAttribute("error", SysConstast.USER_LOGIN_CODE_ERROR_MSG);
			return "login";
		}
		
	}

	/**
	 * 得到登陆验证码
	 * @throws IOException 
	 */
	@RequestMapping("getCode")
	public void getCode(HttpServletResponse response,HttpSession session) throws IOException {
		// 定义图形验证码的长和宽
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36,4,5);
		session.setAttribute("code", lineCaptcha.getCode());
		ServletOutputStream outputStream = response.getOutputStream();
		ImageIO.write(lineCaptcha.getImage(), "JPEG", outputStream);
	}
	
	

}
