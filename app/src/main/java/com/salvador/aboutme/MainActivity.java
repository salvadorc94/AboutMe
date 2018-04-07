package com.salvador.aboutme;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void compartir(View v){
        Uri imageUri = Uri.parse("android.resource://com.salvador.aboutme/drawable/"+R.drawable.foto);

        Intent sendIntent= new Intent(Intent.ACTION_SEND);
        sendIntent.setType("image/*");
        sendIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
        sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Nombre/Name: "+((TextView)findViewById(R.id.text_nombre)).getText().toString()+
                "\nTitulo/Title: "+((TextView)findViewById(R.id.text_carrera)).getText().toString()+
                "\nFacebook: "+((TextView)findViewById(R.id.text_face)).getText().toString()+
                "\nGithub: "+((TextView)findViewById(R.id.text_git)).getText().toString()+
                "\nWhatsapp: "+((TextView)findViewById(R.id.text_wp)).getText().toString()+
                "\nCorreo/Email: "+((TextView)findViewById(R.id.text_correo)).getText().toString());

        if (sendIntent.resolveActivity(getPackageManager()) != null){
            startActivity(Intent.createChooser(sendIntent,"Compartir/Share"));
        }

    }
}
