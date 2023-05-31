package ru.music.musicshuffle.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Аннотация JPA ( Java Persistence Application)
@Entity
//@Table(name = "tracks")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String trackName;
    @ManyToOne
    private Author author;
    @Column
    private Integer duration;
    @Column
    private String genre;
}