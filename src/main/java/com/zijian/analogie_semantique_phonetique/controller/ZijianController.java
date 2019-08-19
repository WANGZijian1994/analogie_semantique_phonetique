package com.zijian.analogie_semantique_phonetique.controller;

import com.zijian.analogie_semantique_phonetique.entity.Verbe;
import com.zijian.analogie_semantique_phonetique.entity.Zijian;
import com.zijian.analogie_semantique_phonetique.repository.VerbeRepository;
import com.zijian.analogie_semantique_phonetique.repository.ZijianRepository;
import com.zijian.analogie_semantique_phonetique.service.VerbeService;
import com.zijian.analogie_semantique_phonetique.service.ZijianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class ZijianController {

    @Autowired
    private ZijianService zijianService;

    @PostMapping(value="/analogie_phonetique_semantique/append")
    public List<Zijian>addAll(){
        List<Zijian> corpus = zijianService.ouvrir();
        return corpus;
    }

    @Autowired
    private ZijianRepository zijianRepository;

    @GetMapping(value = "/analogie_phonetique_semantique")
    public List<Zijian>showAll(){ return zijianRepository.findAll();
    }


    //@GetMapping(value = "/analogie_phonetique_semantique/{mots}")
    @Autowired
    private VerbeService verbeService;

    @PostMapping(value = "/verbes_conjugues/append")
    public List<Verbe>ajouterTousLesVerbes(){
        List<Verbe> conjugaison = verbeService.ouvrir();
        return conjugaison;
    }

    @Autowired
    private VerbeRepository verbeRepository;

    @GetMapping(value = "/verbes_conjugues")
    public List<Verbe>montrerAll(){
        return verbeRepository.findAll();
    }

    @RequestMapping(value = "/verbes_conjugues/{mots}")
    @ResponseBody
    public List<Verbe> trouverUnMot(@PathVariable("mots") String mots){
        String target= new String();
        List<Verbe> panorama = montrerAll();
        List<Verbe> eureka = new ArrayList<>();
        for(Verbe v:panorama){
            target = v.getMots();
            if(target.contains(mots)){
                int i = target.indexOf(mots.charAt(0))-1;
                if(target.charAt(i)=='[' || target.charAt(i)==' '){
                    eureka.add(v);}
            }
        }
        return eureka;
    }
}
