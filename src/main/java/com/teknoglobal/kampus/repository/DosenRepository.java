package com.teknoglobal.kampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknoglobal.kampus.model.Dosen;

@Repository
public interface DosenRepository extends JpaRepository<Dosen, Long>{
    
}