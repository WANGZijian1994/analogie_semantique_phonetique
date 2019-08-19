package com.zijian.analogie_semantique_phonetique.repository;

import com.zijian.analogie_semantique_phonetique.entity.Verbe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerbeRepository extends JpaRepository<Verbe,Integer>{
}
