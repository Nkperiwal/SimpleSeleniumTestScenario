package com.apple.util;

import java.io.File;
import java.io.IOException;

import com.jayway.jsonpath.JsonPath;

public class JsonFileHandler {
	
	public File jsonFile;
	public String firstName;
	public String lastName;
	public String areaCode;
	public String primaryPhoneNumber;
	public String address1;
	public String address2;
	public String zipCode;
	
	
	public JsonFileHandler() {
		jsonFile =  new File(System.getProperty("user.dir")+"/src/main/resources/RequiredFiles/testdata.json");
	}
	
	public void readJsonFile() {
		try {
			firstName = JsonPath.read(jsonFile, "$."+"ShippingAddress.Details[0].firstName");
			lastName = JsonPath.read(jsonFile, "$."+"ShippingAddress.Details[0].lastName");
			areaCode = JsonPath.read(jsonFile, "$."+"ShippingAddress.Details[0].areaCode");
			primaryPhoneNumber = JsonPath.read(jsonFile, "$."+"ShippingAddress.Details[0].primaryPhoneNumber");
			address1 = JsonPath.read(jsonFile, "$."+"ShippingAddress.Details[0].address1");
			address2 = JsonPath.read(jsonFile, "$."+"ShippingAddress.Details[0].address2");
			zipCode = JsonPath.read(jsonFile, "$."+"ShippingAddress.Details[0].zipCode");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
/*	public static void main(String[] args) {
		new JsonFileHandler().readJsonFile();
	}*/

}
