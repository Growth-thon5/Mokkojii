package com.example.mokkoji.domain.tag.repository;

import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.tag.entity.StoreTag;
import com.example.mokkoji.domain.tag.entity.TagType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreTagRepository extends JpaRepository<StoreTag, Long> {

    Optional<StoreTag> findByStoreAndTagType(Store store, TagType tagType);

    @Query("""
                SELECT st.store 
                FROM StoreTag st 
                WHERE st.tagType = :tagType 
                GROUP BY st.store 
                ORDER BY COUNT(st) DESC
            """)
    List<Store> findByTagCount(@Param("tagType") TagType tag);


}
