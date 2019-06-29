package com.bufeotec.floridarestaurant.MVVM.Views.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bufeotec.floridarestaurant.R;

public class Inicio extends AppCompatActivity {

    TextView continuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        continuar = findViewById(R.id.continuar);

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(Inicio.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
