package dudu.cass.numberroute.model;

import dudu.cass.numberroute.entity.NumberRouteEntity;

public class NumberRouteInfo {

	private String number;
	private String plat = "NO";

	public NumberRouteInfo(NumberRouteEntity routeEntity) {
		// TODO Auto-generated constructor stub
		this.number = routeEntity.getPrefix();
		this.plat = routeEntity.getDescription();
		
	}

	public NumberRouteInfo(String number2) {
		// TODO Auto-generated constructor stub
		this.number = number2;
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
