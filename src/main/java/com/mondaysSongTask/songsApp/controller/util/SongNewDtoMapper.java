package com.mondaysSongTask.songsApp.controller.util;

import com.mondaysSongTask.songsApp.controller.dto.SongNewDto;
import com.mondaysSongTask.songsApp.model.Song;

public class SongNewDtoMapper {

    private SongNewDtoMapper() {

    }

    public static Song mapToEntity(SongNewDto songNewDto) {
        Song song = new Song();
        song.setTitle(songNewDto.getTitle());
        song.setAlbum(songNewDto.getAlbum());
        song.setAuthor(songNewDto.getAuthor());
        song.setCategory(songNewDto.getCategory());
        song.setVotes(0L);
        return song;
    }

}
