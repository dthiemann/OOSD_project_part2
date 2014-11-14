package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class Node {
	
	/* made iVars protected for testing equality */
	
  // Node is a basic unit in the database
  protected byte[] Key;  // Key of this node for lookup
  protected ArrayList<String> Identifiers;
  int size;    // not yet implemented
  
  Node(byte[] f, String id) {
	this.Key = f;
	this.Identifiers = new ArrayList<String>();
	this.Identifiers.add(id);
    }
  
  public void add(String id) { 
	Identifiers.remove(id);  // does nothing if id not already there
	Identifiers.add(id);
    }
  
  public void del(String id) {
	Identifiers.remove(id);
    }
  
  public int getSize() {
	return size;
    }
  
  
  /* Create an equals method to test for equality */
  public boolean equals(Node other) {

	  if (this.Key != other.Key) {
		  return false;
	  } 
	  
	  other.Identifiers.sort(null);
	  this.Identifiers.sort(null);
	  
	  for (int i = 0; i < this.Identifiers.size(); i++) {
		  if (!this.Identifiers.get(i).equals(other.Identifiers.get(i))) {
			  return false;
		  }
	  }
	  return true;
  	}
  }
