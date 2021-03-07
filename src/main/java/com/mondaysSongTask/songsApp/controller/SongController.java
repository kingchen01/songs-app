package com.mondaysSongTask.songsApp.controller;

import com.mondaysSongTask.songsApp.controller.dto.SongDto;
import com.mondaysSongTask.songsApp.controller.util.SongDtoMapper;
import com.mondaysSongTask.songsApp.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/songs")
    public List<SongDto> getSongs() {
        return SongDtoMapper.mapToSongDtos(songService.getSongs());
    }



}
