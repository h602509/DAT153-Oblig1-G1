package com.example.dat153_oblig1_java.interfaces;

import com.example.dat153_oblig1_java.quiz_entries.EntryModel;

import java.util.List;

public interface EntriesRepo {


    void deleteEntryModel(EntryModel entryModel);

    List<EntryModel> loadAllEntryModels();

    void addEntryModel(int imgRef, String answer);
}
