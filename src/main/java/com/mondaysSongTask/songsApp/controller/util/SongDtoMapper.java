package com.mondaysSongTask.songsApp.controller.util;

import com.mondaysSongTask.songsApp.controller.dto.SongDto;
import com.mondaysSongTask.songsApp.model.Song;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class SongDtoMapper {

    public List<SongDto> mapToDtos(List<Song> songs) {
        return songs.stream()
                .map(song -> mapToDto(song))
                .collect(Collectors.toList());
    }

    public SongDto mapToDto(Song song) {
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
