package com.mondaysSongTask.songsApp.controller;

import com.mondaysSongTask.songsApp.controller.dto.SongNewDto;
import com.mondaysSongTask.songsApp.controller.dto.SongDto;
import com.mondaysSongTask.songsApp.controller.util.SongDtoMapper;
import com.mondaysSongTask.songsApp.controller.util.SongNewDtoMapper;
import com.mondaysSongTask.songsApp.model.Song;
import com.mondaysSongTask.songsApp.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/songs")
    public List<SongDto> getSongs() {
        return SongDtoMapper.mapToDtos(songService.getSongs());
    }

    @PostMapping("/songs")
    public SongDto addSong(@RequestBody SongNewDto songNewDto) {
        Song song = SongNewDtoMapper.mapToEntity(songNewDto);
        Song songCreated = songService.addSong(song);
        return SongDtoMapper.mapToDto(songCreated);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable Long songId) {
        try {
            songService.deleteSong(songId);
        }
        catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Song Id not found in DB", ex);
        }
    }

}
