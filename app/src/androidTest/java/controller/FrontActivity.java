package controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import ctec.savingstateapplication.model.AndroidSaveState;
import android.content.Intent;

import com.example.gswe4645.savingstateapp.R;

public class FrontActivity extends Activity {

    private Button sendToOtherScreenButton;
    private EditText nameText;
    private EditText ageText;
    private CheckBox tiredBox;


    private AndroidSaveState saveState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        saveState = (AndroidSaveState) getApplication();

        sendToOtherScreenButton = (Button) findViewById(R.id.submitButton);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText = (EditText) findViewById(R.id.ageText);
        tiredBox = (CheckBox) findViewById(R.id.isTiredBox);

        setupListeners();


    }



    private void setupListeners()
    {
        sendToOtherScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickView)
            {
                String name = nameText.getText().toString();
                int age = Integer.parseInt(ageText.getText(). toString());
                boolean tired = tiredBox.isChecked();

                saveState.setAge(age);
                saveState.setUserName(name);
                saveState.setIsTired(tired);

                Intent newScreenIntent = new Intent(clickView.getContext(), BackPage.class);
                startActivityForResult(newScreenIntent, 0);
            }
        });
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
}
