package com.fsd.itemservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Item implements Serializable {

    private static final long serialVersionUID = 3680287402831641457L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, unique = true)
    private Integer id;

    private Integer categoryId;

    private Integer subcategoryId;

    @Column(precision = 8, scale = 2)
    private BigDecimal price;

    private String name;

    private String description;

    private Integer stockNumber;

    private String remarks;
}
