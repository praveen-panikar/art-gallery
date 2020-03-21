package net.praveen.artgallerybackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_cat_id;
	private String cat_name;
	private boolean cat_status = true;

	public int getPk_cat_id() {
		return pk_cat_id;
	}

	public void setPk_cat_id(int pk_cat_id) {
		this.pk_cat_id = pk_cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public boolean isCat_status() {
		return cat_status;
	}

	public void setCat_status(boolean cat_status) {
		this.cat_status = cat_status;
	}

	@Override
	public String toString() {
		return "Category [pk_cat_id=" + pk_cat_id + ", cat_name=" + cat_name + ", cat_status=" + cat_status + "]";
	}

}
