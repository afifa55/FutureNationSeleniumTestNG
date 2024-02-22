package utills;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static JSONObject loadJsonFile(String fileLocattion) throws IOException, ParseException, FileNotFoundException {

        JSONParser jsonParser= new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileLocattion));
        JSONObject jsonObject= (JSONObject) obj;
        return jsonObject;


    }

    public static void main(String[] args) throws IOException, ParseException {
        JSONObject userObject=Utils.loadJsonFile("./src/test/resources/user.json");
        String username= (String) userObject.get("email");
        String password= (String) userObject.get("password");

        System.out.println(username);
        System.out.println(password);
    }

}
