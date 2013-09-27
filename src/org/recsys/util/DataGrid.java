package org.recsys.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * This code is primarily from GridTable code in 
 * http://carlstrom.com/bdc-scheme/
 * I have made modifications to suit the needs of RecSys 
 * course assignment data format.
 * 
 * This is an attempt to make the beautiful implementation 
 * of GridTable stupid, and I think I succeeded. 
 * 
 * It works only with int data. I can probably use this
 * as basis for other work involving data grids. * 
 */

public class DataGrid {
	
	private HashMap primaryTable = new HashMap();
	
	public HashMap getSecondaryTable(int id) {
		return (HashMap) primaryTable.get(id);
	}
	
	public void putData(int userID, int movieID, double rating) {
		HashMap secondaryTable = (HashMap)primaryTable.get(userID);
		
		if (secondaryTable == null) {
			secondaryTable = new HashMap();
			primaryTable.put(userID, secondaryTable);
		}
		secondaryTable.put(movieID, rating);		
	}
	
	public double getData(int key1, int key2) {
		HashMap secondaryTable = (HashMap) primaryTable.get(key1);
		
		if(secondaryTable == null) {
			return -1;
		}
		return (Double) secondaryTable.get(key2);
	}
	
	public int removeEntry(int key1, int key2) {
		
		HashMap secondaryTable = (HashMap) primaryTable.get(key1);
		
		if(secondaryTable == null) {
			return -1;
		} else {
			return (Integer) secondaryTable.remove(key2);
		}		
	}
	
	public int removeEntry(int key1) {
		return (Integer) primaryTable.remove(key1);
	}
	
	public void clear() {
		primaryTable.clear();
	}
	
	@SuppressWarnings("rawtypes")
	public Iterator primaryKeys() {
		return this.primaryTable.keySet().iterator();
	}
	
	public Iterator secondaryKeys(int key1) {
		HashMap secondaryTable = (HashMap) primaryTable.get(key1);
		
		if(secondaryTable == null) {
			return Collections.EMPTY_SET.iterator();
		}
		
		return secondaryTable.keySet().iterator();
	}
	
	public Set getSecondaryKeys(int key1) {
		HashMap secondaryTable = (HashMap) primaryTable.get(key1);
		
		if(secondaryTable == null) {
			return Collections.EMPTY_SET;
		}
		return secondaryTable.keySet();
	}
	
	public DataGrid transposeKeys() {
		DataGrid table = new DataGrid();
		Iterator pi = this.primaryKeys();
		
		while (pi.hasNext()) {
			int key =  (Integer) pi.next();
			Iterator si = this.secondaryKeys(key);
			
			while (si.hasNext()) {
				int key2 = (Integer) si.next();
				double rating = this.getData(key, key2);
				table.putData(key2, key, rating);
			}
		}
		return table;
	}
	
	public void printGrid() {
		Iterator pi = this.primaryKeys();
		
		while(pi.hasNext()) {
			int key1 = (Integer) pi.next();
			Iterator si = this.secondaryKeys(key1);
			
			while (si.hasNext()) {
				int key2 = (Integer) si.next();
				System.out.println("User: " + key1 + " Movie: " + key2 + " Rating: " + this.getData(key1, key2));
			}
		}
	}
}
