package com.wander.model;

import static java.util.Objects.isNull;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


/**
 * Copyright 2018 Jubilant FoodWorks Limited . All Rights Reserved.
 * Jubilant FoodWorks PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
@Entity
public class Note {

    public Note() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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

    public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
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
    
    @PrePersist
    protected void onCreate() {
        createdTime = new Date();
        updatedTime = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	updatedTime = new Date();
    }
}