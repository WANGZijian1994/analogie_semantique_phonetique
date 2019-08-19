package com.zijian.analogie_semantique_phonetique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zijian.analogie_semantique_phonetique.entity.Zijian;

@Repository
public interface ZijianRepository extends JpaRepository<Zijian,Long>{
}
