package com.mondaysSongTask.songsApp.controller.dto;

import com.mondaysSongTask.songsApp.model.util.SongCategoryEnum;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Id;

@Getter
@Builder
public class SongDto {

    @Id
    private Long id;
    private String title;
    private String author;
    private String album;
    private SongCategoryEnum category;
    private Long votes;
}
