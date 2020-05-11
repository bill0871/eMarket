package com.fsd.userservice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "discount")
public class Discount implements Serializable {

    private static final long serialVersionUID = 430461407257752609L;

    @Id
    @GeneratedValue
    @Column(insertable = false)
    private Integer id;

    /**
     * 4-alphabetic code
     */
    private String code;

    private Double percentage;

    private Date startDate;

    private Date endDate;

    private String description;

    private Date createDate;
}