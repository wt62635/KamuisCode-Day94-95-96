package cn.kamui.Game;

import cn.kamui.IPlay.IPlayGame;

public class IPlayGameImpl implements IPlayGame{

	@Override
	public void start(String mes) {
		if("确定".equals(mes)) {
			mes = "游戏开始...";
			System.out.println(mes);
		}
	}

	@Override
	public void option(String mes) {
		if("确定".equals(mes)) {
			mes = "进入设置页面....";
			System.out.println(mes);
		}
	}

	@Override
	public void paramater(String mes) {
		if("确定".equals(mes)) {
			mes = "成功打开参数页面";
			System.out.println(mes);
		}else {
			System.out.println(mes);
		}
	}

	@Override
	public void exit(String mes) {
		if("确定".equals(mes)) {
			mes = "游戏结束....";
			System.out.println(mes);
		}
	}

}
