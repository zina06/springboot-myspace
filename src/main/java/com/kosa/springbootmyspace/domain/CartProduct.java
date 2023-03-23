package com.kosa.springbootmyspace.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "CART_PRODUCT_SEQ_GEN", sequenceName = "CART_PRODUCT_SEQ", allocationSize = 1)
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_PRODUCT_SEQ_GEN")
    private int idx;

    @Column(nullable = false)
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_idx")
    @JsonIgnore
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "product_idx")
    private Product product;
}
