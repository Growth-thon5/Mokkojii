package com.example.mokkoji.domain.store.repository;

import com.example.mokkoji.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

//    List<Store> findAll(double lat, double lng);

    @Query("SELECT s FROM Store s WHERE s.location.addressDong LIKE %:동%")
    List<Store> findByAddressDong(@Param("동") String 동);

    @Query("SELECT s FROM Store s WHERE s.name LIKE %:keyword%")
    List<Store> findByStoreName(String keyword);

    @Query("SELECT s FROM Store s ORDER BY s.cheerCount DESC")
    List<Store> findByCheerCount();

    @Query("SELECT s FROM Store s ORDER BY s.openingDate DESC")
    List<Store> findByCreatedAt();
}
