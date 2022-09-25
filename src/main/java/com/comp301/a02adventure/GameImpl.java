package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private Map map;
  private Player player;

  public GameImpl(Map map, Player player) {
    if (map == null) {
      throw new IllegalArgumentException();
    }
    if (player == null) {
      throw new IllegalArgumentException();
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return this.player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return this.player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return this.player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    if (this.player.getInventory().getNumItems() == this.map.getNumItems()) {
      return true;
    }
    return false;
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + this.map.getCell(this.getPlayerPosition()).getName());
    System.out.println(this.map.getCell(this.getPlayerPosition()).getDescription());
    if (this.map.getCell(this.getPlayerPosition()).getIsVisited() == true) {
      System.out.println("You have already visited this location.");
    }
    if (this.map.getCell(this.getPlayerPosition()).hasChest() == true) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    this.map.getCell(this.getPlayerPosition()).visit();
  }

  @Override
  public void openChest() {
    if (this.map.getCell(this.getPlayerPosition()).hasChest() == false) {
      System.out.println("No chest to open, sorry!");
    }
    if (this.map.getCell(this.getPlayerPosition()).hasChest() == true) {
      if (this.map.getCell(this.getPlayerPosition()).getChest().isEmpty() == true) {
        System.out.println("The chest is empty.");
      }
      if (this.map.getCell(this.getPlayerPosition()).getChest().isEmpty() == false) {
        System.out.println(
            "You collected these items: "
                + this.map.getCell(this.getPlayerPosition()).getChest().getItems());
        this.player.getInventory().transferFrom(this.map.getCell(getPlayerPosition()).getChest());
      }
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    if (this.getPlayerPosition().getNeighbor(direction).getX() >= 0
        && this.getPlayerPosition().getNeighbor(direction).getY() >= 0
        && this.getPlayerPosition().getNeighbor(direction).getX() < this.map.getWidth()
        && this.getPlayerPosition().getNeighbor(direction).getY() < this.map.getHeight()
        && this.map.getCell(getPlayerPosition().getNeighbor(direction)) != null) {
      return true;
    }
    return false;
  }

  @Override
  public void move(Direction direction) {
    if (canMove(direction) == false) {
      System.out.println("You can't go that way! Try another direction.");
    }
    if (canMove(direction) == true) {
      this.player.move(direction);
      this.printCellInfo();
    }
  }
}
