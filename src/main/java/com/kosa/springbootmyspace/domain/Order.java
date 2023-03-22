package com.kosa.springbootmyspace.domain;

import java.util.Date;

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
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ORDER2")
@Data
@NoArgsConstructor
@SequenceGenerator(name = "ORDER2_SEQ_GEN", sequenceName = "ORDER2_SEQ", allocationSize = 1)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER2_SEQ_GEN")
    private int idx;

    @Column
    private String payment;

    @Column
    private int price;

    @Column
    private int delivery_price;

    @Column
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date regdate;

    @Column
    private String delivery_name;

    @Column
    private String address_name;

    @Column
    private String address;

    @Column
    private String delivery_request;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    @JsonIgnore
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_idx")
    private Cart cart;
}
