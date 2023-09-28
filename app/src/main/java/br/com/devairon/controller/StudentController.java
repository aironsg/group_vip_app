package br.com.devairon.controller;

import android.content.Context;

import br.com.devairon.data.localDataSource.StudentData;
import br.com.devairon.model.CourseModel;
import br.com.devairon.model.StudentModel;
import br.com.devairon.repository.StudentRepository;

public class StudentController implements StudentRepository{


    private StudentRepository repository;
    private StudentModel student = new StudentModel();
    private CourseModel course = new CourseModel();

    private StudentData data;

    @Override
    public void save(StudentModel student, Context context) {
        data = StudentData.getInstance(student, context);
        data.saveStudent(student);


    }

    @Override
    public StudentModel findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(StudentModel student) {

    }

    @Override
    public Iterable<StudentModel> findAll() {
        return null;
    }

    @Override
    public Iterable<StudentModel> findByCourse(Long courseId) {
        return null;
    }


}
