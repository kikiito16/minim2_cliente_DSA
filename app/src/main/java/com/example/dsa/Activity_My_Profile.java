package com.example.dsa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dsa.models.Credentials;
import com.example.dsa.models.User;

public class Activity_My_Profile extends AppCompatActivity {

    TextView titleTextView;
    ImageView editProfileImage;
    TextView usernameText;
    TextView usernameOut;
    TextView usernameEdit;
    TextView nameText;
    TextView nameOut;
    TextView nameEdit;
    TextView mailText;
    TextView mailOut;
    TextView mailEdit;
    TextView moneyText;
    TextView moneyOut;
    TextView editPasswordOld;
    TextView editPasswordNew1;
    TextView editPasswordNew2;
    Button deleteBtn;
    Button returnBtn;
    ProgressBar progressBar;
    TextView loadingTextView;
    TextView InsigniasText;
    RecyclerView recyclerInsignias;


    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        titleTextView = findViewById(R.id.titleProfileText);
        editProfileImage = findViewById(R.id.editProfileImage);
        editProfileImage.setImageResource(R.drawable.pencil_edit);
        usernameText = findViewById(R.id.usernameProfileText);
        usernameOut = findViewById(R.id.usernameProfileOut);
        usernameEdit = findViewById(R.id.editProfileUsernameOut);
        nameText = findViewById(R.id.nameProfileText);
        nameOut = findViewById(R.id.nameProfileOut);
        nameEdit = findViewById(R.id.editProfileNameOut);
        mailText = findViewById(R.id.mailProfileText);
        mailOut = findViewById(R.id.mailProfileOut);
        mailEdit = findViewById(R.id.editProfileMailOut);
        moneyText = findViewById(R.id.moneyProfileText);
        moneyOut = findViewById(R.id.moneyProfileOut);
        editPasswordOld = findViewById(R.id.editPasswordOld);
        editPasswordNew1 = findViewById(R.id.editPasswordNew1);
        editPasswordNew2 = findViewById(R.id.editPasswordNew2);
        deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setText("Delete account");
        returnBtn = findViewById(R.id.returnBtn);
        returnBtn.setText("Return");
        progressBar = findViewById(R.id.profileProgressBar);
        loadingTextView = findViewById(R.id.loadingProfileText);
        InsigniasText= findViewById(R.id.InsigniasProfileText);
        recyclerInsignias= findViewById(R.id.RecycletInsigniasOut);

        titleTextView.setVisibility(View.INVISIBLE);
        editProfileImage.setVisibility(View.INVISIBLE);
        usernameText.setVisibility(View.INVISIBLE);
        usernameOut.setVisibility(View.INVISIBLE);
        usernameEdit.setVisibility(View.INVISIBLE);
        nameText.setVisibility(View.INVISIBLE);
        nameOut.setVisibility(View.INVISIBLE);
        nameEdit.setVisibility(View.INVISIBLE);
        mailText.setVisibility(View.INVISIBLE);
        mailOut.setVisibility(View.INVISIBLE);
        mailEdit.setVisibility(View.INVISIBLE);
        deleteBtn.setVisibility(View.INVISIBLE);
        returnBtn.setVisibility(View.INVISIBLE);
        moneyOut.setVisibility(View.INVISIBLE);
        moneyText.setVisibility(View.INVISIBLE);
        editPasswordOld.setVisibility(View.INVISIBLE);
        editPasswordNew1.setVisibility(View.INVISIBLE);
        editPasswordNew2.setVisibility(View.INVISIBLE);
        InsigniasText.setVisibility(View.INVISIBLE);
        recyclerInsignias.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        loadingTextView.setVisibility(View.VISIBLE);

        int ID = getIntent().getIntExtra("ID", 0);
        this.id = ID;

