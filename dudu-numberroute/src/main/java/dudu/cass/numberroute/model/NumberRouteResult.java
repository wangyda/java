package dudu.cass.numberroute.model;

public class NumberRouteResult {
	private String status;
	private String msg;
	private Object data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public NumberRouteResult(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	public NumberRouteResult(String status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	public NumberRouteResult() {
		
	}
}
