package com.gajanan.Management.Sysytem.Controller;

import com.gajanan.Management.Sysytem.DTO.RequestDTO.RequestCourseDTO;
import com.gajanan.Management.Sysytem.DTO.RequestDTO.RequestStudentDTO;
import com.gajanan.Management.Sysytem.Service.StudentService;
import com.gajanan.Management.Sysytem.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/POST/students")
    private ResponseEntity<StandardResponse> createNewStudent(
            @RequestBody RequestStudentDTO requestStudentDTO
            ){
        return new ResponseEntity<>(new StandardResponse(
                "Student created successfully",
                201,
                studentService.createStudent(requestStudentDTO)

        ), HttpStatus.OK);

    }

    @GetMapping("/GET/students")
    private ResponseEntity<StandardResponse> getStudents(){
        return new ResponseEntity<>(new StandardResponse(
                "Data retrived successfully",
                200,
                studentService.getStudents()
        ),HttpStatus.OK);
    }

    @DeleteMapping(path = "/DELETE/students/{id}")
    private ResponseEntity<StandardResponse> deleteStudent(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(new StandardResponse("Record deleted",
                204,
                studentService.deleteStudent(id)
        ),HttpStatus.OK);
    }

    @PutMapping("/PUT/students/{id}")
    private ResponseEntity<StandardResponse> updateDetails(
            @RequestBody RequestStudentDTO requestStudentDTO,
            @PathVariable Long id
    ){

        return new ResponseEntity<>(new StandardResponse(
                "Successfully updated",
                200,
                studentService.updateStudent(requestStudentDTO,id)),
                HttpStatus.OK);
    }

    @GetMapping("/GET/students/{id}")
    private ResponseEntity<StandardResponse> getById(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(new StandardResponse(
                "Data retrived successfully",
                200,
                studentService.getStudentById(id)
        ),HttpStatus.OK);
    }
}
