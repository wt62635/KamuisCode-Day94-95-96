package cn.kamui.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * JDK动态代理
 * @author 曙光之刃
 *
 */
public class ProxyHandler implements InvocationHandler{
	private UserService service = new UserServiceImpl();
	private Logger logger = new Logger();
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		logger.log();
		service.saveUser();
		return null;
	}
	//返回动态代理对象
	public Object getProxy() {
		return Proxy.newProxyInstance(UserService.class.getClassLoader(), service.getClass().getInterfaces(), this);
	}

}
