package com.example.dat153_oblig1_java.quiz_entries;

import android.app.Application;

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
        mEntryRepo = new EntryRepo(application);
        mEntries = mEntryRepo.getEntries();
    }

    LiveData<List<EntryModel>> getEntries() {
        return mEntries;
    }

    private void insert(EntryModel entry) {
        mEntryRepo.insert(entry);
    }

    private void removeEntry(EntryModel entry) {
        mEntryRepo.delete(entry);
    }
}
