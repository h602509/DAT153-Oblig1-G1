package com.example.dat153_oblig1_java;

import android.app.Application;

import com.example.dat153_oblig1_java.Database.EntryRoomDatabase;

public class ApplicationCommons extends Application {

    public class MyApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
            // Initialize Room database
            EntryRoomDatabase.getDatabase(getApplicationContext());
        }
    }
}
