package controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import ctec.savingstateapplication.model.AndroidSaveState;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import com.example.gswe4645.savingstateapp.R;

public class BackPage extends AppCompatActivity
{


    private AndroidSaveState saveState;
    private Button backButton;
    private TextView userText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_page);

        saveState = (AndroidSaveState) getApplication();
        backButton = (Button) findViewById(R.id.backButton);
        userText = (TextView) findViewById(R.id.userText);

        loadContent();

        setupListeners();
    }


    private void loadContent()
    {
        userText.setText(saveState.getUserName() + " is " + saveState.getAge()
        + " years old and their tired status is " + saveState.getIsTired());
    }














    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_back_page, menu);
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
}
