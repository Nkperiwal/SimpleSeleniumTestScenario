package com.apple.util;


import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DatabaseLocatorProvider {
	static final String HOSTNAME = "localhost";
	static final int PORT = 27017;
	public String sDBName = "test";
	public String sDBCollection = "locators";
	public static DBCollection coll;
	
	
	public DBCollection getCollection() {
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient(HOSTNAME , PORT);
		
		@SuppressWarnings("deprecation")
		DB database = client.getDB(sDBName);
		
	//	MongoDatabase dataBase = client.getDatabase(sDBName);
	//  MongoCollection<Document> collection = database.getCollection(sDBCollection);
		DBCollection collection = database.getCollection(sDBCollection);
		return collection;
		
	}
	
	public String getFieldValue(DBCollection coll2,String field) {
		//FindIterable<Document> findIt = coll2.find(Filters.eq("HomePage.HeaderPane.Elements.ElementName" , "bagIcon"));
		//Document d = findIt.first();
		//System.out.println("doc: " + d.toJson());
		//System.out.println(d.get("HomePage.Elements"));
		//BasicDBObject fields1 = new BasicDBObject(field,"bagIcon");
		//fields1.put(field, "bagIcon");
		
		
		
		
		List<?> lst = coll2.distinct(field);
		String sLocatorValue = lst.get(0).toString();
		return sLocatorValue;
	}
	
	
	
	
	
	
	
	/*
	public static void main(String[] args) {
		DatabaseLocatorProvider oDatabaseLocatorProvider = new DatabaseLocatorProvider();
		coll = oDatabaseLocatorProvider.getCollection();
		oDatabaseLocatorProvider.getFieldValue(coll,"HomePage.HeaderPane.Elements.bagIcon.locatorValue");
	}
	*/

}













/*
 * public static String getValueByJPath(JSONObject responsejson, String jpath){
		Object obj = responsejson;
		for(String s : jpath.split("/")) 
			if(!s.isEmpty()) 
				if(!(s.contains("[") || s.contains("]")))
					obj = ((JSONObject) obj).get(s);
				else if(s.contains("[") || s.contains("]"))
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		return obj.toString();
	}



public void setUpTestData(DBCollection collection){
    for (int i=1; i <= 10; i++) {
        collection.insert(new BasicDBObject().append("employeeId", i).append("employeeName", "TestEmployee_"+i));
    }
}

private void selectAllRecordsFromACollection(DBCollection collection) {
	DBObject dbObject = collection.findOne();
    System.out.println(dbObject);
    DBCursor cursor = collection.find();
    while(cursor.hasNext()) {
        System.out.println(cursor.next());
    }
}

public  void selectSingleRecordAndFieldByRecordNumber(DBCollection collection, String field, String value) {
    BasicDBObject fields = new BasicDBObject();
    fields.put(field, value);
  
    DBCursor cursor = collection.find(fields);
    while (cursor.hasNext()) {
        System.out.println(cursor.next());
    }
}
*/