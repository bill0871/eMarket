package com.fsd.userservice.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;


@Data
@Entity(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 448114114000191741L;

    @Id
    @GeneratedValue
    @Column(insertable = false)
    private Integer id;

    private String name;

    private String briefDetails;
}