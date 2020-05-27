package com.wgc.msgfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseMessaging firebaseMessaging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tudo que esta dentro do if é para a terceira aula
        if (getIntent().getExtras() != null){

            String nome = getIntent().getExtras().get("promocao_nome").toString();
            String valor = getIntent().getExtras().get("promocao_valor").toString();
            String validade = getIntent().getExtras().get("promocao_validade").toString();

            TextView textView = (TextView)findViewById(R.id.txResult);

            textView.setText(nome + valor+validade);

        }
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(),TelaTopicos.class);
        startActivity(i);
    }
}
