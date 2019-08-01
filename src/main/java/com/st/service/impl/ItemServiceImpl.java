package com.st.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.model.Item;
import com.st.repo.ItemRepository;
import com.st.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private ItemRepository repo;
	
	@Override
	@Transactional
	public Integer itemSave(Item item) {
		Item it=repo.save(item);
		
		return it.getItemId();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Item> getAllItem() {
		List<Item> list=repo.findAll();
		list.stream().sorted((i1,i2)->i1.getItemName().compareTo(i2.getItemName()));
		if(list!=null && !list.isEmpty()) {
		return list;
	}
	return null;	
	}

	@Override
	@Transactional
	public void deleteItem(Integer id) {
		try {
			repo.deleteById(id);
		}
		catch(Exception e) {
			throw new RuntimeException(e.toString()+"No Data Found/ Id not Found");
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Item getOneItem(Integer id) {
		Optional<Item> opt=repo.findById(id);
		if(opt.isPresent()) {
			
			return opt.get();
		}
	return null;

	}

	@Override
	@Transactional
	public Integer updateItem(Item item) {
		Integer id;
		if(repo.existsById(item.getItemId())) {
		 id=repo.save(item).getItemId();
		 return id;
		}
		else
		throw new RuntimeException("This Employee details Not Found");
	}

	}

