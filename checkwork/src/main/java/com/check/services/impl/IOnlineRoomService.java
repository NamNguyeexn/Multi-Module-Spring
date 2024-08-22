package com.check.services.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@Slf4j
@Service
public class IOnlineRoomService{
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String SYMBOLS = "?&=";
    private String randomString(int n){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }
    private String randomSymbol(int n){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(SYMBOLS.length());
            stringBuilder.append(SYMBOLS.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }
    private String randomPlatform(){
        List<String> platforms = new ArrayList<>();
        platforms.add("google");
        platforms.add("microsoft");
        Random random = new Random();
        return platforms.get(random.nextInt(platforms.size()));
    }
    public String prepareMeeting(List<String> data) {
        String platform = randomPlatform();
        String url = "https://meet." + platform + ".com/" +
                randomString(3) + "-" +
                randomString(4) + "-" +
                randomString(3) + "-" +
                randomSymbol(1) +
                randomString(10);
        return randomString(3) + "@" + platform + " ; " + url;
    }
}
