package com.st.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
