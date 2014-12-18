package com.example.desarrollo.timetracker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{
    private TextView labelA, labelB, labelResultado;
    private EditText inputValorA, inputValorB, inputResultado;
    private RadioGroup radioGroup;
    private Button buttonCalcular;
    private Spinner desplegable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelA = (TextView)findViewById(R.id.labelA);
        labelB = (TextView)findViewById(R.id.labelB);
        labelResultado = (TextView)findViewById(R.id.labelResultado);
        inputValorA = (EditText)findViewById(R.id.inputvalorA);
        inputValorB = (EditText)findViewById(R.id.inputvalorB);
        inputResultado = (EditText)findViewById(R.id.inputResultado);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        buttonCalcular = (Button)findViewById(R.id.buttonCalcular);
        desplegable = (Spinner)findViewById(R.id.spinnerUnidades);


        desplegable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(getApplicationContext(), desplegable.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        radioGroup.setOnCheckedChangeListener(this);
        buttonCalcular.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //group.getCheckedRadioButtonId();
        switch (checkedId){
            case R.id.radioDistancia:
                labelA.setText(getResources().getText(R.string.velocidad) + " (km/h)");
                labelB.setText(getResources().getText(R.string.tiempo)+ " (h)");
                labelResultado.setText(getResources().getText(R.string.distancia) + " (km)");
                break;
            case R.id.radioVelocidad:
                labelA.setText(getResources().getText(R.string.distancia) + " (km)");
                labelB.setText(getResources().getText(R.string.tiempo));
                labelResultado.setText(getResources().getText(R.string.velocidad) + "( km/h)");
                break;
            case R.id.radioTiempo:
                labelA.setText(getResources().getText(R.string.distancia) + " (km)");
                labelB.setText(getResources().getText(R.string.velocidad) + " (km/h)");
                labelResultado.setText(getResources().getText(R.string.tiempo) + " (h)");
                break;
        }
    }


    @Override
    public void onClick(View v) {
        Float a = Float.parseFloat(inputValorA.getText().toString());
        Float b = Float.parseFloat(inputValorB.getText().toString());
        Float velocidad, distancia, tiempo;

        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radioDistancia:
                velocidad = a; tiempo = b;
                inputResultado.setText(((Float)(velocidad*tiempo)).toString());
                break;
            case R.id.radioVelocidad:
                distancia = a; tiempo = b;
                inputResultado.setText(((Float)(distancia/tiempo)).toString());
                break;
            case R.id.radioTiempo:
                distancia = a; velocidad = b;
                inputResultado.setText(((Float)(distancia/velocidad)).toString());
                break;
        }
    }

}
