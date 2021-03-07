package com.mondaysSongTask.songsApp.controller.util;

import com.mondaysSongTask.songsApp.controller.dto.SongNewDto;
import com.mondaysSongTask.songsApp.model.util.SongCategoryEnum;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SongValidator {

    public static void validateSong(SongNewDto songNewDto) {
        if (!(validateString(songNewDto.getAuthor()) && validateString(songNewDto.getAlbum()) && validateString(songNewDto.getTitle()) && validateCategory(songNewDto))) {
            throw new IllegalArgumentException("Input fields are not valid!");
        }

    }

    private static boolean validateString(String string) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");
        return !(pattern.matcher(string).find());
    }

    private static boolean validateCategory(SongNewDto songNewDto) {
        return Stream.of(SongCategoryEnum.values())
                .anyMatch(c -> c.equals(songNewDto.getCategory()));
        }
}
