package de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "description", "provider", "providerIcon", "inputs", "outputs", "oauth", "resourceUrl" })
public class Service {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("provider")
    private String provider;
    @JsonProperty("providerIcon")
    private String providerIcon;
    @JsonProperty("inputs")
    private List<String> inputs = new ArrayList<>();
    @JsonProperty("outputs")
    private List<String> outputs= new ArrayList<>();
    @JsonProperty("oauth")
    private Oauth oauth;
    @JsonProperty("resourceUrl")
    private String resourceUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
	return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
	this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
	return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
	this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
	return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
	this.description = description;
    }

    @JsonProperty("provider")
    public String getProvider() {
	return provider;
    }

    @JsonProperty("provider")
    public void setProvider(String provider) {
	this.provider = provider;
    }

    @JsonProperty("providerIcon")
    public String getProviderIcon() {
	return providerIcon;
    }

    @JsonProperty("providerIcon")
    public void setProviderIcon(String providerIcon) {
	this.providerIcon = providerIcon;
    }

    @JsonProperty("inputs")
    public List<String> getInputs() {
	return inputs;
    }

    @JsonProperty("inputs")
    public void setInputs(List<String> inputs) {
	this.inputs = inputs;
    }

    @JsonProperty("outputs")
    public List<String> getOutputs() {
	return outputs;
    }

    @JsonProperty("outputs")
    public void setOutputs(List<String> outputs) {
	this.outputs = outputs;
    }

    @JsonProperty("oauth")
    public Oauth getOauth() {
	return oauth;
    }

    @JsonProperty("oauth")
    public void setOauth(Oauth oauth) {
	this.oauth = oauth;
    }

    @JsonProperty("resourceUrl")
    public String getResourceUrl() {
	return resourceUrl;
    }

    @JsonProperty("resourceUrl")
    public void setResourceUrl(String resourceUrl) {
	this.resourceUrl = resourceUrl;
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