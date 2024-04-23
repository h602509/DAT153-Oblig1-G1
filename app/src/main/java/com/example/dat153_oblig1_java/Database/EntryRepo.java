package com.example.dat153_oblig1_java.Database;

import android.app.Application;
import android.net.Uri;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.dat153_oblig1_java.DAO.EntryDao;
import com.example.dat153_oblig1_java.interfaces.EntriesRepo;

import java.util.List;

public class EntryRepo implements EntriesRepo {

    private EntryDao mEntryDao;
    private LiveData<List<Entry>> mEntries;

    public EntryRepo(Application application) {
        EntryRoomDatabase db = EntryRoomDatabase.getDatabase(application);
        mEntryDao = db.entryDao();
        mEntries = mEntryDao.loadAllEntriesDsc();
    }


    @Override
    public LiveData<List<Entry>> loadAllEntriesDsc() {
        return mEntries;
    }

    @Override
    public LiveData<List<Entry>> loadAllEntriesAsc() {
        return mEntryDao.loadAllEntriesAsc();
    }

    @Override
    public void addEntry(Entry entry) {
        new insertAsyncTask(mEntryDao).execute(entry);
    }

    @Override
    public void deleteEntry(Entry entry) {
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
