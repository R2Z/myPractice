package com.rajnish.vo;

import java.util.ArrayList;

public class ToolsJson {
	
	 private String hiddenTools;
	 private ArrayList < String > tools = new ArrayList < String > ();

	 // Getter Methods 

	 public ArrayList<String> getTools() {
		return tools;
	}

	public void setTools(ArrayList<String> tools) {
		this.tools = tools;
	}

	public String getHiddenTools() {
	  return hiddenTools;
	 }

	 // Setter Methods 

	 public void setHiddenTools(String hiddenTools) {
	  this.hiddenTools = hiddenTools;
	 }

	@Override
	public String toString() {
		return "ToolsJson [hiddenTools=" + hiddenTools + ", tools=" + tools
				+ "]";
	}
	 
	}