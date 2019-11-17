package com.junction.natio.azure.service;

import com.junction.natio.azure.personalizer.implementation.PersonalizationClientImpl;
import com.junction.natio.azure.personalizer.models.RankRequest;
import com.junction.natio.azure.personalizer.models.RankResponse;
import com.junction.natio.azure.util.PersonalizerHelper;
import com.microsoft.rest.RestClient;
import com.microsoft.rest.ServiceResponseBuilder;
import com.microsoft.rest.serializer.JacksonAdapter;
import okhttp3.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalizerService {

    private static String API_KEY = "88acfbd528b94b5c8aa4e3675982b902";
    private static String SERVICE_ENDPOINT = "https://natio.cognitiveservices.azure.com";


    /**
     * Creates and runs and instance of Azure Cognitive Personalizer
     * @param allTrailNames : All trail names to create the possible actions
     * @param userTrailNames : Trail names the user has visited in order to create the features
     * @return List of top three suggested trails
     */
    public List<String> runPersonalizer(List<String> allTrailNames, List<String> userTrailNames){
        PersonalizationClientImpl client = initializePersonalizationClient(SERVICE_ENDPOINT, API_KEY);
        String eventId = java.util.UUID.randomUUID().toString();
        RankRequest personalizationRequest = new RankRequest()
                .withActions(PersonalizerHelper.getActions(allTrailNames))
                .withContextFeatures(PersonalizerHelper.getFeatures(userTrailNames))
                .withEventId(eventId);

        RankResponse response = client.rank(personalizationRequest);

        List<String> suggestedTrailNames = new ArrayList<>();
        suggestedTrailNames.add(response.ranking().get(0).id());
        // Get top three suggested trail names
        for(int index = 0; index < 2; index++){
            allTrailNames.remove(allTrailNames.indexOf(response.ranking().get(0).id()));
            eventId = java.util.UUID.randomUUID().toString();
            personalizationRequest = new RankRequest()
                    .withActions(PersonalizerHelper.getActions(allTrailNames))
                    .withContextFeatures(PersonalizerHelper.getFeatures(userTrailNames))
                    .withEventId(eventId);

            response = client.rank(personalizationRequest);
            suggestedTrailNames.add(response.ranking().get(0).id());
        }
        return suggestedTrailNames;
    }

    /**
     * Initializes the personalization client.
     * @param url : The endpoint specific to your personalization service instance.
     * @param apiKey : key specific to your personalization service instance.
     * @return Personalization client instance.
     */
    private static PersonalizationClientImpl initializePersonalizationClient(String url, String apiKey) {
        RestClient restClient = new RestClient.Builder()
                .withBaseUrl(url)
                .withInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("Ocp-Apim-Subscription-Key", apiKey)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                })
                .withResponseBuilderFactory(new ServiceResponseBuilder.Factory())
                .withSerializerAdapter(new JacksonAdapter())
                .build();
        return new PersonalizationClientImpl(restClient);
    }


}



