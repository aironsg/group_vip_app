package br.com.devairon.model.entitys;

public class CourseEntity {
    private String nameCourse;

    public CourseEntity() {

    }
    public CourseEntity(String nameCourse) {

        this.nameCourse = nameCourse;
    }
    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "nameCourse='" + nameCourse + '\'' +
                '}';
    }
}
