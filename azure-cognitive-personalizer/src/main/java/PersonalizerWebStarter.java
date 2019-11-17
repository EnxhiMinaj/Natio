import com.junction.natio.azure.personalizer.implementation.PersonalizationClientImpl;
import com.junction.natio.azure.personalizer.models.*;
import com.junction.natio.azure.util.PersonalizerHelper;
import com.microsoft.rest.RestClient;
import com.microsoft.rest.ServiceResponseBuilder;
import com.microsoft.rest.serializer.JacksonAdapter;
import okhttp3.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Created by Plarent on 16/11/2019.
 */
@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"com.junction"}
)
public class PersonalizerWebStarter {

    private static String API_KEY = "88acfbd528b94b5c8aa4e3675982b902";
    private static String SERVICE_ENDPOINT = "https://natio.cognitiveservices.azure.com";

    public static void main(String[] args) {
        SpringApplication.run(PersonalizerWebStarter.class, args);
    }

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

        // Get top three suggested trail names
        for(int index = 0; index < 3; index++){
            suggestedTrailNames.add(response.ranking().get(index).id());
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



