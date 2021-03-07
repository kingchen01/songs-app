package com.mondaysSongTask.songsApp.service;

import com.mondaysSongTask.songsApp.controller.dto.SongDto;
import com.mondaysSongTask.songsApp.controller.dto.SongNewDto;
import com.mondaysSongTask.songsApp.controller.util.SongDtoMapper;
import com.mondaysSongTask.songsApp.controller.util.SongNewDtoMapper;
import com.mondaysSongTask.songsApp.controller.util.SongValidator;
import com.mondaysSongTask.songsApp.model.Song;
import com.mondaysSongTask.songsApp.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public SongDto addSong(SongNewDto songNewDto) {
        SongValidator.validateSong(songNewDto);
        Song song = SongNewDtoMapper.mapToEntity(songNewDto);
        Song songCreated = songRepository.save(song);
        return SongDtoMapper.mapToDto(songCreated);
    }

    @Transactional
    public void deleteSong(Long songId)   {
        songRepository.findById(songId).ifPresentOrElse(song -> songRepository.deleteById(song.getId()),
                () -> { throw new IllegalArgumentException(); });
    }

    @Transactional
    public SongDto increaseSongVotes(Long songId) {
        Song songEdited = songRepository.findById(songId).orElseThrow(IllegalArgumentException::new);
        songEdited.setVotes(songEdited.getVotes() + 1);
        return SongDtoMapper.mapToDto(songEdited);
    }
}
