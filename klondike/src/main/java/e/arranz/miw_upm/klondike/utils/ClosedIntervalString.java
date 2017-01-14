package e.arranz.miw_upm.klondike.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosedIntervalString {

	private List<String> values;

	public ClosedIntervalString(String[] values) {
		this.values = new ArrayList<String>(Arrays.asList(values));
	}

	public boolean includes(String value) {
		return values.contains(value);
	}

	@Override
	public String toString() {
		return values.toString();		    
	}
}
