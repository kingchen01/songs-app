package com.mondaysSongTask.songsApp.controller.util;

import com.mondaysSongTask.songsApp.controller.dto.SongDto;
import com.mondaysSongTask.songsApp.model.Song;

import java.util.List;
import java.util.stream.Collectors;

public class SongDtoMapper {

    private SongDtoMapper() {

    }

    public static List<SongDto> mapToSongDtos(List<Song> songs) {
        return songs.stream()
                .map(SongDtoMapper::mapToSongDto)
                .collect(Collectors.toList());
    }

    private static SongDto mapToSongDto(Song song) {
        return SongDto.builder()
                .id(song.getId())
                .title(song.getTitle())
                .album(song.getAlbum())
                .author(song.getAuthor())
                .category(song.getCategory())
                .votes(song.getVotes())
                .build();
    }
}
