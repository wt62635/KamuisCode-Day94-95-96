package cn.kamui.AOP;

public class Test {
	public static void main(String[] args) {
		UserService userService = (UserService) new ProxyHandler().getProxy();
		System.out.println(userService.getClass());
	}
}
