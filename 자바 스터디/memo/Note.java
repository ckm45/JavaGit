package com.memo;

import java.time.LocalDateTime;


public class Note {
    private String title;
    private String content;
    private LocalDateTime lastUpdatedDatetime;


    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.lastUpdatedDatetime = LocalDateTime.now();
    }

  


    public String getTitle() {
        return title;
    }





    public void setTitle(String title) {
        this.title = title;
    }





    public String getContent() {
        return content;
    }





    public void setContent(String content) {
        this.content = content;
    }





    public String getLastUpdatedDatetime() {
        return lastUpdatedDatetime.toString();
    }



    void updateNote(String content) {
        this.content = content;
        this.lastUpdatedDatetime = LocalDateTime.now();
    }

    
    
    @Override
    public String toString() {
        return "Note [title=" + title + ", content=" + content + ", lastUpdatedDatetime="
                + lastUpdatedDatetime + "]";
    }

}


