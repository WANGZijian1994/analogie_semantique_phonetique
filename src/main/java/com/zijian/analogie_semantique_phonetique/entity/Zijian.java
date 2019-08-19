package com.zijian.analogie_semantique_phonetique.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "analogie_phonetique_semantique")
@Getter
@Setter
@ToString
public class Zijian {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "mots")
    private String mots;

    @Column(name = "paire_minimale")
    private String paire_minimal;

    @Column(name = "transcription_phonétique")
    private String transcription_phonétique;

    @Column(name = "POS")
    private String pos;

    @Column(name = "fréquence")
    private String fréquence;

    @Column(name = "synonyme")
    private String syn;

    @Column(name = "réseau_sémantique")
    private String réseau_sémantique;
}
