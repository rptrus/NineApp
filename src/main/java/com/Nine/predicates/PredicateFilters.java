package com.Nine.predicates;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateFilters { 
	public static Predicate<Map<String, Object>> drmTrue = map -> map.containsKey("drm") && map.get("drm").equals(Boolean.TRUE);
	public static Predicate<Map<String, Object>> epCountGreaterThanZero = map -> map.containsKey("episodeCount") && (Integer)map.get("episodeCount") > Integer.valueOf(0);
}
