package com.mondaysSongTask.songsApp.controller;

import com.mondaysSongTask.songsApp.controller.dto.SongNewDto;
import com.mondaysSongTask.songsApp.controller.dto.SongDto;
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
        return songService.getSongs();
    }

    @PostMapping("/songs")
    public SongDto addSong(@RequestBody SongNewDto songNewDto) {
        try {
            return songService.addSong(songNewDto);
        }
        catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "", ex);
        }
    }

    @PutMapping("/songs/{songId}/vote")
    public SongDto increaseSongVotes(@PathVariable Long songId) {
        try {
            return songService.increaseSongVotes(songId);
        }
        catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Song Id not found in DB", ex);
        }
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
