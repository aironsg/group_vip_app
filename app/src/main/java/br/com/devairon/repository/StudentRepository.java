package br.com.devairon.repository;

import android.content.Context;

import br.com.devairon.model.StudentModel;

public interface StudentRepository {
    public void save(StudentModel student, Context context);
    public StudentModel findById(Long id);
    public void deleteById(Long id);
    public void update(StudentModel student);
    public Iterable<StudentModel> findAll();
    public Iterable<StudentModel> findByCourse(Long courseId);
}
