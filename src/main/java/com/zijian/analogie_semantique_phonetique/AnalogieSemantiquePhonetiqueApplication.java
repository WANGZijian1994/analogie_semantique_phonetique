package com.zijian.analogie_semantique_phonetique;

import com.zijian.analogie_semantique_phonetique.controller.ZijianController;
import com.zijian.analogie_semantique_phonetique.entity.Zijian;
import com.zijian.analogie_semantique_phonetique.repository.ZijianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class AnalogieSemantiquePhonetiqueApplication {

    public static void main(String[] args){
        SpringApplication.run(AnalogieSemantiquePhonetiqueApplication.class, args);
    }



}
