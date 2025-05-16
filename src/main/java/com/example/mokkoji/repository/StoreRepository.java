package com.example.mokkoji.repository;


import com.example.mokkoji.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}