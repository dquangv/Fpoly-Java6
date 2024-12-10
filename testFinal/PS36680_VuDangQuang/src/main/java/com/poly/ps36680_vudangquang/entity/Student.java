package com.poly.ps36680_vudangquang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "maSV", nullable = false)
    private String MaSV;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "mark", nullable = false)
    private Double mark;
    @Column(name = "major", nullable = false)
    private String major;
}
