package com.victorgroup.hipermercadovic.apirest.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "producto")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int productId;
    @Column(name = "producto_nombre")
    private String productName;
    @Column(name = "producto_descripcion")
    private String productDescription;
    @Column(name = "producto_precio")
    private double price;
    @Column(name = "producto_cantidad_stock")
    private int productStock;
    @Column(name = "producto_marca")
    private String productBrand;
    @Column(name = "producto_modelo")
    private String productModel;
    @Column(name = "producto_peso")
    private BigDecimal productWeight;
    @Column(name = "producto_fecha_fabricacion")
    private Date productManufacturingDate;

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
