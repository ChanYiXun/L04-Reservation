package sg.edu.rp.c346.id21012377.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etHP;
    EditText etPax;
    DatePicker dp;
    TimePicker tp;
    CheckBox cbS;
    Button btnC;
    Button btnR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etHP = findViewById(R.id.editTextHp);
        etPax = findViewById(R.id.editTextPax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cbS = findViewById(R.id.checkBoxSmoking);
        btnC = findViewById(R.id.buttonConfirm);
        btnR = findViewById(R.id.buttonReset);
        Context context = getApplicationContext();
        CharSequence text = "Name: " + etName.getText() + "\r\n" + "Phone Number: " + etHP.getText().toString() + "\r\n" + "Number of People" + etPax.getText().toString() + "\r\n" + "Time: " + tp.getCurrentHour() + ":"+tp.getCurrentMinute() + "\r\n" + "Date: " +dp.getDayOfMonth() +"/" + (dp.getMonth()+1) + "/" +dp.getYear();
        int duration = Toast.LENGTH_SHORT;


        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter aname", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (etHP.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etPax.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter the number of people", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(cbS.isChecked()) {
                    Toast toast = Toast.makeText(context, text + "\r\nSmoking is allowed", duration);
                    toast.show();
                }
                else {
                    Toast toast =Toast.makeText(context, text + "\r\nSmoking is not allowed", duration);
                    toast.show();

                }
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.getText().clear();
                etHP.getText().clear();
                etPax.getText().clear();
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020,5,1);
            }
        });

    }
}