package com.example.dat153_oblig1_java.quiz_entries;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.dat153_oblig1_java.DAO.EntryDao;
import com.example.dat153_oblig1_java.Database.Entry;
import com.example.dat153_oblig1_java.Database.EntryRoomDatabase;
import com.example.dat153_oblig1_java.interfaces.EntriesRepo;

import java.util.List;

public class LiveEntriesRepo implements EntriesRepo {

    private EntryDao mEntryDao;

    public LiveEntriesRepo(Application application) {
        EntryRoomDatabase db = EntryRoomDatabase.getDatabase(application);
        mEntryDao = db.entryDao();
    }

    public LiveData<List<Entry>> getEntriesDsc() {
        return mEntryDao.loadAllEntriesDsc();
    }

    public LiveData<List<Entry>> getEntriesAsc() {
        return mEntryDao.loadAllEntriesAsc();
    }

    public void insert(Entry entry) {
        new insertAsyncTask(mEntryDao).execute(entry);
    }

    public void delete(Entry Entry) {
        //TODO
    }

    @Override
    public void deleteEntry(Entry entry) {
        
    }

    @Override
    public LiveData<List<Entry>> loadAllEntriesDesc() {
        return null;
    }

    @Override
    public void addEntry(int imgRef, String answer) {

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
