package com.example.student_management.controllers;


import com.example.student_management.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Laura Garcia", "laura.g@mail.com", 21459094, "Ciencias de la Computación"),
            new Student(2, "Carlos Fernandez", "carlos.f@mail.com", 56784322, "Ingeniería Mecánica"),
            new Student(3, "Ana Martienez", "ana.m@mail.com", 98621545, "Administración de Empresas"),
            new Student(4, "Miguel Lopez", "miguel.l@mail.com", 22008743, "Ingeniería Eléctrica")
    ));
    @GetMapping
    public List<Student> getStudents(){

        return students;
    }

    @GetMapping("/{email}")
    public Student getStudent(@PathVariable String email){
        for (Student s : students){
            if (s.getEmail().equalsIgnoreCase(email)){
                return s;
            }
        }
        return null;
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student){
        students.add(student);

        return student;
    }

    @PutMapping
    public Student putStudent(@RequestBody Student student){
        for (Student s : students){
            if (s.getId() == student.getId()){
                s.setName(student.getName());
                s.setEmail(student.getEmail());
                s.setNum(student.getNum());
                s.setCourse(student.getCourse());

                return s;
            }
        }
        return null;
    }

    @PatchMapping
    public Student patchStudent(@RequestBody Student student){
        for (Student s : students){
            if (s.getId() == student.getId()){

                if (student.getName() != null){
                    s.setName(student.getName());
                }
                if (student.getEmail() != null){
                    s.setEmail(student.getEmail());
                }
                if (student.getNum() != 0){
                    s.setNum(student.getNum());
                }
                if (student.getCourse() != null){
                    s.setCourse(student.getCourse());
                }

                return s;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id){
        for (Student s : students){
            if (s.getId() == id){
                students.remove(s);

                return s;
            }
        }
        return null;
    }

}












