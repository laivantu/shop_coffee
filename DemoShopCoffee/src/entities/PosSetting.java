package entities;

// Generated May 20, 2017 9:07:02 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PosSetting generated by hbm2java
 */
@Entity
@Table(name = "pos_setting", catalog = "db_shop_coffee")
public class PosSetting implements java.io.Serializable {

	private Integer settingId;
	private String companyName;
	private String companyLogo;
	private double tax;

	public PosSetting() {
	}

	public PosSetting(String companyName, double tax) {
		this.companyName = companyName;
		this.tax = tax;
	}

	public PosSetting(String companyName, String companyLogo, double tax) {
		this.companyName = companyName;
		this.companyLogo = companyLogo;
		this.tax = tax;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "setting_id", unique = true, nullable = false)
	public Integer getSettingId() {
		return this.settingId;
	}

	public void setSettingId(Integer settingId) {
		this.settingId = settingId;
	}

	@Column(name = "company_name", nullable = false, length = 65535)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "company_logo", length = 65535)
	public String getCompanyLogo() {
		return this.companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	@Column(name = "tax", nullable = false, precision = 22, scale = 0)
	public double getTax() {
		return this.tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

}
