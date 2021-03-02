package com.example.todotunh.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by tunh on 02/03/2021.
 */
@Entity
@Data
@Table(name = "TODO")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start")
    private Long start;

    @Column(name = "end")
    private Long end;

    @Column(name = "status")
    private Integer status;
}
