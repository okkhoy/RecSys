package org.recsys.util;

import java.util.Comparator;
import java.util.Map;

/**
 * This comparator is used to compare two elements of an ArrayList, where
 * each element is a HashMap.
 * @author akshay
 */

public class ArrayListComparator implements Comparator<Map<Integer, Double>> {
	
	@Override
	/**
	 * @param o1, o2
	 * 	Two objects (HashMap elements) in the ArrayList being compared.
	 * @return TRUE if o2.value > o1.value
	 */
	public int compare(Map<Integer, Double> o1, Map<Integer, Double> o2) {
		
		int val1 = (Integer) o1.keySet().iterator().next();
		int val2 = (Integer) o2.keySet().iterator().next();
		
		return o2.get(val2).compareTo(o1.get(val1));
	}

}
