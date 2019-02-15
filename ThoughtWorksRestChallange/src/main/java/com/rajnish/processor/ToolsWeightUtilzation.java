package com.rajnish.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajnish.vo.ToolsWeight;
import com.rajnish.vo.ToolsWeightVO;

public class ToolsWeightUtilzation implements FileProcesor {

	private int capacity;
	private List<ToolsWeightVO> items;
	
	@Override
	public String readInputData(String jsonMessage) {
		
		String jsonString = null;
		
		try {
			
			items = new LinkedList<ToolsWeightVO>();
			JSONObject obj_JSONObject = new JSONObject(jsonMessage);
			capacity = Integer.valueOf(obj_JSONObject.getString("maximumWeight"));
			JSONArray obj_JSONArray = obj_JSONObject.getJSONArray("tools");
			
			for(int i = 0 ; i < obj_JSONArray.length() ; i++ ){
				ToolsWeightVO wtVO = new ToolsWeightVO();
				JSONObject obj_JSONObject2 = (JSONObject) obj_JSONArray.get(i);
				wtVO.setName(obj_JSONObject2.getString("name"));
				wtVO.setValue(Integer.valueOf(obj_JSONObject2.getString("value")));
				wtVO.setWeight(Integer.valueOf(obj_JSONObject2.getString("weight")));
				
				items.add(wtVO);
			}
			
			
			List<ToolsWeightVO> itemsSolution = solveKnapSak() ;
			Collections.sort(itemsSolution);
			
			//System.out.println(itemsSolution);
			ObjectMapper mapper = new ObjectMapper();;
			List<String> list = new ArrayList<String>();
			
			for(ToolsWeightVO vo : itemsSolution){
				list.add(vo.getName());
			}
			

			ToolsWeight obj = new ToolsWeight();
			obj.setToolsToTakeSorted(list);
			jsonString = mapper.writerWithView(ToolsWeight.class).writeValueAsString(obj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	private List<ToolsWeightVO> solveKnapSak(){
		
		int NB_ITEMS = items.size();
		int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];
		
		for (int i = 0; i <= capacity; i++){
			matrix[0][i] = 0;
		}
		
		for (int i = 1; i <= NB_ITEMS; i++) {
		      // iterate on each capacity
		      for (int j = 0; j <= capacity; j++) {
		        if (items.get(i - 1).getWeight() > j)
		          matrix[i][j] = matrix[i-1][j];
		        else
		          // maximize value at this rank in the matrix
		          matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - items.get(i - 1).getWeight()] 
						  + items.get(i - 1).getValue());
		      }
		    }
		
		int res = matrix[NB_ITEMS][capacity];
	    int w = capacity;
	    List<ToolsWeightVO> itemsSolution = new ArrayList<>();
	    
	    for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
	        if (res != matrix[i-1][w]) {
	          itemsSolution.add(items.get(i - 1));
	          // we remove items value and weight
	          res -=  items.get(i - 1).getValue();
	          w -= items.get(i - 1).getWeight();
	        }
	      }
		
		return itemsSolution;
	}

}
