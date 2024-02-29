package com.example.sports.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long pId;
    String pName;
    double pPrice;
    
   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    Category category;

public Long getpId() {
    return pId;
}

public void setpId(Long pId) {
    this.pId = pId;
}


public String getpName() {
    return pName;
}

public void setpName(String pName) {
    this.pName = pName;
}

public double getpPrice() {
    return pPrice;
}

public void setpPrice(double pPrice) {
    this.pPrice = pPrice;
}

public Category getCategory() {
    return category;
}

public void setCategory(Category category) {
    this.category = category;
}
    
 
    
}