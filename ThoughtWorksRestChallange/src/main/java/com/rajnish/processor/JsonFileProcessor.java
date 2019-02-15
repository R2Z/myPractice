package com.rajnish.processor;

import java.io.IOException;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajnish.vo.InputMessage;
import com.rajnish.vo.OutPutMessage;

public class JsonFileProcessor implements FileProcesor {
	
	private static BidiMap charIntMap = null;
	
	static{
		
		charIntMap = new DualHashBidiMap();
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i =0 ; i< str.length() ;i++){
			charIntMap.put(str.charAt(i), i+1);
		}
	}

	public String readInputData(String jsonMessage) {
		
		String jsonString = null;
		String decodedMsg = null;
		ObjectMapper mapper = null;
		InputMessage reqObject = null;
		
		try {
			mapper = new ObjectMapper();
			reqObject = mapper.readValue(jsonMessage, InputMessage.class);
			System.out.println(reqObject.getEncryptedMessage());
			decodedMsg = decodeInputString(reqObject.getEncryptedMessage(), reqObject.getKey());
			System.out.println(decodedMsg);
			OutPutMessage obj = new OutPutMessage();
			obj.setMessage(decodedMsg);
			jsonString = mapper.writerWithView(OutPutMessage.class).writeValueAsString(obj);
			System.out.println(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	private String decodeInputString(String str, int key){
		
		StringBuilder sb = new StringBuilder();
		if(str != null && str.length() > 0){
			for(int i = 0 ;i< str.length() ;i++){
				if(charIntMap.containsKey(str.charAt(i))){
					int diff = Integer.valueOf(charIntMap.get(str.charAt(i)).toString()) - key;
					if(diff >= 0){
						sb.append(charIntMap.getKey(diff));
					}else{
						sb.append(charIntMap.getKey(diff+26));
					}
				}else{
					sb.append(str.charAt(i));
				}
				
			}
		}
		
		return sb.toString();
	}

}
