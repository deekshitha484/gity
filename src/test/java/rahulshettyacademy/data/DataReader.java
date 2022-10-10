package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String,String>> getJsconToMap() throws IOException
	{
		//read and convert jscon to string
		String jsconformat=FileUtils.readFileToString(new File(System.getProperty("usr.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json"));
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsconformat, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	}

}
