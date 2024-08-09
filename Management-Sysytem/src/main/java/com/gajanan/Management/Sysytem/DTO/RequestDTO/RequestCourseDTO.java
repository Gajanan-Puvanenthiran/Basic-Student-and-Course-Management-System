package com.gajanan.Management.Sysytem.DTO.RequestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCourseDTO {

    private String courseName;
    private String description;
    private int duration;
}
