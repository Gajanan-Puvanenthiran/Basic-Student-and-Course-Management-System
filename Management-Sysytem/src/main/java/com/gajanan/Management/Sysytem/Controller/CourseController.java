package com.gajanan.Management.Sysytem.Controller;

import com.gajanan.Management.Sysytem.DTO.RequestDTO.RequestCourseDTO;
import com.gajanan.Management.Sysytem.Service.CourseService;
import com.gajanan.Management.Sysytem.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping("/POST/courses")
    private ResponseEntity<StandardResponse> createNewCourse(
            @RequestBody RequestCourseDTO requestCourseDTO
    ){
        return new ResponseEntity<>(new StandardResponse(
                "Course created successfully",
                201,
                courseService.createCourse(requestCourseDTO)
        ), HttpStatus.OK);

    }

    @GetMapping("/GET/courses")
    private ResponseEntity<StandardResponse> getCourses(){
        return new ResponseEntity<>(new StandardResponse(
                "Data retrived successfully",
                200,
                courseService.getCourses()
        ),HttpStatus.OK);
    }

    @DeleteMapping(path = "/DELETE/courses/{id}")
    private ResponseEntity<StandardResponse> deleteCourse(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(new StandardResponse("Record deleted",
                204,
                courseService.deleteCourse(id)
        ),HttpStatus.OK);
    }

    @PutMapping("/PUT/courses/{id}")
    private ResponseEntity<StandardResponse> updateDetails(
            @RequestBody RequestCourseDTO requestCourseDTO,
            @PathVariable Long id
    ){

        return new ResponseEntity<>(new StandardResponse(
                "Successfully updated",
                200,
                courseService.updateCourse(requestCourseDTO,id)),
                HttpStatus.OK);
    }

    @GetMapping("/GET/courses/{id}")
    private ResponseEntity<StandardResponse> getById(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(new StandardResponse(
                "Data retrived successfully",
                200,
                courseService.getCourseById(id)
        ),HttpStatus.OK);
    }
}
