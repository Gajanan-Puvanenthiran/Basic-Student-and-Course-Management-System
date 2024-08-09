package com.gajanan.Management.Sysytem.Service;

import com.gajanan.Management.Sysytem.DTO.RequestDTO.RequestCourseDTO;
import com.gajanan.Management.Sysytem.DTO.ResponseDTO.ResponseCourseDTO;

import java.util.List;

public interface CourseService {
    String createCourse(RequestCourseDTO requestCourseDTO);

    List<ResponseCourseDTO> getCourses();

    String deleteCourse(Long id);

    ResponseCourseDTO updateCourse(RequestCourseDTO requestCourseDTO, Long id);

    ResponseCourseDTO getCourseById(Long id);
}
