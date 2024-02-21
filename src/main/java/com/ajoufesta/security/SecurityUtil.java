package com.ajoufesta.security;

import com.ajoufesta.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.FileReader;
import java.io.IOException;

@RequiredArgsConstructor
public class SecurityUtil {

    public static UserInfoDto getCurrentMemberId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("No authentication information.");
        }

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setCode(authentication.getName());
        userInfoDto.setMemberRole(authentication.getAuthorities().stream().toList().get(0).toString().replaceAll("ROLE_", ""));
        return userInfoDto;
    }

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
            }
        }
        return null;
    }

}