package com.mondaysSongTask.songsApp.model;

import com.mondaysSongTask.songsApp.model.util.SongCategoryEnum;
import lombok.*;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private SongCategoryEnum category;
    private Long votes;

}
