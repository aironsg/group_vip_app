package br.com.devairon.controller;

import android.content.Context;

import br.com.devairon.model.data.local.localDataSource.StudentPreferenceData;
import br.com.devairon.model.entitys.CourseEntity;
import br.com.devairon.model.entitys.StudentEntity;
import br.com.devairon.model.repository.StudentRepository;

public class StudentController implements StudentRepository{


    private StudentRepository repository;
    private StudentEntity student = new StudentEntity();
    private CourseEntity course = new CourseEntity();

    private StudentPreferenceData data;

    @Override
    public void save(StudentEntity student, Context context) {
        data = StudentPreferenceData.getInstance(context);
        data.saveStudent(student);
    }

    @Override
    public StudentEntity findById(Long id) {

        return null;
    }

    @Override
    public StudentEntity findStudent(Context context) {
        data = StudentPreferenceData.getInstance(context);
        student = data.getStudent();
        return student;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(StudentEntity student) {

    }

    @Override
    public Iterable<StudentEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<StudentEntity> findByCourse(Long courseId) {
        return null;
    }


}
