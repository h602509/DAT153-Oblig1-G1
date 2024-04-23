package com.example.dat153_oblig1_java.Database;

import android.net.Uri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Entry {
    @PrimaryKey(autoGenerate = true)
    private int entryId;

    @ColumnInfo(name = "img_ref")
    private String imgRef;


    @ColumnInfo
    private String answer;

    public Entry() {}

    public Entry(Uri imgRef, String answer) {
        this.imgRef = imgRef.toString();
        this.answer = answer;
    }

    public String getImgRef() {
        return imgRef;
    }

    public Uri getImgUri() {
        return Uri.parse(imgRef);
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

    public void setImgRef(String imgRef) {
        this.imgRef = imgRef;
    }

    public void setImgUri(Uri imgUri) {
        this.imgRef = imgUri.toString();
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
