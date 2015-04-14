package edu.neu.cs5200.jpa.orm.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tower{
	 @Id	
	   private Integer id;
	   private String name;
	   private double height;
	   private int sides;
	   private int siteId;
	public Integer getId() {
		return id;
	}
	public Tower(Integer id, String name, double height, int sides, int siteId) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.siteId = siteId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public Tower() {
		super();
	}

}
