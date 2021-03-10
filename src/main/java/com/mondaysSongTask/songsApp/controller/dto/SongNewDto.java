package com.mondaysSongTask.songsApp.controller.dto;

import com.mondaysSongTask.songsApp.model.util.SongCategoryEnum;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Builder
public class SongNewDto {

    @NotBlank(message = "The title: '${validatedValue}' must not be blank, null nor empty")
    @Size(min = 1, max = 50, message = "The title: '${validatedValue}' must be between {min} and {max} characters long")
    @Pattern(regexp = "[^a-zA-Z0-9 ]")
    private String title;

    @NotBlank
    @Size(min = 1, max = 100, message = "The author property must be between {min} and {max} characters long")
    @Pattern(regexp = "[^a-zA-Z0-9 ]")
    private String author;

    @NotBlank
    @Size(min = 1, max = 50)
    @Pattern(regexp = "[^a-zA-Z0-9 ]")
    private String album;

    @NotNull
    private SongCategoryEnum category;
}
