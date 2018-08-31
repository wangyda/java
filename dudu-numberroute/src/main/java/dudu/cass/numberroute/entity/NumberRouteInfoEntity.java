package dudu.cass.numberroute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class NumberRouteInfoEntity {

    private long id;
    private String username;
    private String plat ;
    private String vendor;
	
	public NumberRouteInfoEntity() {

	}
    public NumberRouteInfoEntity(String username, String vendor, String plat) {
        this.username = username;
        this.vendor = vendor;
        this.plat = plat;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
	
}
