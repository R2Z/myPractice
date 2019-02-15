package com.rajnish.processor;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import com.rajnish.vo.ToolUsage;

public class ToolsUtilizationProcessor implements FileProcesor {

	@Override
	public String readInputData(String jsonMessage) {
		
		String jsonString = null;
		
		try {
			List<ToolUsage> toolsList = new LinkedList<ToolUsage>();
			JSONObject obj_JSONObject = new JSONObject(jsonMessage);
			JSONArray obj_JSONArray = obj_JSONObject.getJSONArray("toolUsage");
			System.out.println(obj_JSONArray);
			
			for(int i = 0 ; i< obj_JSONArray.length() ; i++){
				ToolUsage usage = new ToolUsage();
				JSONObject obj_JSONObject2 = (JSONObject) obj_JSONArray.get(i);
				usage.setName(obj_JSONObject2.getString("name"));
				usage.setUseStartTime(obj_JSONObject2.getString("useStartTime"));
				usage.setUseEndTime(obj_JSONObject2.getString("useEndTime"));
				toolsList.add(usage);
			}
			
			Map<String,Long> toolUsageMap = new LinkedHashMap<String,Long>();
			
			for(ToolUsage usage : toolsList){
				if(toolUsageMap.containsKey(usage.getName())){
					long totalTime = toolUsageMap.get(usage.getName())+ usage.getUsageInMins();
					toolUsageMap.put(usage.getName(), totalTime);
				}else{
					toolUsageMap.put(usage.getName(), usage.getUsageInMins());
				}
			}
			
			JSONObject outPutJsonObject = new JSONObject();
			JSONArray array=new JSONArray();
			JSONObject jsonObj1=null;
			
			Map<String, Long> sortedMapDesc = sortByComparator(toolUsageMap, false);
			
			for(Entry<String, Long> en : sortedMapDesc.entrySet()){
				jsonObj1 = new JSONObject();
				jsonObj1.put("name", en.getKey());
				jsonObj1.put("timeUsedInMinutes", en.getValue());
				array.put(jsonObj1);
			}
			
			outPutJsonObject.put("toolsSortedOnUsage",array);
			System.out.println(outPutJsonObject.toString());
			jsonString = outPutJsonObject.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}

	
	private static Map<String, Long> sortByComparator(Map<String, Long> unsortMap, final boolean order)
    {

        List<Entry<String, Long>> list = new LinkedList<Entry<String, Long>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Long>>()
        {
            public int compare(Entry<String, Long> o1,
                    Entry<String, Long> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });
        
     // Maintaining insertion order with the help of LinkedList
        Map<String, Long> sortedMap = new LinkedHashMap<String, Long>();
        for (Entry<String, Long> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    } 
}
