package com.example.firegallery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadImage extends AppCompatActivity {
    EditText editText;
    Button imgbtn;
    private static final int IMAGE_UPLOAD=1;
    FirebaseStorage storage;
    StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        editText=findViewById(R.id.imgname);
        imgbtn=findViewById(R.id.img);
        storage=FirebaseStorage.getInstance();
        storageRef=storage.getReference();
    }

    public void chooseImage(View view) {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT)  ;
        startActivityForResult(Intent.createChooser(intent,"Image"),IMAGE_UPLOAD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==IMAGE_UPLOAD && resultCode==RESULT_OK){
            if(data.getData()!=null){
                uploadtoFire(data.getData());
            }
            else Toast.makeText(this, "No Image selected", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void uploadtoFire(Uri file) {
        StorageReference image=storageRef.child("images/"+editText.getText().toString());
        final UploadTask task = image.putFile(file);
        task.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(UploadImage.this, "Successfully Uploaded!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(UploadImage.this, "Uploading",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UploadImage.this, "Upload Failed! Try Again.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}