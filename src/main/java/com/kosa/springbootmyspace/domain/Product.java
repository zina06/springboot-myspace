package com.kosa.springbootmyspace.domain;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "PRODUCT_SEQ_GEN", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GEN")
    private int idx;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(columnDefinition = "TEXT")
    private String image_url;

    @Column(columnDefinition = "TEXT")
    private String image;

    @OneToOne
    @JoinColumn(name = "brand_idx")
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "category_idx")
    private Category category;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<Review> reviewList;
    @Transient
    private float allTotal;
}
