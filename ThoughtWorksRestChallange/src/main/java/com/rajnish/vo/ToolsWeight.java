package com.rajnish.vo;

import java.util.ArrayList;
import java.util.List;

public class ToolsWeight {

	private List < String > toolsToTakeSorted = new ArrayList < String > ();

	public List<String> getToolsToTakeSorted() {
		return toolsToTakeSorted;
	}

	public void setToolsToTakeSorted(List<String> toolsToTakeSorted) {
		this.toolsToTakeSorted = toolsToTakeSorted;
	}

	@Override
	public String toString() {
		return "ToolsWeight [toolsToTakeSorted=" + toolsToTakeSorted + "]";
	}

	
	
}
