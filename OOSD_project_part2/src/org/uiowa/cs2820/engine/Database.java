package org.uiowa.cs2820.engine;

public interface Database {
  public Node fetch(byte[] key);  // fetch a Node by key
  public void delete(byte[] key, String id);  // delete an id
  public void store(byte[] key, String id); // store an id
  }
