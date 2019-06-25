package cn.kamui.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.kamui.Game.IPlayGameImpl;
import cn.kamui.IPlay.IPlayGame;

public class Client {
	public static void main(String[] args) {
		IPlayGameImpl iplay = new IPlayGameImpl();
		
		
		IPlayGame ip = (IPlayGame) Proxy.newProxyInstance(iplay.getClass().getClassLoader(), iplay.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object messege = null;
				//String mes = (String) args[0];
				if("paramater".equals(method.getName())) {
					messege = method.invoke(iplay, "抱歉！此界面为开发者专用。");
				}
				return messege;
			}
		});
		
		ip.option("确定");
		ip.paramater("确定");
		ip.start("确定");
		
	}
}
