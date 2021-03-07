package com.mondaysSongTask.songsApp.controller.dto;

import com.mondaysSongTask.songsApp.model.util.SongCategoryEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SongNewDto {

    private String title;
    private String author;
    private String album;
    private SongCategoryEnum category;
}
