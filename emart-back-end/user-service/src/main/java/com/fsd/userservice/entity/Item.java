package com.fsd.userservice.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Item implements Serializable {

    private static final long serialVersionUID = -38410860949555566L;

    @Id
    @GeneratedValue
    @Column(insertable = false)
    private Integer id;

    private Integer categoryId;

    private Integer subcategoryId;

    private Double price;

    private String name;

    private String description;

    private Integer stockNumber;

    private String remarks;
}