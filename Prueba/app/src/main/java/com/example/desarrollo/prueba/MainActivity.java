package com.example.desarrollo.prueba;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {

    private EditText nombre;
    private EditText email;
    private EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        nombre = (EditText)findViewById(R.id.inputName);
        email = (EditText)findViewById(R.id.inputEmail);
        password = (EditText)findViewById(R.id.inputPass);

        button.setOnClickListener(this);

        /*
        *
        * Otra manera de definir el listener al boton:
        *
            Button button = (Button)findViewById(R.id.sendButton);
            button.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Hola " + nombre.getText(), Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        */
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
    public void onClick(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hola " + nombre.getText(), Toast.LENGTH_SHORT);
        toast.show();
    }
}
