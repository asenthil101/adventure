package com.comp301.a02adventure;

import java.nio.channels.FileLockInterruptionException;

public final class ItemImpl implements Item {
  private String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    Item other_cast = (Item) other;
    if (other_cast == null) {
      return false;
    }
    if (this.name == other_cast.getName()) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return name.toString();
  }
}
