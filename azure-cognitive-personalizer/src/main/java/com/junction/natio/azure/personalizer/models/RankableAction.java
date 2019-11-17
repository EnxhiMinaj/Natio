/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.junction.natio.azure.personalizer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * An action with it's associated features used for ranking.
 */
public class RankableAction {
    /**
     * Id of the action.
     */
    @JsonProperty(value = "id", required = true)
    private String id;

    /**
     * List of dictionaries containing features.
     */
    @JsonProperty(value = "features", required = true)
    private List<Object> features;

    /**
     * Get id of the action.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set id of the action.
     *
     * @param id the id value to set
     * @return the RankableAction object itself.
     */
    public RankableAction withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get list of dictionaries containing features.
     *
     * @return the features value
     */
    public List<Object> features() {
        return this.features;
    }

    /**
     * Set list of dictionaries containing features.
     *
     * @param features the features value to set
     * @return the RankableAction object itself.
     */
    public RankableAction withFeatures(List<Object> features) {
        this.features = features;
        return this;
    }

}
