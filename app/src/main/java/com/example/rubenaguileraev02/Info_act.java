package com.example.rubenaguileraev02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {
    private VideoView videoInfo;
    private TextView textoInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);
        videoInfo= (VideoView)findViewById(R.id.vw_VideoInfo);
        String ruta = "android.resource://"+ getPackageName()+"/"+R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoInfo.setVideoURI(uri);
        MediaController media = new MediaController(this);
        videoInfo.setMediaController(media);
        textoInfo = (TextView)findViewById(R.id.txt_info);
        textoInfo.setText("Bienvenido a Banco Bpm donde podrás manejar tus finansas y solicitar los prestamos de nuestro banco, ofrecemos los mejores beneficios para nuestros clientes. No esperes mas y se parte de uno de los bancos mas grandes a nivel latinoamerica y comienza a ganar con nosotros y cumplir tus sueños.");
    }
    public void ONCMaps(View V)
    {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }
}