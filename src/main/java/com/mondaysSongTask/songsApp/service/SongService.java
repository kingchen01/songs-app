package com.mondaysSongTask.songsApp.service;

import com.mondaysSongTask.songsApp.model.Song;
import com.mondaysSongTask.songsApp.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public List<Song> getSongs() {
        return songRepository.findAll();
    }
}
