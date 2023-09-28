package br.com.devairon.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.devairon.R;
import br.com.devairon.model.CourseModel;
import br.com.devairon.model.StudentModel;

public class MainActivity extends AppCompatActivity {
    private StudentModel student = new StudentModel();
    private CourseModel course = new CourseModel();
    private ViewHolder mViewHolder = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning ID of the toolbar to a variable
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // using toolbar as ActionBar
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
                saveStudent();
            }
        });

    }

    private void saveStudent() {
        student.setFirstName(mViewHolder.editFirstName.getText().toString());
        student.setLastName(mViewHolder.editLastName.getText().toString());
        course.setNameCourse(mViewHolder.editNameCourse.getText().toString());
        student.setCourse(course);
        student.setPhoneNumber(mViewHolder.editPhoneNumber.getText().toString());
        clearEditText();
        Toast.makeText(getApplicationContext(), "Estudante Salvo com sucesso!", Toast.LENGTH_SHORT).show();
        System.out.println(student.toString());


    }

    private void clearEditText() {
        mViewHolder.editFirstName.setText("");
        mViewHolder.editLastName.setText("");
        mViewHolder.editNameCourse.setText("");
        mViewHolder.editPhoneNumber.setText("");
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