package com.comp301.a02adventure;

public class MapImpl implements Map {
  private int width;
  private int height;
  private final int numItems;
  private Cell[][] array;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0) {
      throw new IllegalArgumentException();
    }
    if (height <= 0) {
      throw new IllegalArgumentException();
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;
    this.array = new Cell[width][height];
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x > width || x < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (y > height || y < 0) {
      throw new IndexOutOfBoundsException();
    }
    return this.array[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    if (position.getX() > width || position.getX() < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (position.getY() > height || position.getY() < 0) {
      throw new IndexOutOfBoundsException();
    }
    return this.array[position.getX()][position.getY()];
  }

  @Override
  public void initCell(int x, int y) {
    if (x > width || x < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (y > height || y < 0) {
      throw new IndexOutOfBoundsException();
    }
    this.array[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
