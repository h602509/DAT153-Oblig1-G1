package com.example.dat153_oblig1_java.DAO;

import com.example.dat153_oblig1_java.quiz_entries.EntryModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface EntryDao {

    @Insert
    void insert(EntryModel entryModel);

    @Delete
    void delete(EntryModel entryModel);

    //@Query("SELECT * FROM EntryModel ORDER BY ANSWER")
    LiveData<List<EntryModel>> loadAllEntryModels();

}
