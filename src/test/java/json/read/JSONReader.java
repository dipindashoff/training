package json.read;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

public class JSONReader {
	static String filePath = ".\\src\\test\\java\\json\\read\\example.json";

	public static void main(String[] args) {
		// Jackson
		System.out.println(getProperty(filePath, "testcaseID1"));
		System.out.println(getProperty(filePath, "LoginDetails1", "username"));

		// JSON
		System.out.println(getPropertyJSON(filePath, "testcaseID2"));
		System.out.println(getPropertyJSON(filePath, "LoginDetails2", "password"));
		
		// Json Path
		System.out.println(getPropertyJSON(filePath, "testcaseID3"));
		System.out.println(getPropertyJSON(filePath, "LoginDetails3", "username"));

	}

	/**
	 * Sample json file
	 */
//	{
//		"pageInfo" : "123",
//		"LoginDetails" : {
//		"username" : "admin",
//		"password" : "P@ssw0rd"
//	}
//	}

	/**
	 * Read using Jackson
	 */
	public static String getProperty(String filePath, String field) {

		String value = "";

		try {

			byte[] jsonData = Files.readAllBytes(Paths.get(filePath));

			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(jsonData);

			JsonNode fieldNode = node.path(field);

			value = fieldNode.asText(); // returns value as text (without the quotes)

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * Read using Jackson
	 */
	public static String getProperty(String filePath, String root, String field) {

		String value = "";

		try {

			byte[] jsonData = Files.readAllBytes(Paths.get(filePath));

			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(jsonData);

			// 2 ways
			// 1st way
			value = node.at("/" + root + "/" + field).asText();

			// 2nd way
			JsonNode rootNode = node.path(root);
			value = rootNode.path(field).asText();

		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * using org.json
	 */
	public static String getPropertyJSON(String filePath, String field) {
		String value = "";

		try {
			File file = new File(filePath);
			String content = FileUtils.readFileToString(file, "utf-8");

			JSONObject json = new JSONObject(content);
			value = json.getString(field);

		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * using org.json
	 */
	public static String getPropertyJSON(String filePath, String root, String field) {
		String value = "";

		try {
			File file = new File(filePath);
			String content = FileUtils.readFileToString(file, "utf-8");

			JSONObject json = new JSONObject(content);
			value = json.getJSONObject(root).getString(field);

		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * Using json path
	 */
	public static String getPropertyJsonPath(String filePath, String field) {
		String value = "";

		try {
			String json = new String(Files.readAllBytes(Paths.get(filePath)));
			value = JsonPath.read(json, "$." + field).toString();

		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * Using json path
	 */
	public static String getPropertyJsonPath(String filePath, String root, String field) {
		String value = "";

		try {
			String json = new String(Files.readAllBytes(Paths.get(filePath)));
			value = JsonPath.read(json, "$." + root + "." + field).toString();

		} catch (Exception e) {
		}
		return value;
	}

}
