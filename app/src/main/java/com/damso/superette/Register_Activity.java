package com.damso.superette;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Arrays;
import java.util.List;



import com.damso.superette.database.DatabaseHelper;



public class Register_Activity extends AppCompatActivity {
    EditText mail, pw1, pw2;
    Button allergie, Chronique,CreateAccountButton;
    CheckBox ShowPassword;
    private TextView AlreadyHaveAccountLink;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialise();
        db = new DatabaseHelper(this);
        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = mail.getText().toString();
                String s2 = pw1.getText().toString();
                String s3 = pw2.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals("")){
                    Toast.makeText(Register_Activity.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (s2.equals(s3)){
                        Boolean checkmail = db.checkmail(s1);
                        if(checkmail==true){
                            Boolean insert = db.insert(s1,s2);
                            if (insert == true){
                                Toast.makeText(getApplicationContext(), "Registered Succesfully", Toast.LENGTH_SHORT).show();
                                SendUserToMainActivity();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password Does Not Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });






        //________________SHOW/ HIDE PASSWORD_________________
        ShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pw1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    pw2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    pw1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    pw2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });



        //--------------FINISHED SHOW/HIDE PW----------------
        //___________ON CLICK BUTTON TA3 ALLERGIE______________________
        allergie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SHOW ALERT DIALOG OF ALLERGIES
                AlertDialog.Builder builder = new AlertDialog.Builder(Register_Activity.this);

                // String array for alert dialog multi choice items
                String[] Allergies = new String[]{
                        "Poisson","lait","Blé", "Oeufs",
                        "Fruit De mer", "Arachide",
                        "Fruits A écailles"
                };

                // Boolean array for initial selected items
                final boolean[] init = new boolean[]{
                        false,false,
                        false,false,
                        false,false,false
                };

                // Convert Allergies array to list
                final List<String> colorsList = Arrays.asList(Allergies);

                // Set multiple choice items for alert dialog

                builder.setMultiChoiceItems(Allergies, init,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                // Update the current focused item's checked status
                                init[which] = isChecked;

                                // Get the current focused item
                                String currentItem = colorsList.get(which);

                                // Notify the current action
                                Toast.makeText(getApplicationContext(),
                                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
                            }
                        });

                // Specify the dialog is not cancelable
                builder.setCancelable(false);

                // Set a title for alert dialog
                builder.setTitle("Selectionne Tes Allergies");

                // Set the positive/yes button click listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // MIN YECLICKI OK GHADI TEDI DATA LI RAHOM TRUE HNA
                        // L ACTIVITY TA3 MAIN W LAZEM YETSAUVGARDAW DATA

                    }

                });


                // Set the negative/no button click listener
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Min Yeclicki cancel tsema maghadi yedi walo l next act
                        // w Fel main kolesh Yetafficha
                    }
                });

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
            }
        });
        //--------FINISHED ON CLICK BUTTON TA3 ALLERGIE----------------

        //__________ON CLICK BUUTON DE MALADIE CHRONIQUE_____________
        Chronique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SHOW ALER DIALOG OF MALADIE CHRONIQUE
                AlertDialog.Builder builder = new AlertDialog.Builder(Register_Activity.this);

                // String array for alert dialog multi choice items
                String[] Allergies = new String[]{
                        "Diabète", "HyperTension"
                };

                // Boolean array for initial selected items
                final boolean[] init = new boolean[]{
                        false,false
                };

                // Convert Allergies array to list
                final List<String> colorsList = Arrays.asList(Allergies);

                // Set multiple choice items for alert dialog

                builder.setMultiChoiceItems(Allergies, init,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                // Update the current focused item's checked status
                                init[which] = isChecked;

                                // Get the current focused item
                                String currentItem = colorsList.get(which);

                                // Notify the current action
                                Toast.makeText(getApplicationContext(),
                                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
                            }
                        });

                // Specify the dialog is not cancelable
                builder.setCancelable(false);

                // Set a title for alert dialog
                builder.setTitle("Selectionne La Maladie Chronique");

                // Set the positive/yes button click listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // MIN YECLICKI OK GHADI TEDI DATA LI RAHOM TRUE HNA
                        // L ACTIVITY TA3 MAIN W LAZEM YETSAUVGARDAW DATA

                    }

                });


                // Set the negative/no button click listener
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Min Yeclicki cancel tsema maghadi yedi walo l next act
                        // w Fel main kolesh Yetafficha
                    }
                });

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
            }

        });
        //--------FINSHED ON CLICK BUTTON TA3 MALADIE CHRONIQUE------------

        //________When Click On Already Have An Account_______GO TO LOGIN ACT
        AlreadyHaveAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToLoginActivity();
            }
        });
    }
    private void initialise() {
        mail = findViewById(R.id.register_mail);
        pw1 = findViewById(R.id.register_password);
        pw2 = findViewById(R.id.register_confirm_password);


        CreateAccountButton=findViewById(R.id.register_final);
        AlreadyHaveAccountLink = findViewById(R.id.haveit);
        ShowPassword = findViewById(R.id.Password_Checkbox);
        //loadingbar=new ProgressDialog(this);
        allergie = findViewById(R.id.allergie);
        Chronique = findViewById(R.id.chronique);
    }
    //_______________SEND USER TO MAIN ACTIVITY_______________________
    private void SendUserToMainActivity() {
        Intent MainIntent = new Intent(Register_Activity.this, MainActivity.class);
        MainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(MainIntent);
        finish();
    }
    //-------------FINISHED SEND USER TO MAIN ACTIVITY--------------

    //_______________SEND USER TO LOGIN ACT___________________
    private void SendUserToLoginActivity() {

        Intent LoginIntent = new Intent(Register_Activity.this, LoginActivity.class);
        startActivity(LoginIntent);
    }
    //--------------Finished Send User TO LOGIN-------------------

}
