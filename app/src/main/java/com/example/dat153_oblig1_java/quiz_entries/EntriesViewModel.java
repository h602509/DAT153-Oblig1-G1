package com.example.dat153_oblig1_java.quiz_entries;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dat153_oblig1_java.Database.EntryRepo;
import com.example.dat153_oblig1_java.R;

import java.util.ArrayList;
import java.util.List;

public class EntriesViewModel extends AndroidViewModel {

    private EntryRepo mEntryRepo;
    private LiveData<List<EntryModel>> mEntries;

    public EntriesViewModel(@NonNull Application application) {
        super(application);
        Log.i("Quiz", "LiveData.initentries(), Entries added: {cat, dog, horse}");
        mEntryRepo = new EntryRepo(application);
        mEntries = mEntryRepo.getEntries();
        initEntries();
    }

    private void initEntries() {
        if (mEntryRepo.getEntries() == null) {
            mEntryRepo.insert(new EntryModel(R.drawable.cat, "cat"));
            mEntryRepo.insert(new EntryModel(R.drawable.dog, "dog"));
            mEntryRepo.insert(new EntryModel(R.drawable.horse, "horse"));
        }
    }

    public LiveData<List<EntryModel>> getEntries() {
        return mEntries;
    }

    public Entries getEntriesClass() {
        List<EntryModel> entries = mEntries.getValue();

        return new Entries(entries);


    }

    private void insert(EntryModel entry) {
        mEntryRepo.insert(entry);
    }

    private void removeEntry(EntryModel entry) {
        mEntryRepo.delete(entry);
    }
}
