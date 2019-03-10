package com.firstpixel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item1 = new Item("Richard", 3);
		Item item2 = new Item("Andrew", 2);
		Item item3 = new Item("Margareth", 1);
		
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		
		List<Item> sortedItemList = itemList.stream().sorted(( o1, o2)->((Item) o1).getName().
                compareTo(((Item) o2).getName())).collect(Collectors.toList());
		
		List<Item> sortedItemList2 = itemList.stream().sorted(( o1, o2)->((Item) o1).getId().
                compareTo(((Item) o2).getId())).collect(Collectors.toList());
		
		System.out.println(sortedItemList);
		System.out.println(sortedItemList2);
		System.out.println(itemList);
	}
}

class Item {
	private String name;
	private Integer id;
	Item(String _name, Integer _id){
		this.name = _name;
		this.id = _id;
	}

	public String toString() {
		return this.name + "" + this.id.toString();
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}