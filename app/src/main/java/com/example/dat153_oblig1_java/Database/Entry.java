package com.example.dat153_oblig1_java.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Entry {
    @PrimaryKey(autoGenerate = true)
    private int entryId;

    @ColumnInfo(name = "img_ref")
    private int imgRef;


    @ColumnInfo
    private String answer;

    public Entry() {}

    public Entry(int imgRef, String answer) {
        this.imgRef = imgRef;
        this.answer = answer;
    }

    public int getImage() {
        return imgRef;
    }

    public String getAnswer() {
        return answer;
    }
}
