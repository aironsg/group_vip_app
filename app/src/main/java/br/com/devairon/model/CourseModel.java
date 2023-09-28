package br.com.devairon.model;

import androidx.annotation.NonNull;

public class CourseModel {
    private String nameCourse;

    public CourseModel() {

    }
    public CourseModel(String nameCourse) {

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
