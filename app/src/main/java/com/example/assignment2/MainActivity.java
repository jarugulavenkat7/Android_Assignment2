package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    double totalTime;

    public void getTime(View v){
        EditText width=findViewById(R.id.widthOfRoomET);
        EditText length=findViewById(R.id.lengthOfRoomET);
        EditText height=findViewById(R.id.heightOfRoomET);
        TextView displayTime=findViewById(R.id.displayTimeTV);
        EditText time=findViewById(R.id.timeEt);
        EditText persons=findViewById(R.id.personsET);
        Button btn=findViewById(R.id.celingBTN);
        Button timeBTN=findViewById(R.id.minHoursBTN);
        try {
            double w = Double.parseDouble(width.getText().toString());
            double l = Double.parseDouble(length.getText().toString());
            double totalArea = 0;
            if (height.getText().toString().isEmpty()) {
                double h = 14;
                totalArea = (2 * w + 2 * l) * h;
                btn.setText("Include Celing");
            } else {
                double h = Double.parseDouble(height.getText().toString());
                totalArea = (2 * w + 2 * l) * h;
                btn.setText("Include Celing");
            }
            if (time.getText().toString().isEmpty()) {
                totalTime = (totalArea * 20) / 60;
            } else {
                double t = Double.parseDouble(time.getText().toString());
                totalTime = (totalArea * t) / 60;
            }
            if (!persons.getText().toString().isEmpty()) {
                double p = Double.parseDouble(persons.getText().toString());
                totalTime = totalTime / p;
            }
            timeBTN.setText("In Hours");
            totalTime = (int) (totalTime * 100) / 100.0;
            displayTime.setText(String.valueOf(totalTime)+" "+"mins");
        }
        catch(Exception ex){
            displayTime.setText(ex.getMessage());
        }
    }
    public void getTimeWithCeiling(View v) {

        Button btn = findViewById(R.id.celingBTN);
        String currentString = btn.getText().toString();
        if (currentString.equalsIgnoreCase("Include Celing")) {

            EditText width = findViewById(R.id.widthOfRoomET);
            EditText length = findViewById(R.id.lengthOfRoomET);
            EditText height = findViewById(R.id.heightOfRoomET);
            EditText persons = findViewById(R.id.personsET);
            EditText time = findViewById(R.id.timeEt);
            TextView displayTime = findViewById(R.id.displayTimeTV);
            try {
                double w = Double.parseDouble(width.getText().toString());
                double l = Double.parseDouble(length.getText().toString());

                double totalArea = 0;
                if (height.getText().toString().isEmpty()) {
                    double h = 14;
                    totalArea = ((2 * w + 2 * l) * h) + (w * l);
                    btn.setText("Exclude Celing");
                } else {
                    double h = Double.parseDouble(height.getText().toString());
                    totalArea = ((2 * w + 2 * l) * h) + (w * l);
                    btn.setText("Exclude Celing");
                }
                if (time.getText().toString().isEmpty()) {
                    totalTime = (totalArea * 20) / 60;
                } else {
                    double t = Double.parseDouble(time.getText().toString());
                    totalTime = (totalArea * t) / 60;
                }
                if (!persons.getText().toString().isEmpty()) {
                    double p = Double.parseDouble(persons.getText().toString());
                    totalTime = totalTime / p;
                }
                totalTime = (int) (totalTime * 100) / 100.0;
                displayTime.setText(String.valueOf(totalTime)+" "+"mins");
            } catch (Exception ex) {
                displayTime.setText(ex.getMessage());

            }
        }else{
                getTime(v);
            }


}


    public void reset(View v){
        EditText width=findViewById(R.id.widthOfRoomET);
        EditText length=findViewById(R.id.lengthOfRoomET);
        EditText height=findViewById(R.id.heightOfRoomET);
        TextView displayTime=findViewById(R.id.displayTimeTV);
        EditText time=findViewById(R.id.timeEt);
        EditText persons=findViewById(R.id.personsET);
        width.setText("");
        length.setText("");
        displayTime.setText("");
        height.setText("");
        time.setText("");
        persons.setText("");
    }
    public void switchMinutesAndHours(View v){
        Button btn=findViewById(R.id.minHoursBTN);
        TextView displayTime=findViewById(R.id.displayTimeTV);
        String currentString=btn.getText().toString();
        if(currentString.equalsIgnoreCase("In Minutes")){
            totalTime=(int) (totalTime*60*100)/100.0;
            displayTime.setText(String.valueOf(totalTime)+" "+"mins");
            btn.setText("In Hours");
        }
        else if(currentString.equalsIgnoreCase("In Hours")){
            totalTime=(int) ((totalTime/60)*100)/100.0;
            displayTime.setText(String.valueOf(totalTime)+" "+"hrs");
            btn.setText("In Minutes");
        }
    }
}