package com.junction.natio.azure.moderation;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minidev.json.JSONObject;
import okhttp3.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Plarent on 17/11/2019.
 */
@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"com.junction"}
)

public class ModeratorWebStarter {

    private static String API_KEY = "012ee72d91914c53b120e0d71552fceb";
    private static String SERVICE_ENDPOINT = "https://mymoderator.cognitiveservices.azure.com/contentmoderator/moderate/v1.0/ProcessText/Screen?classify=True&language=eng";

    private static final MediaType JSON = MediaType.get("text/plain; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ModeratorWebStarter.class, args);
        postTest(SERVICE_ENDPOINT, "Pussy");
    }

    public static String postTest(String url, String message) throws IOException {
        RequestBody body = RequestBody.create(JSON, message);
        Request request = new Request.Builder()
                .header("Ocp-Apim-Subscription-Key", "012ee72d91914c53b120e0d71552fceb")
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            JsonObject jsonObject = new JsonParser().parse(response.body().string()).getAsJsonObject();

            JsonObject cat1 = (JsonObject) jsonObject.getAsJsonObject("Classification").get("Category1");
            double category1 = Double.parseDouble(cat1.get("Score").getAsString());

            JsonObject cat2 = (JsonObject) jsonObject.getAsJsonObject("Classification").get("Category2");
            double category2 = Double.parseDouble(cat2.get("Score").getAsString());

            JsonObject cat3 = (JsonObject) jsonObject.getAsJsonObject("Classification").get("Category3");
            double category3 = Double.parseDouble(cat3.get("Score").getAsString());

            if(category1 > 0.5 || category2 > 0.5 || category3 > 0.4){
                return "Offensive message";
            }else {
                return "Message is not offensive";
            }
        }
    }
}
