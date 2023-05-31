package ru.music.musicshuffle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.music.musicshuffle.models.Track;
import java.util.List;

public interface TracklistRep extends JpaRepository<Track,Long> {

}
