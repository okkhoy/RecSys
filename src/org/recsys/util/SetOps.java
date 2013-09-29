package org.recsys.util;

import java.util.HashSet;
import java.util.Set;

public class SetOps {

	public static<T> Set<T> union(Set<T> s1, Set<T> s2) {

		Set<T> unionSet = new HashSet<T>();
		unionSet.addAll(s1);
		unionSet.addAll(s2);

		return unionSet;
	}

	public static<T> Set<T> difference(Set<T> s1, Set<T> s2) {

		Set<T> diffSet = union(s1, s2);

		diffSet.removeAll(s2);

		return diffSet;
	}
	
	public static<T> Set<T> intersection(Set<T> s1, Set<T> s2) {
		
		Set<T> intersectSet = new HashSet<T>();
		intersectSet.addAll(s1);
		intersectSet.retainAll(s2);
		
		return intersectSet;
	}

	public static<T> Set<T> complement(Set<T> s1, Set<T> universe) {
		
		Set<T> complementSet = new HashSet<T>();
		complementSet = difference(universe, s1);
		
		return complementSet;
	}
}
