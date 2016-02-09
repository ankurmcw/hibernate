package org.ankur.hibernate.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "JOINED_DATE")
	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	@Column(name = "JOINED_TIME")
	@Temporal(TemporalType.TIME)
	private Date joinedTime;

	@Column(name = "DESCRIPTION")
	@Lob
	private String description;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride (name="street",column=@Column(name="HOME_STREET_NUMBER")),
		@AttributeOverride (name="city",column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride (name="state",column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride (name="pincode",column=@Column(name="HOME_PIN_CODE"))		
	})
	private Address homeAddress;

	@Embedded
	private Address officeAddress;

	@Transient
	private String ignoredField;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Date getJoinedTime() {
		return joinedTime;
	}

	public void setJoinedTime(Date joinedTime) {
		this.joinedTime = joinedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIgnoredField() {
		return ignoredField;
	}

	public void setIgnoredField(String ignoredField) {
		this.ignoredField = ignoredField;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAaddress) {
		this.homeAddress = homeAaddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAaddress) {
		this.officeAddress = officeAaddress;
	}

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", userName=" + userName + ", joinedDate=" + joinedDate
				+ ", joinedTime=" + joinedTime + ", description=" + description + ", homeAaddress=" + homeAddress
				+ ", officeAaddress=" + officeAddress + ", ignoredField=" + ignoredField + "]";
	}

}
