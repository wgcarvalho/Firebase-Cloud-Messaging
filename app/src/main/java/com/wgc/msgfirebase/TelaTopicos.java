package com.wgc.msgfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.messaging.FirebaseMessaging;

public class TelaTopicos extends AppCompatActivity implements View.OnClickListener {
    private FirebaseMessaging firebaseMessaging;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //3ª aula
        setContentView(R.layout.activity_tela_topicos);
        findViewById(R.id.btnInscCinema).setOnClickListener(this);
        findViewById(R.id.btnInscEsporte).setOnClickListener(this);
        findViewById(R.id.btnDesinscCinema).setOnClickListener(this);
        findViewById(R.id.btnDesinscEsporte).setOnClickListener(this);
        firebaseMessaging = FirebaseMessaging.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInscCinema:
                firebaseMessaging.subscribeToTopic("cinema");
                break;
            case R.id.btnInscEsporte:
                firebaseMessaging.subscribeToTopic("esporte");
                break;
            case R.id.btnDesinscCinema:
                firebaseMessaging.unsubscribeFromTopic("cinema");
                break;
            case R.id.btnDesinscEsporte:
                firebaseMessaging.unsubscribeFromTopic("esporte");
                break;
        }
    }
}
