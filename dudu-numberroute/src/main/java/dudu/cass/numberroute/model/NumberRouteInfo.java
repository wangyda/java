package dudu.cass.numberroute.model;

public class NumberRouteInfo {

	private String number;
	private String plat ;

	public NumberRouteInfo(String number ,String platform) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.plat = platform;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}
}
