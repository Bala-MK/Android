package com.example.firegallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ViewImage extends AppCompatActivity {

    RelativeLayout r;
    FirebaseStorage storage;
    StorageReference storageRef;
    EditText editText;
    ImageButton imgbtn;
    ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
        storage=FirebaseStorage.getInstance();
        storageRef=storage.getReference();
        r=findViewById(R.id.rr);
        editText=findViewById(R.id.edit);
        imgbtn=findViewById(R.id.src);
    }

    public void searchImage(View view) {
        LayoutInflater inflater=getLayoutInflater();
        final View v=inflater.inflate(R.layout.customimage,null);
        imgv=v.findViewById(R.id.imageview);
        storageRef.child("images/"+editText.getText().toString()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                r.removeAllViews();
                Glide.with(ViewImage.this).load(uri).into(imgv);
                r.addView(v);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                r.removeAllViews();
                imgv.setImageResource(R.drawable.ic_baseline_broken_image_24);
                r.addView(v);
                Toast.makeText(ViewImage.this, "Image not found. Try Again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}