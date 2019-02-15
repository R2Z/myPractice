package com.rajnish.processor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajnish.vo.ToolsFound;
import com.rajnish.vo.ToolsJson;

public class ToolsJasonProcessor implements FileProcesor {

	@Override
	public String readInputData(String jsonMessage) {
		
		String jsonString = null;
		ObjectMapper mapper = null;
		ToolsJson reqObject = null;
		List<String> foundTools = null;
		try {
			mapper = new ObjectMapper();
			reqObject = mapper.readValue(jsonMessage, ToolsJson.class);
			System.out.println(reqObject.toString());
			foundTools = findHiddenTools(reqObject);
			System.out.println(foundTools);
			ToolsFound obj = new ToolsFound();
			obj.setToolsFound(foundTools);
			jsonString = mapper.writerWithView(ToolsFound.class).writeValueAsString(obj);
			System.out.println(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	private List<String> findHiddenTools(ToolsJson reqObject){
		
		List<String> foundTools = new ArrayList<String>();
		String hiddenTools = reqObject.getHiddenTools();
		List<String> tools = reqObject.getTools();
		Set<Character> chSet = new HashSet<Character>();
		if(hiddenTools != null && hiddenTools.length() > 0 && tools != null && tools.size() > 0){
			
			for(int i = 0 ; i<hiddenTools.length() ; i++){
				chSet.add(hiddenTools.charAt(i));
			}
			
			for(String tool : tools){
				boolean found = true;
				Character ch = tool.charAt(0);
				if(chSet.contains(ch)){
					String subStr = hiddenTools.substring(hiddenTools.indexOf(ch, 0),hiddenTools.length());
					Set<Character> chSet2 = new HashSet<Character>();
					
					for(int i = 0 ; i<subStr.length() ; i++){
						chSet2.add(subStr.charAt(i));
					}
					
					for(int i = 0 ; i<tool.length() ; i++){
						if(!chSet2.contains(tool.charAt(i))){
							found = false;
							break;
						}
					}
					if(found){
						foundTools.add(tool);
					}
				}
			}
		}
		
		return foundTools;
	}

}
