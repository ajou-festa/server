package com.ajoufesta.security;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

@RequiredArgsConstructor
public class SecurityUtil {
    private static JSONArray readJsonFile(String filePath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            JSONArray codes = (JSONArray) jsonParser.parse(reader);
            return codes;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject findByCode(String code) {
        JSONArray codes = readJsonFile("src/main/resources/code_sample.json");
        if (codes != null) {
            for (Object obj : codes) {
                JSONObject jsonObject = (JSONObject) obj;
                if (jsonObject.get("code").equals(code)) {
                    return jsonObject;
                }
                System.out.println("notif "+ jsonObject + code);
            }
        }
        return null;
    }

}