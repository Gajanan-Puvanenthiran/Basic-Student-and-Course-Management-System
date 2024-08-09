package com.gajanan.Management.Sysytem.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestStudentDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String course;
}
