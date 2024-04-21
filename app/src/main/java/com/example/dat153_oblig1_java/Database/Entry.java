package com.example.dat153_oblig1_java.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    public int getImgRef() {
        return imgRef;
    }

    public String getAnswer() {
        return answer;
    }

    public int compareTo(Entry e) {
        return this.answer.compareTo(e.answer);
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public void setImgRef(int imgRef) {
        this.imgRef = imgRef;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
