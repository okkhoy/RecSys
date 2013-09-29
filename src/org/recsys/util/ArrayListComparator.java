package org.recsys.util;

import java.util.Comparator;
import java.util.Map;

public class ArrayListComparator implements Comparator<Map<Integer, Double>> {

	@Override
	public int compare(Map<Integer, Double> o1, Map<Integer, Double> o2) {
		
		int movie1Id = (Integer) o1.keySet().iterator().next();
		int movie2Id = (Integer) o2.keySet().iterator().next();
		
		return o2.get(movie2Id).compareTo(o1.get(movie1Id));
	}

}
