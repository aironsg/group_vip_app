package br.com.devairon.repository;

import br.com.devairon.model.CourseModel;

public interface CourseRepository {
    public void save(CourseModel course);
    public void delete(CourseModel course);
    public CourseModel findById(Long id);
    public Iterable<CourseModel> findAll();

}
