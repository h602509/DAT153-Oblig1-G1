package com.example.dat153_oblig1_java.quiz_entries;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EntryModel implements Comparable<EntryModel> {

    @PrimaryKey (autoGenerate = true)
    private int entryId;
    @ColumnInfo (name = "image")
    private Integer imgRef;
    @ColumnInfo (name = "answer")
    private String answer;

    public EntryModel(Integer imgRef, String answer) {
        this.imgRef = imgRef;
        this.answer = answer;
    }

    public int getEntryId() { return entryId; }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public Integer getImgRef() {
        return imgRef;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public int compareTo(EntryModel e) {
        return this.getAnswer().compareTo(e.getAnswer());
    }
}
