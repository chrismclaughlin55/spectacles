package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="marketplace_info")
public class MarketplaceInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;


    @ManyToOne(optional = false, fetch= FetchType.LAZY)
    @JoinColumn
    private Item item;

    @Column(name = "source")
    private String source;

    @OneToMany(cascade={CascadeType.ALL})
    private List<PriceDetail> priceDetails;

}