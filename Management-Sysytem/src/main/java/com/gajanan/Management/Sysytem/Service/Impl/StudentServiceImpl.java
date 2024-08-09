package com.gajanan.Management.Sysytem.Service.Impl;

import com.gajanan.Management.Sysytem.DTO.RequestDTO.RequestStudentDTO;
import com.gajanan.Management.Sysytem.DTO.ResponseDTO.ResponseCourseDTO;
import com.gajanan.Management.Sysytem.DTO.ResponseDTO.ResponseStudentDTO;
import com.gajanan.Management.Sysytem.Entity.Course;
import com.gajanan.Management.Sysytem.Entity.Student;
import com.gajanan.Management.Sysytem.Repository.StudentRepo;
import com.gajanan.Management.Sysytem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String createStudent(RequestStudentDTO requestStudentDTO) {
        Student student=new Student(
                requestStudentDTO.getFirstName(),
                requestStudentDTO.getLastName(),
                requestStudentDTO.getEmail(),
                requestStudentDTO.getCourse()
        );
        studentRepo.save(student);
        return requestStudentDTO.getFirstName()+" "+requestStudentDTO.getLastName();
    }

    @Override
    public List<ResponseStudentDTO> getStudents() {
        ArrayList<ResponseStudentDTO> arrayList=new ArrayList<>();

        List<Student> students=studentRepo.findAll();

        for(Student s: students){
            arrayList.add(new ResponseStudentDTO(
                    s.getFirstName(),
                    s.getLastName(),
                    s.getEmail(),
                    s.getCourse()
            ));
        }

        return arrayList;
    }

    @Override
    public String deleteStudent(Long id) {
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("course does not exist");
        }
        studentRepo.delete(student.get());
        return student.get().getFirstName()+" " + student.get().getLastName();
    }

    @Override
    public ResponseStudentDTO updateStudent(RequestStudentDTO requestStudentDTO, Long id) {
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student does not exist");
        }
        student.get().setFirstName(requestStudentDTO.getFirstName());
        student.get().setLastName(requestStudentDTO.getLastName());
        student.get().setEmail(requestStudentDTO.getEmail());
        student.get().setCourse(requestStudentDTO.getCourse());
        studentRepo.save(student.get());

        return new ResponseStudentDTO(
                student.get().getFirstName(),
                student.get().getLastName(),
                student.get().getEmail(),
                student.get().getCourse()
        );
    }

    @Override
    public ResponseStudentDTO getStudentById(Long id) {
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student does not exist");
        }

        return new ResponseStudentDTO(
                student.get().getFirstName(),
                student.get().getLastName(),
                student.get().getEmail(),
                student.get().getCourse()
        );
    }
}
