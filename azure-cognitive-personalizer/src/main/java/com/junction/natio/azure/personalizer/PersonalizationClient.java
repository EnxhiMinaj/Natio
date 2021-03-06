package com.junction.natio.azure.personalizer;

import com.junction.natio.azure.personalizer.models.ContainerStatus;
import com.junction.natio.azure.personalizer.models.RankRequest;
import com.junction.natio.azure.personalizer.models.RankResponse;
import com.junction.natio.azure.personalizer.models.RewardRequest;
import com.microsoft.rest.*;
import rx.Observable;

/**
 * The interface for PersonalizationClient class.
 */
public interface PersonalizationClient {
    /**
     * Gets the REST client.
     *
     * @return the {@link RestClient} object.
     */
    RestClient restClient();

    /**
     * The default base URL.
     */
    String DEFAULT_BASE_URL = "https://";

    /**
     * Report reward to allocate to the top ranked action for the specified event.
     *
     * @param eventId The event id this reward applies to.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void reward(String eventId);

    /**
     * Report reward to allocate to the top ranked action for the specified event.
     *
     * @param eventId The event id this reward applies to.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<Void> rewardAsync(String eventId, final ServiceCallback<Void> serviceCallback);

    /**
     * Report reward to allocate to the top ranked action for the specified event.
     *
     * @param eventId The event id this reward applies to.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<Void> rewardAsync(String eventId);

    /**
     * Report reward to allocate to the top ranked action for the specified event.
     *
     * @param eventId The event id this reward applies to.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<ServiceResponse<Void>> rewardWithServiceResponseAsync(String eventId);
    /**
     * Report reward to allocate to the top ranked action for the specified event.
     *
     * @param eventId The event id this reward applies to.
     * @param reward The reward should be a floating point number.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void reward(String eventId, RewardRequest reward);

    /**
     * Report reward to allocate to the top ranked action for the specified event.
     *
     * @param eventId The event id this reward applies to.
     * @param reward The reward should be a floating point number.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<Void> rewardAsync(String eventId, RewardRequest reward, final ServiceCallback<Void> serviceCallback);

    /**
     * Report reward to allocate to the top ranked action for the specified event.
     *
     * @param eventId The event id this reward applies to.
     * @param reward The reward should be a floating point number.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<Void> rewardAsync(String eventId, RewardRequest reward);

    /**
     * Report reward to allocate to the top ranked action for the specified event.
     *
     * @param eventId The event id this reward applies to.
     * @param reward The reward should be a floating point number.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<ServiceResponse<Void>> rewardWithServiceResponseAsync(String eventId, RewardRequest reward);

    /**
     * Report that the specified event was actually displayed to the user and a reward should be expected for it.
     *
     * @param eventId The event id this activation applies to.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void activate(String eventId);

    /**
     * Report that the specified event was actually displayed to the user and a reward should be expected for it.
     *
     * @param eventId The event id this activation applies to.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<Void> activateAsync(String eventId, final ServiceCallback<Void> serviceCallback);

    /**
     * Report that the specified event was actually displayed to the user and a reward should be expected for it.
     *
     * @param eventId The event id this activation applies to.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<Void> activateAsync(String eventId);

    /**
     * Report that the specified event was actually displayed to the user and a reward should be expected for it.
     *
     * @param eventId The event id this activation applies to.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<ServiceResponse<Void>> activateWithServiceResponseAsync(String eventId);

    /**
     * A personalization rank request.
     *
     * @param personalizationRequest A personalization request.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the RankResponse object if successful.
     */
    RankResponse rank(RankRequest personalizationRequest);

    /**
     * A personalization rank request.
     *
     * @param personalizationRequest A personalization request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<RankResponse> rankAsync(RankRequest personalizationRequest, final ServiceCallback<RankResponse> serviceCallback);

    /**
     * A personalization rank request.
     *
     * @param personalizationRequest A personalization request.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RankResponse object
     */
    Observable<RankResponse> rankAsync(RankRequest personalizationRequest);

    /**
     * A personalization rank request.
     *
     * @param personalizationRequest A personalization request.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RankResponse object
     */
    Observable<ServiceResponse<RankResponse>> rankWithServiceResponseAsync(RankRequest personalizationRequest);

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ContainerStatus object if successful.
     */
    ContainerStatus statusGet();

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<ContainerStatus> statusGetAsync(final ServiceCallback<ContainerStatus> serviceCallback);

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ContainerStatus object
     */
    Observable<ContainerStatus> statusGetAsync();

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ContainerStatus object
     */
    Observable<ServiceResponse<ContainerStatus>> statusGetWithServiceResponseAsync();

}
