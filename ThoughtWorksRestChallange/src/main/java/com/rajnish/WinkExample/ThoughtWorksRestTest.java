package com.rajnish.WinkExample;

import javax.ws.rs.core.MediaType;

import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

import com.rajnish.processor.FileProcesor;
import com.rajnish.processor.JsonFileProcessor;
import com.rajnish.processor.ToolsJasonProcessor;
import com.rajnish.processor.ToolsUtilizationProcessor;
import com.rajnish.processor.ToolsWeightUtilzation;


public class ThoughtWorksRestTest {
	
	//static String jsonMessage = "{\"encryptedMessage\":\"GOVV GO MKX NY SD WI GKI, YB GO MKX KVV MYWO LKMU SX DSWO PYB DRO XOHD KVSQXWOXD KXN IYE'BO GOVMYWO DY DBI KXN USVV WO DROX, SX YR, CKI, KXYDROB 5,000 IOKBC?\",\"key\":10}";
	//static String str1 = "{\"encryptedMessage\":\"F KFRTZX JCUQTWJW TSHJ XFNI, YMFY YMJ JCYWFTWINSFWD NX NS BMFY BJ IT, STY BMT BJ FWJ. LT JCUQTWJ!\",\"key\":5}";
	//static String str2 = "{\"hiddenTools\":\"opekandifehgujnsr\",\"tools\":[\"knife\",\"guns\",\"rope\"]}";
	//static String str3 = "{\"toolUsage\":[{\"name\":\"knife\",\"useStartTime\":\"2017-01-30 10:00:00\",\"useEndTime\":\"2017-01-30 10:10:00\"},{\"name\":\"guns\",\"useStartTime\":\"2017-01-30 10:15:00\",\"useEndTime\":\"2017-01-30 10:20:00\"},{\"name\":\"guns\",\"useStartTime\":\"2017-01-30 11:00:00\",\"useEndTime\":\"2017-01-30 11:10:00\"},{\"name\":\"knife\",\"useStartTime\":\"2017-01-30 11:10:00\",\"useEndTime\":\"2017-01-30 11:20:00\"},{\"name\":\"rope\",\"useStartTime\":\"2017-01-30 13:00:00\",\"useEndTime\":\"2017-01-30 14:00:00\"}]}";
	static String str4 = "{\"tools\":[{\"name\":\"knife\",\"weight\":1,\"value\":80},{\"name\":\"guns\",\"weight\":5,\"value\":90},{\"name\":\"rope\",\"weight\":10,\"value\":60},{\"name\":\"water\",\"weight\":8,\"value\":40}],\"maximumWeight\":15}";
	static String REST_WEB_SERVICE		="https://http-hunt.thoughtworks-labs.net/challenge";
	static String REST_WEB_SERVICE_IP	="https://http-hunt.thoughtworks-labs.net/challenge/input";
	static String REST_WEB_SERVICE_OP	="https://http-hunt.thoughtworks-labs.net/challenge/output";
    static ClientConfig clientConfig = new ClientConfig();
    
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		//testRestClient(new JsonFileProcessor());
		//testRestClient(new ToolsJasonProcessor());
		//testRestClient(new ToolsUtilizationProcessor());
		//testRestClient(new ToolsWeightUtilzation());
		//String enCodedStr = getJsonString(REST_WEB_SERVICE_IP); 
		//System.out.println(enCodedStr);
		System.out.println(new ToolsWeightUtilzation().readInputData(str4));
		System.out.println("Total Time Taken --> "+ (System.currentTimeMillis()-t1)/1000);
	}
	
	private static void testRestClient(FileProcesor processor){
		String enCodedStr = getJsonString(REST_WEB_SERVICE_IP); 
		System.out.println(enCodedStr);
		String deCodedStr = processor.readInputData(enCodedStr);
		System.out.println(deCodedStr);
		sendJsonResonnse(deCodedStr);
	}
	
	private static void sendJsonResonnse(String deCodedStr){
		
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE_OP).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("userId", "WGUWpPpkW");
		String outPut = resource.post(String.class,deCodedStr);
		System.out.println(outPut);
	}
	private static String getJsonString(String url){
		
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(url).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("userId", "WGUWpPpkW");
        String enCodedStr = resource.get(String.class); 
		
		return enCodedStr;
	}
	
}
