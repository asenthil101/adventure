package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private List<Item> itemList;

  public InventoryImpl() {
    this.itemList = new ArrayList<Item>();
  }

  @Override
  public boolean isEmpty() {
    if (this.itemList.isEmpty()) {
      return true;
    }
    return false;
  }

  @Override
  public int getNumItems() {
    return this.itemList.size();
  }

  @Override
  public List<Item> getItems() {
    List<Item> clonedItemList = new ArrayList<Item>();
    clonedItemList.addAll(this.itemList);
    return clonedItemList;
  }

  @Override
  public void addItem(Item item) {
    itemList.add(item);
  }

  @Override
  public void removeItem(Item item) {
    itemList.remove(item);
  }

  @Override
  public void clear() {
    itemList.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    if (other == null) {
      throw new NullPointerException();
    }
    List<Item> transfer = other.getItems();
    for (int i = 0; i < other.getNumItems(); i++) {
      Item getter = transfer.get(i);
      this.itemList.add(getter);
    }
    other.clear();
  }
}
