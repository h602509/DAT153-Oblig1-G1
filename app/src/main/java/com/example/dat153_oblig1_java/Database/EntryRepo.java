package com.example.dat153_oblig1_java.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dat153_oblig1_java.Dao.EntryDao;
import com.example.dat153_oblig1_java.quiz_entries.EntryModel;

import java.util.List;

public class EntryRepo {

    private EntryDao mEntryDao;
    private LiveData<List<EntryModel>> mEntries;

    EntryRepo(Application application) {
        EntryRoomDatabase db = EntryRoomDatabase.getDatabase(application);
        mEntryDao = db.entryDao();
        mEntries = mEntryDao.loadAllEntryModels();

    }

}
