package br.com.devairon.model.repository;

import android.content.Context;

import br.com.devairon.model.entitys.StudentEntity;

public interface StudentRepository {
    public void save(StudentEntity student, Context context);
    public StudentEntity findById(Long id);
    public void deleteById(Long id);
    public void update(StudentEntity student);
    public Iterable<StudentEntity> findAll();
    public Iterable<StudentEntity> findByCourse(Long courseId);
}
