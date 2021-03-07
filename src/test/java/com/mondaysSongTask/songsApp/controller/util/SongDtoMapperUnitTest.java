package com.mondaysSongTask.songsApp.controller.util;


import com.mondaysSongTask.songsApp.controller.dto.SongDto;
import com.mondaysSongTask.songsApp.model.Song;
import com.mondaysSongTask.songsApp.model.util.SongCategoryEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SongDtoMapperUnitTest {

    private final SongDtoMapper songDtoMapper = new SongDtoMapper();
    private Song song1, song2;

    @BeforeEach
    public void initEach(){
        song1 = new Song();
        song1.setId(1L);
        song1.setTitle("Light My Fire");
        song1.setAlbum("The Doors");
        song1.setAuthor("The Doors");
        song1.setCategory(SongCategoryEnum.ROCK);
        song1.setVotes(255L);

        song2 = new Song();
        song2.setId(2L);
        song2.setTitle("Lost");
        song2.setAlbum("channel ORANGE 123");
        song2.setAuthor("Frank Ocean");
        song2.setCategory(SongCategoryEnum.POP);
        song2.setVotes(10L);
    }

    @Test
    public void whenConvertSongEntityToSongDto_thenCorrect() {
        SongDto songDto = songDtoMapper.mapToDto(song1);

        assertEquals(song1.getId(), songDto.getId());
        assertEquals(song1.getTitle(), songDto.getTitle());
        assertEquals(song1.getAlbum(), songDto.getAlbum());
        assertEquals(song1.getAuthor(), songDto.getAuthor());
        assertEquals(song1.getCategory(), songDto.getCategory());
        assertEquals(song1.getVotes(), songDto.getVotes());
    }

    @Test
    public void whenConvertingListOfSongEntitiesToListOfSongDtos_thenCorrect() {
        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);

        List<SongDto> songDtos = songDtoMapper.mapToDtos(songs);

        assertAll("dtos",
                () -> assertEquals(songDtos.get(0).getTitle(), song1.getTitle()),
                () -> assertEquals(songDtos.get(1).getTitle(), song2.getTitle()),
                () -> assertEquals(songDtos.get(0).getAlbum(), song1.getAlbum()),
                () -> assertEquals(songDtos.get(1).getAlbum(), song2.getAlbum()),
                () -> assertEquals(songDtos.get(0).getAuthor(), song1.getAuthor()),
                () -> assertEquals(songDtos.get(1).getAuthor(), song2.getAuthor()),
                () -> assertEquals(songDtos.get(0).getCategory(), song1.getCategory()),
                () -> assertEquals(songDtos.get(1).getCategory(), song2.getCategory()),
                () -> assertEquals(songDtos.get(0).getVotes(), song1.getVotes()),
                () -> assertEquals(songDtos.get(1).getVotes(), song2.getVotes())
        );
    }
}
