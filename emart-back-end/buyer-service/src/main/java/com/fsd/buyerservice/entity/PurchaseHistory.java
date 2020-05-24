package com.fsd.buyerservice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity
public class PurchaseHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer buyerId;

    private Integer sellerId;

    private Integer itemId;

    private Integer transactionId;

    private Integer numberOfItems;

    private String remarks;

    @CreatedDate
    private Date createDate;
}
