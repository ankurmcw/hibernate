package org.ankur.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RENTAL_BOOK")
public class RentalBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private String bookId;

	@Basic
	@Column(name = "BOOK_NAME")
	private String bookName;

	//@ManyToMany
	private Collection<UserDetail> userList = new ArrayList<>();

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Collection<UserDetail> getUserList() {
		return userList;
	}

	public void setUserList(Collection<UserDetail> userList) {
		this.userList = userList;
	}

}
