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
					messege = method.invoke(iplay, "��Ǹ���˽���Ϊ������ר�á�");
				}
				return messege;
			}
		});
		
		ip.option("ȷ��");
		ip.paramater("ȷ��");
		ip.start("ȷ��");
		
	}
}
