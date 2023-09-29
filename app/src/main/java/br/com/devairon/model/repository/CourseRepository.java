package br.com.devairon.model.repository;

import br.com.devairon.model.entitys.CourseEntity;

public interface CourseRepository {
    public void save(CourseEntity course);
    public void delete(CourseEntity course);
    public CourseEntity findById(Long id);
    public Iterable<CourseEntity> findAll();

}
