package cn.tedu.ssm.util;

public class JsonResult<T> {
	
	// ����״̬�����ɹ���ʧ��
	private Integer state;
	// ����ʧ��ʱ����ʾ��Ϣ
	private String message;
	// ��Ӧ���ͻ��˵�����
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