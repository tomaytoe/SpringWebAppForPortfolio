package com.portfolio.cv.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "first_name")
    private String first_name;
    
    @Column(name = "last_name")
    private String last_name;

    //@Convert(converter = AesEncryptor.class)
    @Column(name = "password")
    private String password;
}