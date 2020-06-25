package net.praveen.artgallerybackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user_details")
public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_u_id")
	private int id;
	
	@NotBlank(message="Please enter your name")
	private String u_name;
	
	@NotBlank(message="Please enter user name")
	private String u_username;
	
	@NotBlank(message="Please enter your password")
	private String u_password;
	
	@NotBlank(message="Please enter your Address")
	private String u_address;
	
	@NotBlank(message="Please enter your email")
	private String u_emailid;
	
	@NotBlank(message="Please enter your contact number")
	private String u_contact_number;
	 
	private String u_role;
	
	private boolean u_status=true;
	
	
	//confirm password transient field
	@Transient
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	//////////////////////////////
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	////////////////////////////////

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_username() {
		return u_username;
	}

	public void setU_username(String u_username) {
		this.u_username = u_username;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public String getU_emailid() {
		return u_emailid;
	}

	public void setU_emailid(String u_emailid) {
		this.u_emailid = u_emailid;
	}

	public String getU_contact_number() {
		return u_contact_number;
	}

	public void setU_contact_number(String u_contact_number) {
		this.u_contact_number = u_contact_number;
	}

	public String getU_role() {
		return u_role;
	}

	public void setU_role(String u_role) {
		this.u_role = u_role;
	}

	public boolean isU_status() {
		return u_status;
	}

	public void setU_status(boolean u_status) {
		this.u_status = u_status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", u_name=" + u_name + ", u_username=" + u_username + ", u_password=" + u_password
				+ ", u_address=" + u_address + ", u_emailid=" + u_emailid + ", u_contact_number=" + u_contact_number
				+ ", u_role=" + u_role + ", u_status=" + u_status + "]";
	}

	   
	
	
	   

}
