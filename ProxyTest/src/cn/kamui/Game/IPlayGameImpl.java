package cn.kamui.Game;

import cn.kamui.IPlay.IPlayGame;

public class IPlayGameImpl implements IPlayGame{

	@Override
	public void start(String mes) {
		if("ȷ��".equals(mes)) {
			mes = "��Ϸ��ʼ...";
			System.out.println(mes);
		}
	}

	@Override
	public void option(String mes) {
		if("ȷ��".equals(mes)) {
			mes = "��������ҳ��....";
			System.out.println(mes);
		}
	}

	@Override
	public void paramater(String mes) {
		if("ȷ��".equals(mes)) {
			mes = "�ɹ��򿪲���ҳ��";
			System.out.println(mes);
		}else {
			System.out.println(mes);
		}
	}

	@Override
	public void exit(String mes) {
		if("ȷ��".equals(mes)) {
			mes = "��Ϸ����....";
			System.out.println(mes);
		}
	}

}
