package com.wander.model;

import java.util.Date;

import static java.util.Objects.isNull;


/**
 * Copyright 2018 Jubilant FoodWorks Limited . All Rights Reserved.
 * Jubilant FoodWorks PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

public class Note {

    public Note() {
    }

    private String title;
    private String description;
    private Date createdTime;
    private Date updatedTime;

    public Note(String title, String description) {
        this.description = description;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }


    public void merge(Note note) {
        if (!isNull(note.title)){
            this.title = note.title;
        }
        if (!isNull(note.description)){
            this.description = note.description;
        }
    }
}