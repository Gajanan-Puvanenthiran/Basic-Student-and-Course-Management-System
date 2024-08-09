package com.gajanan.Management.Sysytem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String course;

    public Student(String firstName, String lastName, String email, String course) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.course=course;
    }
}
