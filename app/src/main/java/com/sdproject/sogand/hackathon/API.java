package com.sdproject.sogand.hackathon;

/**
 * Created by shayan on 11/11/18.
 */

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.util.HashMap;
import org.json.JSONObject;

public class API {

    enum Field {

        Clothes("clothes"),
        EatOut("eatout"),
        Events("events"),
        Movies("movies"),
        Others("others"),
        Subscriptions("subscriptions");

        private final String s;
        Field(final String someString) {
            this.s = someString;
        }

        public String s(){
            return s;
        }
    }


    public static void register(String name, String username, int password) {

        HashMap<String, Object> fields = new HashMap<>();

        fields.put("name", name);
        fields.put("username", username);
        fields.put("password", password);

        JSONObject jsonObject = new JSONObject(fields);

        try {

            HttpResponse<String> response = Unirest.post(Config.BASE_URL + "/register")
                    .header("Content-Type", "application/json").body(jsonObject.toString()).asString();
            System.out.print(response.getBody());

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public static JSONObject login(String username, int password) {

        HashMap<String, Object> fields = new HashMap<>();

        fields.put("username", username);
        fields.put("password", password);

        JSONObject jsonObject = new JSONObject(fields);

        try {

            HttpResponse<String> response = Unirest.post(Config.BASE_URL + "/login")
                    .header("Content-Type", "application/json").body(jsonObject.toString()).asString();

            JSONObject jsonObj = new JSONObject(response.getBody());
            return jsonObj;

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new JSONObject();

    }

    public static JSONObject createProfile(String username, double expense, double income, double saving) {

        HashMap<String, Object> fields = new HashMap<>();

        fields.put("username", username);
        fields.put("expense", expense);
        fields.put("income", income);
        fields.put("saving", saving);

        JSONObject jsonObject = new JSONObject(fields);

        try {

            HttpResponse<String> response = Unirest.post(Config.BASE_URL + "/expenses")
                    .header("Content-Type", "application/json").body(jsonObject.toString()).asString();

            System.out.println(response.getBody());
            return new JSONObject(response.getBody());

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new JSONObject();

    }

    public static JSONObject addProfile(String username, Field field, double amount) {

        HashMap<String, Object> fields = new HashMap<>();

        fields.put("username", username);
        fields.put(field.s, amount);

        JSONObject jsonObject = new JSONObject(fields);

        try {

            HttpResponse<String> response = Unirest.put(Config.BASE_URL + "/expense")
                    .header("Content-Type", "application/json").body(jsonObject.toString()).asString();

            return new JSONObject(response.getBody());

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new JSONObject();

    }

    public static JSONObject getProfile(String username) {

        try {

            HttpResponse<String> response = Unirest.get(Config.BASE_URL + "/expense/" + username).asString();

            return new JSONObject(response.getBody());

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new JSONObject();

    }
/*
    public static void main(String[] args) {

        register("shayan", "shayy", 12);
        JSONObject data = login("shayy", 12);
        addProfile("shayy", Field.Clothes, 100.5);
        data = getProfile("shayy");
        System.out.println(data.toString());

    }
*/
}

