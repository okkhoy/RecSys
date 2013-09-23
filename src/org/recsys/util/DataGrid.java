package org.recsys.util;

import java.util.HashMap;

/*
 * This code is primarily from GridTable code in 
 * http://carlstrom.com/bdc-scheme/
 * I have made modifications to suit the needs of RecSys 
 * course assignment data format.
 * 
 * This is an attempt to make the beautiful implementation 
 * of GridTable stupid, and I think I succeeded. 
 * 
 * It works only with String data. I can probably use this
 * as basis for other work involving data grids. * 
 */

public class DataGrid {
	private HashMap primaryTable = new HashMap();
	
	public void putData(String userID, String movieID, String rating) {
		HashMap secondaryTable = (HashMap)primaryTable.get(userID);
		
		if (secondaryTable == null) {
			secondaryTable = new HashMap();
			primaryTable.put(userID, secondaryTable);
		}
		secondaryTable.put(movieID, rating);		
	}
	
	public String getData(String key1, String key2) {
		HashMap secondaryTable = (HashMap) primaryTable.get(key1);
		
		if(secondaryTable == null) {
			return null;
		}
		return (String) secondaryTable.get(key2);
	}
	
	public String removeEntry(String key1, String key2) {
		
		HashMap secondaryTable = (HashMap) primaryTable.get(key1);
		
		if(secondaryTable == null) {
			return null;
		} else {
			return (String) secondaryTable.remove(key2);
		}		
	}
	
	public String removeEntry(String key1) {
		return (String) primaryTable.remove(key1);
	}
	
	public void clear() {
		primaryTable.clear();
	}
	
	
}
