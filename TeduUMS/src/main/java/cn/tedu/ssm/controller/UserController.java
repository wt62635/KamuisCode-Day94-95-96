package cn.tedu.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ssm.entity.User;
import cn.tedu.ssm.mapper.UserMapper;
import cn.tedu.ssm.util.JsonResult;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("reg.do")
	public String showRegister() {
		return "reg";
	}
	
	@RequestMapping("handle_register.do")
	@ResponseBody
	public JsonResult<Void> handleRegister(User user) {
		System.out.println("UserController.handlerRegister()");
		System.out.println("\t" + user);
		
		JsonResult<Void> jr = new JsonResult<Void>();
		
		User result = userMapper.findByUsername(user.getUsername());
		if (result != null) {
			System.out.println("\t注册失败！用户名已被占用！");
			jr.setState(0);
			jr.setMessage("注册失败！用户名已被占用！");
			return jr;
		}
		
		Integer rows = userMapper.addnew(user);
		System.out.println("\t注册成功, rows=" + rows);
		jr.setState(1);
		return jr;
	}
	
	@RequestMapping("handle_login.do")
	@ResponseBody
	public JsonResult<Void> handleLogin(
			String username, String password) {
		// 创建返回值对象
		JsonResult<Void> jr = new JsonResult<Void>();
		// 根据用户名查询数据
		User result = userMapper.findByUsername(username);
		// 判断查询结果是否为null
		if (result == null) {
			// 是：用户名不存在
			jr.setState(2);
			jr.setMessage("用户名不存在！");
		} else {
			// 否：将查询结果中的密码与参数password进行对比，判断是否一致
			if (result.getPassword().equals(password)) {
				// 是：登录成功
				jr.setState(1);
			} else {
				// 否：密码错误
				jr.setState(3);
				jr.setMessage("密码错误！");
			}
		}
		return jr;
	}

}




