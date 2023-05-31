package ru.music.musicshuffle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.music.musicshuffle.RandomAlgorithm;
import ru.music.musicshuffle.models.Track;
import ru.music.musicshuffle.repositories.TracklistRep;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Controller
public class MainBarController {

    Comparator <Track> trackComp = (o1, o2) -> {
        if (o1.getId() - o2.getId() > 0){
            return -10;
        }
        else{
            return 10;
        }
    };
    void RandomSort(List<Track> list, RandomAlgorithm randomAlgorithm){
        int index;
        Track track;
        int indexNumber;
        Random random = new Random();
        index = switch (randomAlgorithm){
            case CONTEMPORARY :
                yield 1;
            case SATTOLO:
                yield 0;
        };
        for(int i = list.size() - 1;  i > 0; i--){
            indexNumber = random.nextInt(i + index);
            if(indexNumber != i){
                track = list.get(i);
                list.set(i,list.get(indexNumber));
                list.set(indexNumber,track);
            }
        }
    }

    @Autowired
    public TracklistRep tracklistRep;

    @GetMapping("/")
    public String getMainBar(){
        return "isitreal";
    }
    @GetMapping("/tracks")
    public String getTracks(Model model){
        List<Track> tracklist = tracklistRep.findAll();
        RandomSort(tracklist, RandomAlgorithm.SATTOLO);
        //RandomSort(tracklist, RandomAlgorithm.CONTEMPORARY);
        model.addAttribute("tracks", tracklist);
        return "allTracks";
    }
}
