package org.ankur.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NUMBER") ),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME") ),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME") ),
			@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PIN_CODE") ) })
	private Address homeAddress;

	@Embedded
	private Address officeAddress;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID") )
	/*
	 * @GenericGenerator(name = "hilo-gen", strategy = "hilo")
	 * 
	 * @CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator =
	 * "hilo-gen", type = @Type(type = "long") )
	 */
	private Collection<Address> addList = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "USER_DEPT_ID")
	private Department userDepartment;

	@OneToMany(cascade=CascadeType.ALL)//(mappedBy = "user")
	@JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID") , inverseJoinColumns = @JoinColumn(name = "DEPT_ID") )
	private Collection<Vehicle> vehiceList = new ArrayList<>();

	/*@ManyToMany
	@JoinTable(name = "USER_BOOK", joinColumns = @JoinColumn(name = "USER_ID") , inverseJoinColumns = @JoinColumn(name = "BOOk_ID") )
	private Collection<RentalBook> bookList = new ArrayList<>();*/

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

	public Collection<Address> getAddList() {
		return addList;
	}

	public void setAddList(Collection<Address> addList) {
		this.addList = addList;
	}

	public Department getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(Department userDepartment) {
		this.userDepartment = userDepartment;
	}

	public Collection<Vehicle> getVehiceList() {
		return vehiceList;
	}

	public void setVehiceList(Collection<Vehicle> vehiceList) {
		this.vehiceList = vehiceList;
	}

	/*public Collection<RentalBook> getBookList() {
		return bookList;
	}

	public void setBookList(Collection<RentalBook> bookList) {
		this.bookList = bookList;
	}*/

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", userName=" + userName + ", joinedDate=" + joinedDate
				+ ", joinedTime=" + joinedTime + ", description=" + description + ", homeAddress=" + homeAddress
				+ ", officeAddress=" + officeAddress + "]";
	}

}
