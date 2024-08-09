package com.gajanan.Management.Sysytem.Service;

import com.gajanan.Management.Sysytem.DTO.RequestDTO.RequestStudentDTO;
import com.gajanan.Management.Sysytem.DTO.ResponseDTO.ResponseStudentDTO;

import java.util.List;

public interface StudentService {
    String createStudent(RequestStudentDTO requestStudentDTO);

    List<ResponseStudentDTO> getStudents();

    String deleteStudent(Long id);

    ResponseStudentDTO updateStudent(RequestStudentDTO requestStudentDTO, Long id);

    ResponseStudentDTO getStudentById(Long id);
}
