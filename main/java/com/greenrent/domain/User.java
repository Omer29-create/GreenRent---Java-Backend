package com.greenrent.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 20, nullable = false, unique = true)
    private String email;

    @Column(length = 120, nullable = false)
    private String password;

    @Column(length = 15, nullable = false)
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 15, nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private Boolean builtIn = false;

}
