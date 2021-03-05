package com.example.learnings.edsl.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ACTIVATION_COST")
public class ActivationCost implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PINCODE")
    private String pincode;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "COPPER")
    private Double copper;

    @Column(name = "FTTH")
    private Double ftth;

    @Column(name = "ARP_COPPER")
    private Double arpCopper;

    @Column(name = "ARP_FTTH")
    private Double arpFtth;

}