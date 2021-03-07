package com.mondaysSongTask.songsApp.repository;

import com.mondaysSongTask.songsApp.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
