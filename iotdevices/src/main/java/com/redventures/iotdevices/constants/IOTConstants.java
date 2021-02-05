package com.redventures.iotdevices.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOTConstants {
	public static final List<String> EVENTS = Arrays.asList("heartbeat", "enter", "exit");
	public static final List<Integer> DOORS = Arrays.asList(1, 2, 3);
    public static final Map<Integer, List<Integer>> EMPLOYEES_ACCESS = createMap();
    private static Map<Integer, List<Integer>> createMap() {
    	Map<Integer, List<Integer>> result = new HashMap<>();
        result.put(1, Arrays.asList(1));
        result.put(2, Arrays.asList(1, 3));
        result.put(3, Arrays.asList(1, 2));
        result.put(4, Arrays.asList(3));
        result.put(5, Arrays.asList(1, 2, 3));
        return Collections.unmodifiableMap(result);
    }
}
