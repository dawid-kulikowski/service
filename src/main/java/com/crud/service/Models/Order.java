package com.crud.service.Models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String deviceType;
    @Column
    private String deviceModel;
    @Column
    private String repairInfo;
    @Column
    private String repairStatus;
    @Column
    private int estimatedPrice;

}
