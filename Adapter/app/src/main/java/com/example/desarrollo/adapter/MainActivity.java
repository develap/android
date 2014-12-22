package com.example.desarrollo.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    public static final String EXTRA_MESSAGE = "com.example.desarrollo.adapter.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


    /** Called when the user clicks the Send button */
    public void abrirDistributionGridView(View view) {
        /*
         *  Intent to start an activity called DistribucionGridViewActivity
         */
        Intent intent = new Intent(this, DistribucionGridViewActivity.class);

        /* public Intent putExtra (String name, String value)
         * Add extended data to the intent. The name must include a package prefix, for example the
         * app com.android.contacts would use names like "com.android.contacts.ShowAll".
         */
        intent.putExtra(EXTRA_MESSAGE, "Me a tocado el Gordo!");
        startActivity(intent);
    }

    /** Called when the user clicks the Send button */
    public void abrirDistributionListView(View view) {
        /*
         *  Intent to start an activity called DistribucionListViewActivity
         */
        Intent intent = new Intent(this, DistribucionListViewActivity.class);
        startActivity(intent);
    }
}
