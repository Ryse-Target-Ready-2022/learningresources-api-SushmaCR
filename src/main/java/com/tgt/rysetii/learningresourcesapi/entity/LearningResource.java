package com.tgt.rysetii.learningresourcesapi.entity;

import java.time.LocalDate;

public class LearningResource {
	
	private int id;
	private String name;
	private double costPrice;
	private double sellingPrice;
	private LearningResourceStatus resourceStatus;
    private LocalDate createdDate;
    private LocalDate publishedDate;
    private LocalDate retiredDate;
	public LearningResource(int id, String name, double costPrice, double sellingPrice,
			LearningResourceStatus resourceStatus, LocalDate createdDate, LocalDate publishedDate,
			LocalDate retiredDate) {
		super();
		this.id = id;
		this.name = name;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.resourceStatus = resourceStatus;
		this.createdDate = createdDate;
		this.publishedDate = publishedDate;
		this.retiredDate = retiredDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public LearningResourceStatus getResourceStatus() {
		return resourceStatus;
	}
	public void setResourceStatus(LearningResourceStatus resourceStatus) {
		this.resourceStatus = resourceStatus;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	public LocalDate getRetiredDate() {
		return retiredDate;
	}
	public void setRetiredDate(LocalDate retiredDate) {
		this.retiredDate = retiredDate;
	}
    
    
	

}
