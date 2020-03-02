package com.codegym.service;

import com.codegym.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    private static Map<Integer,Student> students;

    static {
        students = new HashMap<>();
        students.put(1,new Student(1,"Nguyen Tung Lam","Lam300695@gmail.com"));
        students.put(2,new Student(2,"Le Phuong Hieu","Hieu191196@gmail.com"));
        students.put(3,new Student(3,"Le Manh Hung","Hung08022006@gmail.com"));
        students.put(4,new Student(4,"Le Quang Anh","Anh221215@gmail.com"));
        students.put(5,new Student(5,"Tony Lam","Tony300695@gmail.com"));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(),student);
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
        students.put(id,student);
    }

    @Override
    public void remove(int id) {
        students.remove(id);
    }
}
