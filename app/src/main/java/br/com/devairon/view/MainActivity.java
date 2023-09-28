package br.com.devairon.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.devairon.R;
import br.com.devairon.controller.StudentController;
import br.com.devairon.model.CourseModel;
import br.com.devairon.model.StudentModel;
import br.com.devairon.utils.constants.Constants;

public class MainActivity extends AppCompatActivity {
    private StudentModel student = new StudentModel();
    private CourseModel course = new CourseModel();
    private ViewHolder mViewHolder = new ViewHolder();
    private StudentController studentController = new StudentController();

    private boolean isFieldValid = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewHolder.editFirstName = findViewById(R.id.editText_firstName);
        mViewHolder.editLastName = findViewById(R.id.editText_lastName);
        mViewHolder.editNameCourse = findViewById(R.id.editText_nameCourse);
        mViewHolder.editPhoneNumber = findViewById(R.id.editText_phone);
        mViewHolder.buttonSave = findViewById(R.id.btn_save);
        mViewHolder.buttonClear = findViewById(R.id.btn_clear);
        mViewHolder.buttonFinished = findViewById(R.id.btn_finished);

        mViewHolder.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearEditText();
            }
        });

        mViewHolder.buttonFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Volte Sempre!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        mViewHolder.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFieldValid = checkAllFields();
                if (isFieldValid) {
                    studentController.save(getDataStudent(), getApplicationContext());
                    Toast.makeText(getApplicationContext(), "Estudante Salvo com sucesso!", Toast.LENGTH_LONG).show();
                    clearEditText();
                }else{
                    Toast.makeText(getApplicationContext(), "Error! Dados Incompletos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void clearEditText() {
        mViewHolder.editFirstName.setText("");
        mViewHolder.editLastName.setText("");
        mViewHolder.editNameCourse.setText("");
        mViewHolder.editPhoneNumber.setText("");
    }

    private StudentModel getDataStudent() {

        student.setFirstName(mViewHolder.editFirstName.getText().toString());
        student.setLastName(mViewHolder.editLastName.getText().toString());
        course.setNameCourse(mViewHolder.editNameCourse.getText().toString());
        student.setCourse(course);
        student.setPhoneNumber(mViewHolder.editPhoneNumber.getText().toString());
        return student;
    }

    private boolean checkAllFields() {
        StudentModel studentData = getDataStudent();
        if (TextUtils.isEmpty(studentData.getFirstName())) {
            mViewHolder.editFirstName.setError("Campo Obrigatorio");
            return false;
        }
        if (TextUtils.isEmpty(studentData.getLastName())) {
            mViewHolder.editLastName.setError("Campo Obrigatorio");
            return false;
        }
        if (TextUtils.isEmpty(studentData.getCourse().getNameCourse())) {
            mViewHolder.editNameCourse.setError("Campo Obrigatorio");
            return false;
        }
        if (TextUtils.isEmpty(studentData.getPhoneNumber())) {
            mViewHolder.editPhoneNumber.setError("Campo Obrigatorio");
            return false;
        }
        return true;
    }


    private class ViewHolder {
        EditText editFirstName;
        EditText editLastName;
        EditText editNameCourse;
        EditText editPhoneNumber;
        Button buttonSave;
        Button buttonClear;
        Button buttonFinished;


    }
}