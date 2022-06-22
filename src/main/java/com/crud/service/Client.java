package com.crud.service;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Client {
    private long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;


}
