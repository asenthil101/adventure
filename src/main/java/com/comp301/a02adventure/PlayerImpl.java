package com.comp301.a02adventure;

public class PlayerImpl implements Player {
  private String name;
  private Position position;
  private Inventory inventory = new InventoryImpl();

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.position = new PositionImpl(startX, startY);
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public Inventory getInventory() {
    return this.inventory;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void move(Direction direction) {
    Position neighbor = position.getNeighbor(direction);
    position = neighbor;
  }
}
