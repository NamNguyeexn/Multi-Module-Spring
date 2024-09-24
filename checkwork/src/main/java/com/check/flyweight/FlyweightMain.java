package com.check.flyweight;


import java.util.*;

public class FlyweightMain {
    static List<String> users = Arrays.asList("Ng Th Minh", "Ng Va Binh", "Le Mi Hoang");
    public static void main(String[] args) {
        UserFactory userFactory = new UserFactory();
        for(int i = 0; i < 3; i++){
            String name = users.get(i);
            IUser IUser = userFactory.getConcreteUser(name, xulyEmail(name));
            System.out.println(IUser.getName() + " " + IUser.getEmail());
        }
    }
    public static String xulyEmail(String input){
        String[] s = input.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(s[s.length - 1]);
        for(int i = 0; i < s.length - 1; i++){
            sb.append(s[i].charAt(0));
        }
        sb.append("@gmail.com");
        return sb.toString();
    }
}
