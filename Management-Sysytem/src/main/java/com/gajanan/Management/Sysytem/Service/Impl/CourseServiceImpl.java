package com.gajanan.Management.Sysytem.Service.Impl;

import com.gajanan.Management.Sysytem.DTO.RequestDTO.RequestCourseDTO;
import com.gajanan.Management.Sysytem.DTO.ResponseDTO.ResponseCourseDTO;
import com.gajanan.Management.Sysytem.Entity.Course;
import com.gajanan.Management.Sysytem.Repository.CourseRepo;
import com.gajanan.Management.Sysytem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String createCourse(RequestCourseDTO requestCourseDTO) {

        Course course=new Course(
                requestCourseDTO.getCourseName(),
                requestCourseDTO.getDescription(),
                requestCourseDTO.getDuration()

        );
        courseRepo.save(course);
        return requestCourseDTO.getCourseName();
    }

    @Override
    public List<ResponseCourseDTO> getCourses() {
        ArrayList<ResponseCourseDTO> arrayList=new ArrayList<>();

        List<Course> courses=courseRepo.findAll();

        for(Course c : courses){
            arrayList.add(new ResponseCourseDTO(
                    c.getCourseName(),
                    c.getDescription(),
                    c.getDuration()
            ));
        }
        return arrayList;
    }

    @Override
    public String deleteCourse(Long id) {
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty()){
            throw new RuntimeException("course does not exist");
        }
        courseRepo.delete(course.get());
        return course.get().getCourseName();
    }

    @Override
    public ResponseCourseDTO updateCourse(RequestCourseDTO requestCourseDTO, Long id) {
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty()){
            throw new RuntimeException("Course does not exist");
        }
        course.get().setCourseName(requestCourseDTO.getCourseName());
        course.get().setDescription(requestCourseDTO.getDescription());
        course.get().setDuration(requestCourseDTO.getDuration());
        courseRepo.save(course.get());

        return new ResponseCourseDTO(
                course.get().getCourseName(),
                course.get().getDescription(),
                course.get().getDuration()
        );
    }

    @Override
    public ResponseCourseDTO getCourseById(Long id) {
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty()){
            throw new RuntimeException("Course does not exist");
        }

        return new ResponseCourseDTO(
                course.get().getCourseName(),
                course.get().getDescription(),
                course.get().getDuration()
        );
    }
}
