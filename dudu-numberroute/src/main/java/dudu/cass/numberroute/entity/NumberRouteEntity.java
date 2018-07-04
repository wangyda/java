package dudu.cass.numberroute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "dr_rules")
public class NumberRouteEntity {

	private long ruleid;
	private String groupid= "2";
	private String prefix;
	private String gwlist;
	private String description;
	
	public NumberRouteEntity() {

	}
	public NumberRouteEntity(String number, String plat) {
		this.prefix = number;
		this.description = plat;
	}
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getRuleid() {
		return ruleid;
	}
	public void setRuleid(long ruleid) {
		this.ruleid = ruleid;
	}
	@Column(name="prefix", nullable = true, length = 64)
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	@Column(name="gwlist", nullable = false, length = 255)
	public String getGwlist() {
		return gwlist;
	}
	public void setGwlist(String gwlist) {
		this.gwlist = gwlist;
	}
	@Column(name="description", nullable = true, length = 128)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="groupid", nullable = false, length = 255)
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}	
	
	
}
