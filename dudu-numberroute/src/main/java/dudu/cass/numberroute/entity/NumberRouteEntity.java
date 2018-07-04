package dudu.cass.numberroute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "dr_rules")
public class NumberRouteEntity {

	private long ruleid;
	private String prefix;
	private String gwlist;
	private String description;
	
	@Id
    @GeneratedValue
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
	
	@Column(name="gwlist", nullable = true, length = 255)
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
	
	
}
