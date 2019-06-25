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
			System.out.println("\tע��ʧ�ܣ��û����ѱ�ռ�ã�");
			jr.setState(0);
			jr.setMessage("ע��ʧ�ܣ��û����ѱ�ռ�ã�");
			return jr;
		}
		
		Integer rows = userMapper.addnew(user);
		System.out.println("\tע��ɹ�, rows=" + rows);
		jr.setState(1);
		return jr;
	}
	
	@RequestMapping("handle_login.do")
	@ResponseBody
	public JsonResult<Void> handleLogin(
			String username, String password) {
		// ��������ֵ����
		JsonResult<Void> jr = new JsonResult<Void>();
		// �����û�����ѯ����
		User result = userMapper.findByUsername(username);
		// �жϲ�ѯ����Ƿ�Ϊnull
		if (result == null) {
			// �ǣ��û���������
			jr.setState(2);
			jr.setMessage("�û��������ڣ�");
		} else {
			// �񣺽���ѯ����е����������password���жԱȣ��ж��Ƿ�һ��
			if (result.getPassword().equals(password)) {
				// �ǣ���¼�ɹ�
				jr.setState(1);
			} else {
				// ���������
				jr.setState(3);
				jr.setMessage("�������");
			}
		}
		return jr;
	}

}




