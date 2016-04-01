package ro.pub.cs.systems.eim.practicaltest01var06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.text.TextWatcher;
import android.widget.Toast;


public class PracticalTest01VarMain06 extends AppCompatActivity {


    private EditText nameEditText = null;
    private EditText websiteEditText = null;
    private Button pressButton = null;
    private Button showHideAdditionalFieldsButton = null;
    private Button navigateButton = null;
    private LinearLayout additionalFieldsContainer = null;


    private ShowHideAdditionalFieldsButtonClickListener showHideAdditionalFieldsButtonClickListener = new ShowHideAdditionalFieldsButtonClickListener();
    private class ShowHideAdditionalFieldsButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (additionalFieldsContainer.getVisibility()) {
                case View.VISIBLE:
                    additionalFieldsContainer.setVisibility(View.INVISIBLE);
                    showHideAdditionalFieldsButton.setText(getResources().getString(R.string.show_additional_fields));
                    break;
                case View.INVISIBLE:
                    additionalFieldsContainer.setVisibility(View.VISIBLE);
                    showHideAdditionalFieldsButton.setText(getResources().getString(R.string.hide_additional_fields));
                    break;
            }
        }
    }

    private EditTextClickListener editTextClickListener = new EditTextClickListener();
    private class EditTextClickListener implements TextWatcher {
        @Override
        public  void onTextChanged (CharSequence s, int start, int before, int count){
            if(s.toString().startsWith("http"))
                pressButton.setBackground(getApplicationContext().getResources().getDrawable(R.color.green));

        }
        @Override
        public void beforeTextChanged (CharSequence s, int start, int count, int after){

        }
        @Override
        public void afterTextChanged (Editable s){

        }


    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText nameEditText = (EditText)findViewById(R.id.name_edit_text);
        savedInstanceState.putString(Constants.USERNAME_EDIT_TEXT, String.valueOf(nameEditText.getText()));
        EditText websiteEditText = (EditText)findViewById(R.id.website_edit_text);
        savedInstanceState.putString(Constants.WEBSITE_EDIT_TEXT, String.valueOf(websiteEditText.getText()));

    }
    private NavigateButtonClickListener navigateButtonClickListener = new NavigateButtonClickListener();
    private class NavigateButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);

                startActivityForResult(intent, Constants.FIRST_ACTIVITY_CODE);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var_main06);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        additionalFieldsContainer = (LinearLayout)findViewById(R.id.additional_fields_container);
        showHideAdditionalFieldsButton = (Button)findViewById(R.id.show_hide_button);
        showHideAdditionalFieldsButton.setOnClickListener(showHideAdditionalFieldsButtonClickListener);


       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        websiteEditText = (EditText)findViewById(R.id.website_edit_text);
        websiteEditText.addTextChangedListener(editTextClickListener);

        pressButton = (Button)findViewById(R.id.press_button);
        pressButton.setBackground(getApplicationContext().getResources().getDrawable(R.color.red));

        navigateButton = (Button)findViewById(R.id.navigate_button);
        navigateButton.setOnClickListener(navigateButtonClickListener);

        if ((savedInstanceState != null) && (savedInstanceState.getString(Constants.USERNAME_EDIT_TEXT) != null)) {
            nameEditText.setText(savedInstanceState.getString(Constants.USERNAME_EDIT_TEXT));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var_main06, menu);
        return true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText nameEditText = (EditText)findViewById(R.id.name_edit_text);
        savedInstanceState.putString(Constants.USERNAME_EDIT_TEXT, String.valueOf(nameEditText.getText()));
        EditText websiteEditText = (EditText)findViewById(R.id.website_edit_text);
        savedInstanceState.putString(Constants.WEBSITE_EDIT_TEXT, String.valueOf(websiteEditText.getText()));

        if (savedInstanceState.getString(Constants.USERNAME_EDIT_TEXT) != null) {
            nameEditText.setText(savedInstanceState.getString(Constants.USERNAME_EDIT_TEXT));
        }
        if (savedInstanceState.getString(Constants.WEBSITE_EDIT_TEXT) != null) {
            websiteEditText.setText(savedInstanceState.getString(Constants.WEBSITE_EDIT_TEXT));
        }
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
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case Constants.FIRST_ACTIVITY_CODE:
               Toast.makeText(this, "ceva", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
