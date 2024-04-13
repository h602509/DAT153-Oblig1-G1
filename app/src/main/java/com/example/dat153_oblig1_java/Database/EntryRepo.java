package com.example.dat153_oblig1_java.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.dat153_oblig1_java.DAO.EntryDao;

import java.util.List;

public class EntryRepo {

    private EntryDao mEntryDao;
    private LiveData<List<Entry>> mEntries;

    public EntryRepo(Application application) {
        EntryRoomDatabase db = EntryRoomDatabase.getDatabase(application);
        mEntryDao = db.entryDao();
        mEntries = mEntryDao.loadAllEntrys();
    }

    public LiveData<List<Entry>> getEntries() {
        return mEntries;
    }

    public void insert(Entry Entry) {
        new insertAsyncTask(mEntryDao).execute(Entry);
    }

    public void delete(Entry Entry) {
        //TODO
    }


    private class insertAsyncTask extends AsyncTask<Entry, Void, Void> {

        private EntryDao mAsyncTaskDao;
        public insertAsyncTask(EntryDao mEntryDao) {
            mAsyncTaskDao = mEntryDao;
        }

        @Override
        protected Void doInBackground(Entry... Entrys) {
            mAsyncTaskDao.insert(Entrys[0]);
            return null;
        }
    }
}
