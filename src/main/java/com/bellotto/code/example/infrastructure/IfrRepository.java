package com.bellotto.code.example.infrastructure;

import com.bellotto.code.example.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IfrRepository extends JpaRepository<Item, Long> {

}
