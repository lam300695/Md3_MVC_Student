package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.StudentService;
import com.codegym.service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(request,response);
                break;
            case "update":
                updateStudent(request,response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                viewStudent(request,response);
                break;
            default:
                listStudent(request,response);
                break;
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response){
        List<Student>students = this.studentService.findAll();
        request.setAttribute("students",students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int id = studentService.findAll().size()+1;

        Student student = new Student(id,name,email);
        studentService.save(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null){
            dispatcher = request.getRequestDispatcher("404.jsp");
        }
        else {
            request.setAttribute("student",student);
            dispatcher = request.getRequestDispatcher("student/edit.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("404.jsp");
        } else {
            student.setName(name);
            student.setEmail(email);
            this.studentService.update(id, student);
            request.setAttribute("student", student);
            request.setAttribute("message", "Student information was updated");
            dispatcher = request.getRequestDispatcher("student/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("404.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("student/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("404.jsp");
        } else {
            this.studentService.remove(id);
            try {
                response.sendRedirect("/students");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("404.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("student/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
