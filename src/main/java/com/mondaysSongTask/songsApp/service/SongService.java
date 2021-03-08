package com.mondaysSongTask.songsApp.service;

import com.mondaysSongTask.songsApp.controller.dto.SongDto;
import com.mondaysSongTask.songsApp.controller.dto.SongNewDto;
import com.mondaysSongTask.songsApp.controller.util.SongDtoMapper;
import com.mondaysSongTask.songsApp.controller.util.SongNewDtoMapper;
import com.mondaysSongTask.songsApp.service.util.SongValidator;
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
    private final SongValidator songValidator;
    private final SongDtoMapper songDtoMapper;
    private final SongNewDtoMapper songNewDtoMapper;

    public List<SongDto> getSongs() {
        return songDtoMapper.mapToDtos(songRepository.findAll());
    }

    public SongDto addSong(SongNewDto songNewDto) {
        songValidator.validateString(songNewDto.getTitle());
        songValidator.validateString(songNewDto.getAlbum());
        songValidator.validateString(songNewDto.getAuthor());
        Song song = songNewDtoMapper.mapToEntity(songNewDto);
        Song songCreated = songRepository.save(song);
        return songDtoMapper.mapToDto(songCreated);
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
        return songDtoMapper.mapToDto(songEdited);
    }
}
