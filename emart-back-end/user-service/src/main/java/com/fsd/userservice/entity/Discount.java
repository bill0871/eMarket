package com.fsd.userservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity(name = "discount")
public class Discount implements Serializable {

    private static final long serialVersionUID = 430461407257752609L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private Integer id;

    /**
     * 4-alphabetic code
     */
    private String code;

    @Column(precision = 8, scale = 2)
    private BigDecimal percentage;

    private Date startDate;

    private Date endDate;

    private String description;

    @CreatedDate
    private Date createDate;
}