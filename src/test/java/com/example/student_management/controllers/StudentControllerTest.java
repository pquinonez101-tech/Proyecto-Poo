package com.example.student_management.controllers;

import com.example.student_management.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    private StudentController studentController;

    @BeforeEach
    void setUp() {
        studentController = new StudentController();
    }

    @Test
    void testGetStudents() {
        List<Student> students = studentController.getStudents();

        assertNotNull(students, "La lista de estudiantes no debe ser nula");
        assertEquals(4, students.size(), "Debería haber exactamente 4 estudiantes iniciales");
        assertEquals("Laura Garcia", students.get(0).getName());
    }

    @Test
    void testGetStudentByEmailFound() {
        Student student = studentController.getStudent("LAURA.G@MAIL.COM");

        assertNotNull(student, "El estudiante debería ser encontrado");
        assertEquals("Laura Garcia", student.getName());
    }

    @Test
    void testGetStudentByEmailNotFound() {
        Student student = studentController.getStudent("correo.falso@mail.com");

        assertNull(student, "Debería retornar null si el correo no existe");
    }

    @Test
    void testPostStudent() {
        Student nuevoEstudiante = new Student(5, "Sofia Gomez", "sofia.g@mail.com", 20, "Administración");

        Student result = studentController.postStudent(nuevoEstudiante);

        assertNotNull(result);
        assertEquals(5, result.getId());
        assertEquals(5, studentController.getStudents().size(), "El tamaño de la lista debería aumentar a 5");
    }

    @Test
    void testDeleteStudentSuccess() {
        Student deleted = studentController.deleteStudent(1);

        assertNotNull(deleted, "El estudiante eliminado no debe ser nulo");
        assertEquals(1, deleted.getId());
        assertEquals(3, studentController.getStudents().size(), "Quedarían 3 estudiantes en la lista");
    }

    @Test
    void testDeleteStudentNotFound() {
        Student deleted = studentController.deleteStudent(99);

        assertNull(deleted, "Debería retornar null si el ID a eliminar no existe");
        assertEquals(4, studentController.getStudents().size(), "El tamaño de la lista debe mantenerse intacto");
    }
}