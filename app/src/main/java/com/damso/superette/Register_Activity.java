package com.damso.superette;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.util.Arrays;
import java.util.List;



import com.damso.superette.database.DatabaseHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register_Activity extends AppCompatActivity {
    EditText mail, pw1, pw2;
    Button allergie, Chronique,CreateAccountButton;
    CheckBox ShowPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingbar;
    private DatabaseReference RootRef;
    private TextView AlreadyHaveAccountLink;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        RootRef = FirebaseDatabase.getInstance().getReference();
        initialise();


        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewAccount();
            }
        });






        //________________SHOW/ HIDE PASSWORD_________________
        ShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pw1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
                else{
                    pw1.setTransformationMethod(PasswordTransformationMethod.getInstance());

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
    private void CreateNewAccount() {
        String email = mail.getText().toString();
        String Password = pw1.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Enter Mail", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(Password)){
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        }
        else{

            mAuth.createUserWithEmailAndPassword(email, Password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                String currentUserID = mAuth.getCurrentUser().getUid();
                                RootRef.child("Users").child(currentUserID).setValue("");



                                SendUserToMainActivity();
                                Toast.makeText(Register_Activity.this, "Created Successfully", Toast.LENGTH_SHORT).show();

                            }
                            else
                            {
                                String message=task.getException().toString();
                                Toast.makeText(Register_Activity.this, "Error : "+message, Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }
    }
}
