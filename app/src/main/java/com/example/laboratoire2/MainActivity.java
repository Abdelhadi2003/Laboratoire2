package com.example.laboratoire2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_motDePasse, et_confirmerMotDePasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_motDePasse = findViewById(R.id.et_motDePasse);
        et_confirmerMotDePasse = findViewById(R.id.et_confirmerMotDePasse);
    }

    public void onClickChk_afficherMotDePasse(View view) {
        CheckBox chk_afficherMotDePasse = findViewById(R.id.chk_afficherMotDePasse);
        if (chk_afficherMotDePasse.isChecked()) {
            et_motDePasse.setTransformationMethod(null);
        } else {
            et_motDePasse.setTransformationMethod(new PasswordTransformationMethod());
        }
    }

    public void onClickChk_afficherConfirmerMotDePasse(View view) {
        CheckBox chk_afficherConfirmerMotDePasse = findViewById(R.id.chk_afficherConfirmerMotDePasse);
        if (chk_afficherConfirmerMotDePasse.isChecked()) {
            et_confirmerMotDePasse.setTransformationMethod(null);
        } else {
            et_confirmerMotDePasse.setTransformationMethod(new PasswordTransformationMethod());
        }
    }

    public void onClickchk_infolettre(View view) {
        CheckBox chk_infolettre = findViewById(R.id.chk_infolettre);
        Button btn_sauvegarder = (Button)findViewById(R.id.btn_sauvegarder);
        Button btn_quitter = (Button)findViewById(R.id.btn_quitter);
        if(chk_infolettre.isChecked()) {
            btn_sauvegarder.setEnabled(true);
            btn_quitter.setEnabled(true);
        } else {
            btn_sauvegarder.setEnabled(false);
            btn_quitter.setEnabled(false);
        }
    }

    public void onClickbtn_sauvegarder(View view) {
        Context contexte = getApplicationContext();
        String texte = "Votre profil est sauvegardé";
        int duree = Toast.LENGTH_LONG;
        Toast msg_Toast = Toast.makeText(contexte, texte, duree);
        msg_Toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
        msg_Toast.show();
    }

    public void onClickbtn_quitter(View view) {
        AlertDialog.Builder alerteDialogueBuilder = new AlertDialog.Builder(this);
        alerteDialogueBuilder.setMessage("Voulez-vous quitter l'application?");
        alerteDialogueBuilder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alerteDialogueBuilder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alerteDialogue = alerteDialogueBuilder.create();
        alerteDialogue.show();
    }

}