package com.example.dat153_oblig1_java.interfaces;

import androidx.lifecycle.LiveData;

import com.example.dat153_oblig1_java.Database.Entry;

import java.util.List;

public interface EntriesRepo {


    void deleteEntry(Entry entry);

    LiveData<List<Entry>> loadAllEntriesAsc();

    LiveData<List<Entry>> loadAllEntriesDsc();


    void addEntry(Entry entry);
}
