package com.kosa.springbootmyspace.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SCORE_SEQ_GEN", sequenceName = "SCORE_SEQ", allocationSize = 1)
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCORE_SEQ_GEN")
    private int idx;

    @Column(nullable = false)
    private int durability;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int design;

    @Column(nullable = false)
    private int delivery;

    @OneToOne
    @JoinColumn(name = "review_idx")
    @JsonIgnore
    private Review review;
}
