package com.fsd.userservice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Seller implements Serializable {

    private static final long serialVersionUID = 897924047391610080L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    private String individualName;

    private String companyName;

    private String postalAddress;

    private String gstin;

    private String bankDetail;

    private Date createTime;

}