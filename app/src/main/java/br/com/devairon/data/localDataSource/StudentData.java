package br.com.devairon.data.localDataSource;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import br.com.devairon.model.StudentModel;
import br.com.devairon.utils.constants.Constants;

public class StudentData {
    SharedPreferences preferences;

    private static StudentData instance;
    StudentModel student;
    public StudentData(StudentModel student) {
        this.student = student;
    }

    private StudentData(StudentModel student,Context context) {
          preferences = context.getSharedPreferences(Constants.STUDENT_PREFERENCE, Context.MODE_PRIVATE);
       }

    public static synchronized StudentData getInstance(StudentModel student, Context context) {
            if (instance == null) {
                instance = new StudentData(student,context);
            }
            return instance;
        }

    public void saveStudent(StudentModel student){

        SharedPreferences.Editor save = preferences.edit();
        save.putString("firtName", student.getFirstName());
        save.putString("lastName", student.getLastName());
        save.putString("courseName", student.getCourse().getNameCourse());
        save.putString("phoneNumber", student.getPhoneNumber());
        save.apply();
    }
}
