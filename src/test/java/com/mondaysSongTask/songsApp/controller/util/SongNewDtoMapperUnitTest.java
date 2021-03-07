package com.mondaysSongTask.songsApp.controller.util;

import com.mondaysSongTask.songsApp.controller.dto.SongNewDto;
import com.mondaysSongTask.songsApp.model.Song;
import com.mondaysSongTask.songsApp.model.util.SongCategoryEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongNewDtoMapperUnitTest {

    private final SongNewDtoMapper songNewDtoMapper = new SongNewDtoMapper();

    @Test
    public void whenConvertSongNewDtoToSongEntity_thenCorrect() {
        SongNewDto songNewDto = SongNewDto.builder()
                .title("Raz Dwa Trzy 3")
                .category(SongCategoryEnum.JAZZ)
                .album("Album  2")
                .author("Lady Gaga")
                .build();

        Song song = songNewDtoMapper.mapToEntity(songNewDto);

        assertEquals(songNewDto.getAlbum(), song.getAlbum());
        assertEquals(songNewDto.getTitle(), song.getTitle());
        assertEquals(songNewDto.getAuthor(), song.getAuthor());
        assertEquals(songNewDto.getCategory(), song.getCategory());
        assertEquals(song.getVotes(), 0L);
    }
}
