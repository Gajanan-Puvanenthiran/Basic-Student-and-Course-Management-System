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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String description;
    @Column(columnDefinition = "VARCHAR(255) COMMENT 'in weeks'")
    private int duration;

    public Course(String courseName, String description, int duration) {
        this.courseName=courseName;
        this.description=description;
        this.duration=duration;
    }
}
