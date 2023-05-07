package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name= "usuarios")
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nombre")
    private String name;
    @Column(name ="telefono")
    private String phone;

}
