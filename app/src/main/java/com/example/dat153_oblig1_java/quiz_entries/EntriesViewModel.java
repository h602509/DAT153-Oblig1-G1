package com.example.dat153_oblig1_java.quiz_entries;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dat153_oblig1_java.R;

import java.util.ArrayList;
import java.util.List;

public class EntriesViewModel extends AndroidViewModel {

    private MutableLiveData<List<EntryModel>> liveEntries;

    public EntriesViewModel(@NonNull Application application) {
        super(application);
    }

    MutableLiveData<List<EntryModel>> getEntries() {
        if (liveEntries == null) {
            liveEntries = new MutableLiveData<>();
            initEntries();
        }
        return liveEntries;
    }

    private void initEntries() {
        List<EntryModel> entries = new ArrayList<>();
        entries.add(new EntryModel(R.drawable.cat, "cat"));
        entries.add(new EntryModel(R.drawable.dog, "dog"));
        entries.add(new EntryModel(R.drawable.horse, "horse"));
        liveEntries.setValue(entries);
    }

    private void addEntry(EntryModel entry) {
        List<EntryModel> entries = liveEntries.getValue();
        entries.add(entry);
        liveEntries.setValue(entries);
    }

    private void removeEntry(EntryModel entry) {
        List<EntryModel> entries = liveEntries.getValue();
        entries.remove(entry);
        liveEntries.setValue(entries);
    }
}
