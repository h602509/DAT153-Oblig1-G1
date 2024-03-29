package com.example.dat153_oblig1_java.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.dat153_oblig1_java.Dao.EntryDao;
import com.example.dat153_oblig1_java.quiz_entries.EntryModel;

import java.util.List;

public class EntryRepo {

    private EntryDao mEntryDao;
    private LiveData<List<EntryModel>> mEntries;

    public EntryRepo(Application application) {
        EntryRoomDatabase db = EntryRoomDatabase.getDatabase(application);
        mEntryDao = db.entryDao();
        mEntries = mEntryDao.loadAllEntryModels();
    }

    public LiveData<List<EntryModel>> getEntries() {
        return mEntries;
    }

    public void insert(EntryModel entryModel) {
        new insertAsyncTask(mEntryDao).execute(entryModel);
    }

    public void delete(EntryModel entryModel) {
        //TODO
    }


    private class insertAsyncTask extends AsyncTask<EntryModel, Void, Void> {

        private EntryDao mAsyncTaskDao;
        public insertAsyncTask(EntryDao mEntryDao) {
            mAsyncTaskDao = mEntryDao;
        }

        @Override
        protected Void doInBackground(EntryModel... entryModels) {
            mAsyncTaskDao.insert(entryModels[0]);
            return null;
        }
    }
}
