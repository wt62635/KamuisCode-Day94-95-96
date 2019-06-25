package cn.kamui.IPlay;

public class IPlayGameProxy implements IPlayGame{
	IPlayGame iPlayGame;
	
	IPlayGameProxy(){
		this.iPlayGame = iPlayGame;
	}
	
	@Override
	public String start() {
		return null;
	}

	@Override
	public String option() {
		return null;
	}

	@Override
	public String paramater() {
		return null;
	}

	@Override
	public String exit() {
		return null;
	}

}
