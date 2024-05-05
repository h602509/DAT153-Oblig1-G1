package com.example.dat153_oblig1_java.DAO;

import com.example.dat153_oblig1_java.Database.Entry;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface EntryDao {

    @Insert
    void insert(Entry Entry);

    @Delete
    void delete(Entry Entry);

    @Query("SELECT * FROM Entry ORDER BY ANSWER DESC")
    LiveData<List<Entry>> loadAllEntriesDsc();

    @Query("SELECT * FROM Entry ORDER BY ANSWER ASC")
    LiveData<List<Entry>> loadAllEntriesAsc();

    @Query("SELECT COUNT (*) FROM Entry")
    int getSize();

    @Query("SELECT * FROM Entry WHERE ANSWER = :answer")
    Entry getEntryByName(String answer);
}
