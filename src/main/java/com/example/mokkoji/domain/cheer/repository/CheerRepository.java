package com.example.mokkoji.domain.cheer.repository;

import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheerRepository extends JpaRepository<Cheer, Long> {
    List<Cheer> findByStore(Store store);
    List<Cheer> findByCheerTagListContaining(TagType tagType);
    List<Cheer> findByUser(User user);

}
