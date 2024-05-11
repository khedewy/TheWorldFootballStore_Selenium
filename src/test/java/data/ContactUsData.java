package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContactUsData {
    public String name, email, phone, comment;

    public void contactUsData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/contactUsData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject person = (JSONObject) object;

            name = (String) person.get("name");
            email = (String) person.get("email");
            phone = (String) person.get("phone");
            comment = (String) person.get("comment");
        }
    }
}
