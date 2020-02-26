package de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "authorizationUrl", "registerUrl", "tokenUrl" })
public class Oauth {

    @JsonProperty("authorizationUrl")
    private String authorizationUrl;
    @JsonProperty("registerUrl")
    private String registerUrl;
    @JsonProperty("tokenUrl")
    private String tokenUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("authorizationUrl")
    public String getAuthorizationUrl() {
	return authorizationUrl;
    }

    @JsonProperty("authorizationUrl")
    public void setAuthorizationUrl(String authorizationUrl) {
	this.authorizationUrl = authorizationUrl;
    }

    @JsonProperty("registerUrl")
    public String getRegisterUrl() {
	return registerUrl;
    }

    @JsonProperty("registerUrl")
    public void setRegisterUrl(String registerUrl) {
	this.registerUrl = registerUrl;
    }

    @JsonProperty("tokenUrl")
    public String getTokenUrl() {
	return tokenUrl;
    }

    @JsonProperty("tokenUrl")
    public void setTokenUrl(String tokenUrl) {
	this.tokenUrl = tokenUrl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
    }

}