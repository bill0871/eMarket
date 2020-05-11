package com.fsd.userservice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Transaction implements Serializable {

    private static final long serialVersionUID = 164716552254885351L;

    @Id
    @GeneratedValue
    @Column(insertable = false)
    private Integer id;

    private Integer buyerId;

    private Integer sellerId;

    private TransType transactionType;

    private String remarks;

    private Date createDate;

}