package com.zijian.analogie_semantique_phonetique.service;

import com.google.common.base.Splitter;
import com.zijian.analogie_semantique_phonetique.repository.ZijianRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.zijian.analogie_semantique_phonetique.entity.Zijian;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.*;

@Service
public class ZijianService {
    @Autowired
    private ZijianRepository zijianRepository;

    public List<Zijian>ouvrir(){
        List<Zijian>corpus = new ArrayList<>();
        File file = new File("/Users/zijian/Mémoire M1/données/La deuxième version/Panorama2.0.txt");

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = new String();
            Integer id = 1;
            while((line=bufferedReader.readLine())!=null){
                Iterable<String> iterable = Splitter.on("|").split(line);
                ArrayList<String>l = new ArrayList<String>();
                Zijian zijian = new Zijian();
                List<String>mots = new ArrayList<>();
                List<String>pm = new ArrayList<>();
                List<String>tp = new ArrayList<>();
                List<String>pos = new ArrayList<>();
                List<String>freq = new ArrayList<>();
                List<String>syn = new ArrayList<>();
                List<String>réseau = new ArrayList<>();
                for(String result : iterable) {
                    l.add(result);
                }
                zijian.setId(id);
                id++;
                mots.add(l.get(0));mots.add(l.get(1));
                zijian.setMots(mots.toString());
                pm.add(l.get(2));pm.add(l.get(3));
                zijian.setPaire_minimal(pm.toString());
                tp.add(l.get(4));tp.add(l.get(5));
                zijian.setTranscription_phonétique(tp.toString());
                pos.add(l.get(6));pos.add(l.get(7));
                zijian.setPos(pos.toString());
                freq.add(l.get(8));freq.add(l.get(9));
                zijian.setFréquence(freq.toString());
                syn.add(l.get(10));syn.add(l.get(11));
                zijian.setSyn(syn.toString());
                réseau.add(l.get(12));réseau.add(l.get(13));
                zijian.setRéseau_sémantique(réseau.toString());
                corpus.add(zijian);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        zijianRepository.saveAll(corpus);
        return corpus;
    }

    //trier par le mot avec ambiguïté

    //trier par le POS

    //trier par la fréquence

    //trier par la paire minimale fixée.
    public static void main(String[] args){
        ZijianService zijianService = new ZijianService();
        List<Zijian>l = zijianService.ouvrir();
        System.out.println(l.size());
        System.out.println(l.get(0).toString());
        System.out.println(l.get(10).toString());
    }
}
