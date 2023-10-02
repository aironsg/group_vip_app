package br.com.devairon.model.data.local.localDataSource;

import android.content.Context;
import android.content.SharedPreferences;

import br.com.devairon.model.entitys.CourseEntity;
import br.com.devairon.model.entitys.StudentEntity;
import br.com.devairon.view.utils.constants.Constants;

public class StudentPreferenceData {
    SharedPreferences preferences;

    private static StudentPreferenceData instance;
    StudentEntity student;
    CourseEntity course;

    public StudentPreferenceData(StudentEntity student) {
        this.student = student;
    }

    private StudentPreferenceData(Context context) {
        preferences = context.getSharedPreferences(Constants.STUDENT_PREFERENCE, Context.MODE_PRIVATE);
        this.student = new StudentEntity();
    }

    public static synchronized StudentPreferenceData getInstance(Context context) {
        if (instance == null) {
            instance = new StudentPreferenceData(context);
        }
        return instance;
    }

    public void saveStudent(StudentEntity student) {

        SharedPreferences.Editor save = preferences.edit();
        save.putString("firstName", student.getFirstName());
        save.putString("lastName", student.getLastName());
        save.putString("courseName", student.getCourse().getNameCourse());
        save.putString("phoneNumber", student.getPhoneNumber());
        save.apply();
    }

    public StudentEntity getStudent() {

        course = new CourseEntity();
        StudentEntity student = new StudentEntity();
        course.setNameCourse(preferences.getString("courseName", "NA"));
        student.setFirstName(preferences.getString("firstName", "NA"));
        student.setLastName(preferences.getString("lastName", "NA"));
        student.setCourse(course);
        student.setPhoneNumber(preferences.getString("phoneNumber", "NA"));
        return student;


    }
}
