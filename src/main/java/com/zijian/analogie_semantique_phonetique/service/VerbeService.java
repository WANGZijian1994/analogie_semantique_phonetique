package com.zijian.analogie_semantique_phonetique.service;

import com.google.common.base.Splitter;
import com.zijian.analogie_semantique_phonetique.entity.Verbe;
import com.zijian.analogie_semantique_phonetique.entity.Zijian;
import com.zijian.analogie_semantique_phonetique.repository.VerbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VerbeService {
    @Autowired
    private VerbeRepository verbeRepository;

    public List<Verbe> ouvrir(){
        List<Verbe>corpus = new ArrayList<>();
        File file = new File("/Users/zijian/Mémoire M1/données/La deuxième version/Verbes_ConjuguésJPA.txt");

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = new String();
            Integer id = 1;
            while((line=bufferedReader.readLine())!=null){
                Iterable<String> iterable = Splitter.on("|").split(line);
                ArrayList<String>l = new ArrayList<String>();
                Verbe verbe = new Verbe();
                List<String>mots = new ArrayList<>();
                List<String>pm = new ArrayList<>();
                List<String>tp = new ArrayList<>();
                List<String>pos = new ArrayList<>();
                List<String>lemme = new ArrayList<>();
                for(String result : iterable){
                    l.add(result);
                }
                verbe.setId(id);
                id++;
                mots.add(l.get(0));mots.add(l.get(1));
                verbe.setMots(mots.toString());
                tp.add(l.get(2));tp.add(l.get(3));
                verbe.setTranscription_phonétique(tp.toString());
                pos.add(l.get(4));pos.add(l.get(5));
                verbe.setPos(pos.toString());
                pm.add(l.get(6));pm.add(l.get(7));
                verbe.setPaire_minimale(pm.toString());
                lemme.add(l.get(8));lemme.add(l.get(9));
                verbe.setLemme(lemme.toString());
                corpus.add(verbe);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        verbeRepository.saveAll(corpus);
        return corpus;
    }
}

//trier par le mot avec ambiguïté