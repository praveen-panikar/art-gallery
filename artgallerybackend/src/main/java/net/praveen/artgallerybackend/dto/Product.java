package net.praveen.artgallerybackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product_details")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_prod_id;
	
	private String prod_name;
	@JsonIgnore
	private String prod_description;
	private double prod_price;
	@JsonIgnore
	private String prod_img_url;
	@JsonIgnore
	private boolean prod_status;
	
	@JsonIgnore
	private int fk_cat_id;
	@JsonIgnore
	private int fk_u_id;
	
	
	public int getPk_prod_id() {
		return pk_prod_id;
	}
	public void setPk_prod_id(int pk_prod_id) {
		this.pk_prod_id = pk_prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_description() {
		return prod_description;
	}
	public void setProd_description(String prod_description) {
		this.prod_description = prod_description;
	}
	public double getProd_price() {
		return prod_price;
	}
	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_img_url() {
		return prod_img_url;
	}
	public void setProd_img_url(String prod_img_url) {
		this.prod_img_url = prod_img_url;
	}
	public boolean isProd_status() {
		return prod_status;
	}
	public void setProd_status(boolean prod_status) {
		this.prod_status = prod_status;
	}
	public int getFk_cat_id() {
		return fk_cat_id;
	}
	public void setFk_cat_id(int fk_cat_id) {
		this.fk_cat_id = fk_cat_id;
	}
	public int getFk_u_id() {
		return fk_u_id;
	}
	public void setFk_u_id(int fk_u_id) {
		this.fk_u_id = fk_u_id;
	}
	
	
	
}
