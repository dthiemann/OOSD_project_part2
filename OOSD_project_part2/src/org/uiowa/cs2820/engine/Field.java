package org.uiowa.cs2820.engine;

/*
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
*/

import java.io.Serializable;

public class Field implements Serializable {

	public static final int MAXSIZE = 256;
	private String FieldName; 
	private Object FieldValue;
	
	// constructor for Fields with String
	Field(String FieldName, Object Value) throws IllegalArgumentException {
	  this.FieldName = FieldName;
	  this.FieldValue = Value;
	  if (toBytes().length >= Field.MAXSIZE)
	     throw new IllegalArgumentException("Field Size exceeded: " + FieldName);
	  return;
	  }
	public String getFieldName() {
	  return FieldName;
	  }
	public Object getFieldValue() {
	  return FieldValue;
	  }
	public byte[] toBytes() {
	  byte[] wholeField = Utility.convert(this);
	  return wholeField;
	  //byte[] ByteFieldName = FieldName.getBytes();
	  //byte[] R = new byte[ByteFieldName.length + FieldValue.length];
	  //System.arraycopy(ByteFieldName,0,R,0,ByteFieldName.length);
	  //System.arraycopy(FieldValue,0,R,ByteFieldName.length,FieldValue.length);
	  //return R;
	  }
	}
