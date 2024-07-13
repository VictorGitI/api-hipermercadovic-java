package com.victorgroup.hipermercadovic.apirest.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDTO {
    private int productId;
    private String productName;
    private String productDescription;
    private double price;
    private int productStock;
    private String productBrand;
    private String productModel;
    private BigDecimal productWeight;
    private Date productManufacturingDate;

    public ProductDTO() {
    }

    public ProductDTO(int productId, String productName, String productDescription, double price,
                      int productStock, String productBrand, String productModel, BigDecimal productWeight,
                      Date productManufacturingDate) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.productStock = productStock;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productWeight = productWeight;
        this.productManufacturingDate = productManufacturingDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public BigDecimal getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(BigDecimal productWeight) {
        this.productWeight = productWeight;
    }

    public Date getProductManufacturingDate() {
        return productManufacturingDate;
    }

    public void setProductManufacturingDate(Date productManufacturingDate) {
        this.productManufacturingDate = productManufacturingDate;
    }
}
