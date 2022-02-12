package com.example.distanceunitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mKilo;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mKilo = findViewById(R.id.editTextKilometers);
        button = findViewById(R.id.buttonConvert);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double km;
                km = getKm();
                km = Util.convertKmToMi(km);

                mKilo.setText(km+" ");
            }
        });
    }

    private double getKm(){
        double km = 0.0;
        try {
            km = Double.parseDouble(mKilo.getText().toString());
        } catch(NumberFormatException e){
            Log.d("CONVERSION_ISSUE", "getKm: couldn't convert");
        }
        return km;
    }
}