        ControllerGetUser ctrl = new ControllerGetUser();
        ctrl.start(this, ID);
    }

    public void returnBtn_Click(View v) {
        if(returnBtn.getText() == "Return")
            finish();
        else if (returnBtn.getText() == "Submit changes"){
            titleTextView.setVisibility(View.INVISIBLE);
            editProfileImage.setVisibility(View.INVISIBLE);
            usernameText.setVisibility(View.INVISIBLE);
            usernameOut.setVisibility(View.INVISIBLE);
            usernameEdit.setVisibility(View.INVISIBLE);
            nameText.setVisibility(View.INVISIBLE);
            nameOut.setVisibility(View.INVISIBLE);
            nameEdit.setVisibility(View.INVISIBLE);
            mailText.setVisibility(View.INVISIBLE);
            mailOut.setVisibility(View.INVISIBLE);
            mailEdit.setVisibility(View.INVISIBLE);
            deleteBtn.setVisibility(View.INVISIBLE);
            returnBtn.setVisibility(View.INVISIBLE);
            moneyOut.setVisibility(View.INVISIBLE);
            moneyText.setVisibility(View.INVISIBLE);
            InsigniasText.setVisibility(View.INVISIBLE);
            recyclerInsignias.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            loadingTextView.setVisibility(View.VISIBLE);
            ControllerUpdateUser ctrl = new ControllerUpdateUser();
            ctrl.start(this, new User(String.valueOf(usernameEdit.getText()), String.valueOf(nameEdit.getText()),
                    String.valueOf(mailEdit.getText()), Integer.parseInt(String.valueOf(moneyOut.getText())), id));
        }
        else {
            String text1 = String.valueOf(editPasswordNew1.getText());
            String text2 = String.valueOf(editPasswordNew2.getText());
            if(text1.equals(text2)) {
                titleTextView.setVisibility(View.INVISIBLE);
                editProfileImage.setVisibility(View.INVISIBLE);
                usernameText.setVisibility(View.INVISIBLE);
                usernameOut.setVisibility(View.INVISIBLE);
                usernameEdit.setVisibility(View.INVISIBLE);
                nameText.setVisibility(View.INVISIBLE);
                nameOut.setVisibility(View.INVISIBLE);
                nameEdit.setVisibility(View.INVISIBLE);
                mailText.setVisibility(View.INVISIBLE);
                mailOut.setVisibility(View.INVISIBLE);
                mailEdit.setVisibility(View.INVISIBLE);
                deleteBtn.setVisibility(View.INVISIBLE);
                returnBtn.setVisibility(View.INVISIBLE);
                moneyOut.setVisibility(View.INVISIBLE);
                moneyText.setVisibility(View.INVISIBLE);
                InsigniasText.setVisibility(View.INVISIBLE);
                recyclerInsignias.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                loadingTextView.setVisibility(View.VISIBLE);
                ControllerLogin ctrl = new ControllerLogin();
                ctrl.start(this, new Credentials(String.valueOf(usernameEdit.getText()), String.valueOf(editPasswordOld.getText())));
            }
            else
                Toast.makeText(getApplicationContext(), "Error: New passwords are different. Try again.", Toast.LENGTH_LONG).show();
        }
    }

    public void editProfileImage_Click (View v) {
        if(returnBtn.getText() == "Return") {
            titleTextView.setText("Edit profile");
            editProfileImage.setImageResource(R.drawable.key);
            usernameOut.setVisibility(View.INVISIBLE);
            usernameEdit.setText(usernameOut.getText());
            usernameEdit.setVisibility(View.VISIBLE);
            nameOut.setVisibility(View.INVISIBLE);
            nameEdit.setText(nameOut.getText());
            nameEdit.setVisibility(View.VISIBLE);
            mailOut.setVisibility(View.INVISIBLE);
            mailEdit.setText(mailOut.getText());
            mailEdit.setVisibility(View.VISIBLE);
            moneyOut.setVisibility(View.INVISIBLE);
            moneyText.setVisibility(View.INVISIBLE);
            InsigniasText.setVisibility(View.INVISIBLE);
            recyclerInsignias.setVisibility(View.VISIBLE);
            deleteBtn.setText("Cancel");
            returnBtn.setText("Submit changes");
        }
        else {
            titleTextView.setText("Edit password");
            editProfileImage.setVisibility(View.INVISIBLE);
            usernameText.setText("Current password");
            usernameOut.setVisibility(View.INVISIBLE);
            usernameEdit.setVisibility(View.INVISIBLE);
            nameText.setText("New password");
            nameOut.setVisibility(View.INVISIBLE);
            nameEdit.setVisibility(View.INVISIBLE);
            mailText.setText("Repeat password");
            mailOut.setVisibility(View.INVISIBLE);
            mailEdit.setText(mailOut.getText());
            mailEdit.setVisibility(View.INVISIBLE);
            moneyOut.setVisibility(View.INVISIBLE);
            moneyText.setVisibility(View.INVISIBLE);
            InsigniasText.setVisibility(View.INVISIBLE);
            recyclerInsignias.setVisibility(View.INVISIBLE);
            editPasswordOld.setVisibility(View.VISIBLE);
            editPasswordNew1.setVisibility(View.VISIBLE);
            editPasswordNew2.setVisibility(View.VISIBLE);
            returnBtn.setText("Update password");
        }
    }

    public void deleteBtn_Click (View v) {
        if(returnBtn.getText() == "Return")
            Toast.makeText(getApplicationContext(), "Ooops... not implemented.", Toast.LENGTH_LONG).show();
        else if (returnBtn.getText() == "Submit changes"){
            titleTextView.setText("Profile");
            editProfileImage.setImageResource(R.drawable.pencil_edit);
            usernameOut.setVisibility(View.VISIBLE);
            usernameEdit.setVisibility(View.INVISIBLE);
            nameOut.setVisibility(View.VISIBLE);
            nameEdit.setVisibility(View.INVISIBLE);
            mailOut.setVisibility(View.VISIBLE);
            mailEdit.setVisibility(View.INVISIBLE);
            moneyOut.setVisibility(View.VISIBLE);
            moneyText.setVisibility(View.VISIBLE);
            InsigniasText.setVisibility(View.INVISIBLE);
            recyclerInsignias.setVisibility(View.VISIBLE);
            returnBtn.setText("Return");
            deleteBtn.setText("Delete account");
        }
        else {
            titleTextView.setText("Edit profile");
            editProfileImage.setImageResource(R.drawable.key);
            editProfileImage.setVisibility(View.VISIBLE);
            usernameText.setText("Username");
            usernameOut.setVisibility(View.INVISIBLE);
            usernameEdit.setText(usernameOut.getText());
            usernameEdit.setVisibility(View.VISIBLE);
            nameText.setText("Name");
            nameOut.setVisibility(View.INVISIBLE);
            nameEdit.setText(nameOut.getText());
            nameEdit.setVisibility(View.VISIBLE);
            mailText.setText("Mail");
            mailOut.setVisibility(View.INVISIBLE);
            mailEdit.setText(mailOut.getText());
            mailEdit.setVisibility(View.VISIBLE);
            moneyOut.setVisibility(View.INVISIBLE);
            moneyText.setVisibility(View.INVISIBLE);
            InsigniasText.setVisibility(View.INVISIBLE);
            recyclerInsignias.setVisibility(View.VISIBLE);
            editPasswordOld.setVisibility(View.INVISIBLE);
            editPasswordNew1.setVisibility(View.INVISIBLE);
            editPasswordNew2.setVisibility(View.INVISIBLE);
            returnBtn.setText("Submit changes");
        }
    }
}