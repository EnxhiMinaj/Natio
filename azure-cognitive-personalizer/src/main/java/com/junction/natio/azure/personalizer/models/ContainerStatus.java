/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.junction.natio.azure.personalizer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The ContainerStatus model.
 */
public class ContainerStatus {
    /**
     * The service property.
     */
    @JsonProperty(value = "service")
    private String service;

    /**
     * The apiStatus property.
     */
    @JsonProperty(value = "apiStatus")
    private String apiStatus;

    /**
     * The apiStatusMessage property.
     */
    @JsonProperty(value = "apiStatusMessage")
    private String apiStatusMessage;

    /**
     * Get the service value.
     *
     * @return the service value
     */
    public String service() {
        return this.service;
    }

    /**
     * Set the service value.
     *
     * @param service the service value to set
     * @return the ContainerStatus object itself.
     */
    public ContainerStatus withService(String service) {
        this.service = service;
        return this;
    }

    /**
     * Get the apiStatus value.
     *
     * @return the apiStatus value
     */
    public String apiStatus() {
        return this.apiStatus;
    }

    /**
     * Set the apiStatus value.
     *
     * @param apiStatus the apiStatus value to set
     * @return the ContainerStatus object itself.
     */
    public ContainerStatus withApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
        return this;
    }

    /**
     * Get the apiStatusMessage value.
     *
     * @return the apiStatusMessage value
     */
    public String apiStatusMessage() {
        return this.apiStatusMessage;
    }

    /**
     * Set the apiStatusMessage value.
     *
     * @param apiStatusMessage the apiStatusMessage value to set
     * @return the ContainerStatus object itself.
     */
    public ContainerStatus withApiStatusMessage(String apiStatusMessage) {
        this.apiStatusMessage = apiStatusMessage;
        return this;
    }

}
