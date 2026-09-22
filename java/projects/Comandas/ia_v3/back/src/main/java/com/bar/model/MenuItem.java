package com.bar.model;

public class MenuItem {
    private String id;
    private String code;
    private String name;
    private double price;
    private String category;
    private String subcategory;
    private String subSubcategory;
    
    public MenuItem() {}
    
    public MenuItem(String id, String code, String name, double price, String category, String subcategory, String subSubcategory) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
        this.subcategory = subcategory;
        this.subSubcategory = subSubcategory;
    }
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getSubcategory() { return subcategory; }
    public void setSubcategory(String subcategory) { this.subcategory = subcategory; }
    
    public String getSubSubcategory() { return subSubcategory; }
    public void setSubSubcategory(String subSubcategory) { this.subSubcategory = subSubcategory; }
}
