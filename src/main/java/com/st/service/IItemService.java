package com.st.service;

import java.util.List;

import com.st.model.Item;

public interface IItemService {

	public Integer itemSave(Item item);
	public List<Item> getAllItem();
	public void deleteItem(Integer id);
	public Item getOneItem(Integer id);
	public Integer updateItem(Item  item); 

}
