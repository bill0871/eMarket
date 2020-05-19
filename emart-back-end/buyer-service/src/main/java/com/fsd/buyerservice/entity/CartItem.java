package com.fsd.buyerservice.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class CartItem implements Serializable {

    private static final long serialVersionUID = -4588400883857900637L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, unique = true)
    private Integer id;

    private Integer itemId;

    private Integer userId;

    private Integer quantity;

}
