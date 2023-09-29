package br.com.devairon.model.data.local.localDataSource;

import android.content.Context;
import android.content.SharedPreferences;

import br.com.devairon.model.entitys.StudentEntity;
import br.com.devairon.view.utils.constants.Constants;

public class StudentData {
    SharedPreferences preferences;

    private static StudentData instance;
    StudentEntity student;
    public StudentData(StudentEntity student) {
        this.student = student;
    }

    private StudentData(StudentEntity student, Context context) {
          preferences = context.getSharedPreferences(Constants.STUDENT_PREFERENCE, Context.MODE_PRIVATE);
       }

    public static synchronized StudentData getInstance(StudentEntity student, Context context) {
            if (instance == null) {
                instance = new StudentData(student,context);
            }
            return instance;
        }

    public void saveStudent(StudentEntity student){

        SharedPreferences.Editor save = preferences.edit();
        save.putString("firtName", student.getFirstName());
        save.putString("lastName", student.getLastName());
        save.putString("courseName", student.getCourse().getNameCourse());
        save.putString("phoneNumber", student.getPhoneNumber());
        save.apply();
    }
}
