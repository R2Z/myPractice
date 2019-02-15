package com.rajnish.vo;

import java.util.ArrayList;
import java.util.List;

public class ToolsFound {

	private List < String > toolsFound = new ArrayList < String > ();


	 // Getter Methods 



	 // Setter Methods 

	 public List<String> getToolsFound() {
		return toolsFound;
	}


	public void setToolsFound(List<String> toolsFound) {
		this.toolsFound = toolsFound;
	}


	@Override
		public String toString() {
			return "ToolsFound [toolsFound=" + toolsFound + "]";
		}
	}
