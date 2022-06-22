package com.crud.service;

import lombok.*;
import org.springframework.data.annotation.TypeAlias;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder


public class Order{
    private long clientId;
    private int orderNumber;
    private String deviceType;
    private String repairDescription;
    private String orderStatus;

}
