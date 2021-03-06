package entities;

// Generated May 20, 2017 9:07:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PosStaff generated by hbm2java
 */
@Entity
@Table(name = "pos_staff", catalog = "db_shop_coffee")
public class PosStaff implements java.io.Serializable {

	private Integer staffId;
	private String staffName;
	private String phone;
	private String email;
	private String address;
	private String image;
	private Date createdAt;
	private Date updatedAt;

	public PosStaff() {
	}

	public PosStaff(String staffName, Date createdAt, Date updatedAt) {
		this.staffName = staffName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public PosStaff(String staffName, String phone, String email,
			String address, Date createdAt, Date updatedAt) {
		this.staffName = staffName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "staff_id", unique = true, nullable = false)
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "staff_name", nullable = false, length = 65535)
	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Column(name = "phone", length = 65535)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 65535)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address", length = 65535)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "image", length = 65535)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 19)
	public Date getCreatedAt() {
		if(null == createdAt) {
			createdAt = new Date();
		}
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, length = 19)
	public Date getUpdatedAt() {
		if(null == updatedAt) {
			updatedAt = new Date();
		}
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
