package dudu.cass.numberroute.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "dr_rules")
public class NumberRouteEntity {
	
	private String number;
	private String plat;
	
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
