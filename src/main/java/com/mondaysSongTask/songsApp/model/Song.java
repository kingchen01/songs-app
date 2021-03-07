package com.mondaysSongTask.songsApp.model;

import com.mondaysSongTask.songsApp.model.util.SongCategoryEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String album;
    private SongCategoryEnum category;
    private Long votes;

}
