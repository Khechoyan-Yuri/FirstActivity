package com.yuri_khechoyan.hw1_firstactivity;

/* ========================================================================== */
/*	PROGRAM First Activity

    AUTHOR: Yuri Khechoyan
    COURSE NUMBER: CIS 472
    COURSE SECTION NUMBER: 01
    INSTRUCTOR NAME: Dr. Tian
    PROJECT NUMBER: 1
    DUE DATE: 02/02/2017

SUMMARY

    This program is a simple form application that the end user will fill out
    Application asks for users:
        -First Name
        -Last Name
        -Phone Number
        -Email Address
        -Email Address (re-entry)
        -Desired UserName
        -Password
        -Password (re-entry)
        -Gender (Male/Female)
        -Country of Origin (Spinner)

        Application also has the ability to clear the fields
        and switch between linear/relative layouts (with buttons, respectively)

INPUT

        -First Name
        -Last Name
        -Phone Number
        -Email Address
        -Email Address (re-entry)
        -Desired UserName
        -Password
        -Password (re-entry)
        -Gender (Male/Female)
        -Country of Origin (Spinner)

OUTPUT

    Application will notify user with Toasts:
        -Invalid Email Address Entries
        -Invalid Passwords Entries
        -Confirmation (if there are no entry issues)

ASSUMPTIONS
- Users are smart enough to enter their information accordingly
*/

//Import Statements
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

    //***************
    // MAIN CLASS
    //***************
public class MainActivity extends AppCompatActivity {

    //Creating email variables in order to compare the validity of the email addresses
    EditText email_verify1;
    EditText email_verify2;

    //Creating password variables in order to compare the validity of the passwords
    EditText password_verify1;
    EditText password_verify2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        //Set Email objects equal to their respective IDs
        email_verify1 = (EditText) findViewById(R.id.et_EnterEmail);
        email_verify2 = (EditText) findViewById(R.id.et_ReEnterEmail);


        //Set Password objects equal to their respective IDs
        password_verify1 = (EditText) findViewById(R.id.et_PassWord);
        password_verify2 = (EditText) findViewById(R.id.et_ReEnterPassWord);
    }

    //**********************************************************
    //  Method for CLEARING FIELDS & Setting items to Default
    //**********************************************************

    public void ClearFields(View v) {
        //Delete Text Fields to null
        //when Clear button is pressed
        EditText FirstName = (EditText) findViewById(R.id.et_FirstName);
        FirstName.setText("");
        EditText LastName = (EditText) findViewById(R.id.et_LastName);
        LastName.setText("");
        EditText PhoneNumber = (EditText) findViewById(R.id.et_PhoneNumber);
        PhoneNumber.setText("");
        EditText Email = (EditText) findViewById(R.id.et_EnterEmail);
        Email.setText("");
        EditText ReEmail = (EditText) findViewById(R.id.et_ReEnterEmail);
        ReEmail.setText("");
        EditText UserName = (EditText) findViewById(R.id.et_UserName);
        UserName.setText("");
        EditText Password = (EditText) findViewById(R.id.et_PassWord);
        Password.setText("");
        EditText RePassword = (EditText) findViewById(R.id.et_ReEnterPassWord);
        RePassword.setText("");

        //Set Radio Buttons (whichever was pressed) to default values
        //Default values = initialized state (no button selected)
        RadioButton btn_male = (RadioButton) findViewById(R.id.radio_Male);
        btn_male.setChecked(false);

        RadioButton btn_female = (RadioButton) findViewById(R.id.radio_Female);
        btn_female.setChecked(false);

        //When Clear Button is pressed - Spinner set to default value = (0) - United States
        Spinner country = (Spinner) findViewById(R.id.country_spinner);
        country.setSelection(0);

        Toast.makeText(this, "Fields Cleared", Toast.LENGTH_LONG).show();
    }

    //***********************************************************************
    //Checking Validity of User Input (Emails & Passwords after submission)
    //***********************************************************************

    public void Submit(View v) {
        //If emails match - do not do anything
        if ((email_verify2.getText().toString().trim().equals(email_verify1.getText().toString().trim()))) {
        }
        else{
            //If Email fields do not match, delete current entry & throw toast
            //Only delete current Email entry and give user
            //another attempt at entering the Email
            EditText Email = (EditText) findViewById(R.id.et_EnterEmail);
            Email.setText("");
            EditText ReEmail = (EditText) findViewById(R.id.et_ReEnterEmail);
            ReEmail.setText("");

            Toast.makeText(this, "Emails Do Not Match", Toast.LENGTH_SHORT).show();
        }

        //If passwords match - do not do anything
        if (password_verify2.getText().toString().trim().equals(password_verify1.getText().toString())) {
            //match_password();
        }
        else {
            //If Password fields do not match, delete current entry & throw toast
            //Only delete current Password entry and give user
            //another attempt at entering the Password
            EditText Password = (EditText) findViewById(R.id.et_PassWord);
            Password.setText("");
            EditText RePassword = (EditText) findViewById(R.id.et_ReEnterPassWord);
            RePassword.setText("");

            Toast.makeText(this, "Passwords Do Not Match", Toast.LENGTH_LONG).show();
        }
        //If BOTH EMAILS AND PASSWORDS MATCH - send a confirmation toast
        if((email_verify2.getText().toString().trim().equals(email_verify1.getText().toString().trim()))
                && password_verify2.getText().toString().trim().equals(password_verify1.getText().toString())){

            Toast.makeText(this, "Submission Complete", Toast.LENGTH_SHORT).show();
        }
    }

    //Method to switch to Relative Layout
    public void Relative_Layout(View rl) {
        setContentView(R.layout.relative_layout);
    }

    //Method to switch to Linear Layout
    public void Linear_Layout(View ll) {
        setContentView(R.layout.linear_layout);
    }
}
