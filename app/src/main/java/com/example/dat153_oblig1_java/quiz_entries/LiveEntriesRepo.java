package com.example.dat153_oblig1_java.quiz_entries;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.dat153_oblig1_java.DAO.EntryDao;
import com.example.dat153_oblig1_java.Database.Entry;
import com.example.dat153_oblig1_java.Database.EntryRoomDatabase;
import com.example.dat153_oblig1_java.R;
import com.example.dat153_oblig1_java.interfaces.EntriesRepo;

import java.util.List;

public class LiveEntriesRepo implements EntriesRepo {

    private EntryDao mEntryDao;

    public LiveEntriesRepo(Application application) {
        EntryRoomDatabase db = EntryRoomDatabase.getDatabase(application);
        mEntryDao = db.entryDao();

        if (mEntryDao.getSize() == 0) {
            initRepo(application.getApplicationContext());
        }
    }

    private void initRepo(Context context) {
        mEntryDao.insert(new Entry(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.drawable.dog), "dog"));
        mEntryDao.insert(new Entry(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.drawable.horse), "horse"));
        mEntryDao.insert(new Entry(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.drawable.cat), "cat"));
    }

    @Override
    public LiveData<List<Entry>> loadAllEntriesDsc() {
        return mEntryDao.loadAllEntriesDsc();
    }

    @Override
    public LiveData<List<Entry>> loadAllEntriesAsc() {
        return mEntryDao.loadAllEntriesAsc();
    }


    @Override
    public void deleteEntry(Entry entry) {
        mEntryDao.delete(entry);
    }

    @Override
    public void addEntry(Entry entry) {
        mEntryDao.insert(entry);
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
