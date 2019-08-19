package com.zijian.analogie_semantique_phonetique.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "verbes_conjugues")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Verbe {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "mots")
    private String mots;

    @Column(name = "transcriptionphonétique")
    private String transcription_phonétique;

    @Column(name = "pos")
    private String pos;

    @Column(name = "paireminimale")
    private String paire_minimale;

    @Column(name = "lemme")
    private String lemme;
}
