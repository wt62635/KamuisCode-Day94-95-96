package cn.tedu.ssm.util;

public class JsonResult<T> {
	
	// 操作状态，即成功或失败
	private Integer state;
	// 操作失败时的提示消息
	private String message;
	// 响应给客户端的数据
	private T data;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}