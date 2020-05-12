package com.fsd.userservice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity
public class PurchaseHistory implements Serializable {

    private static final long serialVersionUID = 100669090606986207L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private Integer id;

    private Integer buyerId;

    private Integer sellerId;

    private Integer transactionId;

    /**
     * one item_id to one history_id
     */
    private Integer itemId;

    private Integer numberOfItems;

    private String remarks;

    @CreatedDate
    private Date createDate;
}