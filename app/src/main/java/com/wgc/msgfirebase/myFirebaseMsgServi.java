package com.wgc.msgfirebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class myFirebaseMsgServi extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        if (remoteMessage.getNotification()!=null && remoteMessage.getData().size()<1){//verifica se há uma notificação
            Log.d("TAG-FCM","Mensagem da notificação: "+remoteMessage.getNotification().getBody());
         //   enviarNotificacao(remoteMessage.getNotification().getBody());
           // Toast.makeText(getApplicationContext(), remoteMessage.getNotification().getBody(), Toast.LENGTH_SHORT).show();
        }
/*
        if (remoteMessage.getData().size()>0){ // vieram dados na mensagem
            //Log.d("TAG-FCM","Dados: "+remoteMessage.getData());
           // enviarDados(remoteMessage.getNotification().getBody(), remoteMessage.getData());
        }*/
    }


    private void enviarNotificacao(String msg){//segunda aula será esse metodo
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent,PendingIntent.FLAG_ONE_SHOT);

        Uri uriSom = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);//som para notificar

        NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(android.R.drawable.ic_dialog_info)//icone que ira aparecer
                .setContentTitle("Firebase Message")//titulo da mensagem
                .setContentText(msg)//texto da mensagem
                .setAutoCancel(true)//fecha automaticamente ao ser clicada
                .setSound(uriSom)//cadastra o som que deve emitir ao notificar
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());


    }

    private void enviarDados(String msg, Map<String,String> dados){//terceira aula será esse metodo
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        //foi criado daqui
        Bundle bundle = new Bundle();

        for (String key: dados.keySet()) {
            String valor = dados.get(key).toString();
            bundle.putString(key, valor);
        }

        intent.putExtras(bundle);
        //ate aqui

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent,PendingIntent.FLAG_ONE_SHOT);

        Uri uriSom = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);//som para notificar

        NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(android.R.drawable.ic_dialog_info)//icone que ira aparecer
                .setContentTitle("Firebase Message")//titulo da mensagem
                .setContentText(msg)//texto da mensagem
                .setAutoCancel(true)//fecha automaticamente ao ser clicada
                .setSound(uriSom)//cadastra o som que deve emitir ao notificar
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());


    }
}
