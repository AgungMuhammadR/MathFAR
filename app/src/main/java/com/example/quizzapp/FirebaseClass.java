package com.example.quizzapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseClass {

    public void inputData (String username, String email, String password) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("username" , username);
        user.put("email", email);
        user.put("password", password);
        user.put("skor", "0");
        user.put("listsoal", "");
        user.put("listlevel","");

        // Add a new document with a generated ID
        db.collection("users").add(user);

    }

    public void generateQuestions () {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Create a new user with a first and last name
        Map<String, Object> questions = new HashMap<>();
        questions.put("question","3 + 5 = ");
        questions.put("answer", 8);
        questions.put("level", "easy");
        // Add a new document with a generated ID
        db.collection("kelas6").add(questions);
    }


}
