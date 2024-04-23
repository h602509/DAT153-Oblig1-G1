package com.example.dat153_oblig1_java.activities;

import static android.Manifest.permission.READ_MEDIA_IMAGES;
import static android.Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.dat153_oblig1_java.Database.Entry;
import com.example.dat153_oblig1_java.R;
import com.example.dat153_oblig1_java.quiz_entries.LiveEntriesRepo;

public class AddQuizEntryActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private Uri selectedImageUri;
    private ImageView previewImage;
    private LiveEntriesRepo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quiz_entry);

        Log.i("Quiz", "AddQuizEntryActivity.onCreate()");

        previewImage = findViewById(R.id.add_entry_image);

        ActivityResultLauncher<PickVisualMediaRequest> pickImage =
                registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
                   if (uri != null) {
                       selectedImageUri = uri;
                       Log.i("Quiz", "AddQuizEntryActivity.onActivityResult(), imgUri = " + selectedImageUri);
                       previewImage.setImageURI(selectedImageUri);
                   }
                });

        ActivityResultLauncher<String[]> requestPermissions = registerForActivityResult(
                new ActivityResultContracts.RequestMultiplePermissions(), grantedPermissions -> {
                    if (grantedPermissions.get(READ_MEDIA_IMAGES) && grantedPermissions.get(READ_MEDIA_VISUAL_USER_SELECTED)) {

                        pickImage.launch(new PickVisualMediaRequest.Builder()
                                .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                                .build());

//                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                        intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
//                        startActivityForResult(intent, REQUEST_CODE);
                    }
                });

        Button findImage = findViewById(R.id.add_picture_button);
        findImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Quiz", "AddQuizActivity.find.image.onClick()");

                String[] permissions = {READ_MEDIA_IMAGES, READ_MEDIA_VISUAL_USER_SELECTED};
                requestPermissions.launch(permissions);
            }
        });


        repo = new LiveEntriesRepo(getApplication());

        Button addNewEntry = findViewById(R.id.add_entry_button);
        addNewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    EditText answerInput = findViewById(R.id.add_entry_answer_input_text_field);
                    String answer = answerInput.getText().toString();
                    Log.i("Quiz", "AddQuizEntryActivity.answerInput.onClick(), answer = " + answer);
                if (!TextUtils.isEmpty(answer) && selectedImageUri != null) {
                    Log.i("Quiz", "AddQuizEntryActivity.addNewEntry.onClick(), imgUri = " + selectedImageUri);
                    getContentResolver().takePersistableUriPermission(selectedImageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    repo.addEntry(new Entry(selectedImageUri, answer));
                    finish();
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            Log.i("Quiz", "AddQuizEntryActivity.onActivityResult(), imgUri = " + selectedImageUri);
            previewImage.setImageURI(selectedImageUri);
        }
    }
}