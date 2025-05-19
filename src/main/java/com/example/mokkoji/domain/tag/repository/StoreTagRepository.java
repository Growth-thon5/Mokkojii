package com.example.mokkoji.domain.tag.repository;

import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.tag.entity.StoreTag;
import com.example.mokkoji.domain.tag.entity.TagType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreTagRepository extends JpaRepository<StoreTag, Long> {

    Optional<StoreTag> findByStoreAndTagType(Store store, TagType tagType);
}
