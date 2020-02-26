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
@JsonPropertyOrder({ "services" })
public class MVDCheck_BOTServiceDescriotor {
    @JsonProperty("services")
    private List<Service> services = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public MVDCheck_BOTServiceDescriotor()
    {
	Service s=new Service();
	s.setId(1212323);    
	s.setName("mvdXML checker");
	s.setDescription("Use mvdXML to validate IFC models");
	s.setProvider("RWTH Aachen DC");
	s.getInputs().add("IFC_STEP_2X3TC1");
	s.getOutputs().add("UNSTRUCTURED_UTF8_TEXT_1_0");
	s.setResourceUrl("https://lbd.arch.rwth-aachen.de:8443/mvdXMLChecker/api/check");
	this.getServices().add(s);
    }

    @JsonProperty("services")
    public List<Service> getServices() {
	return services;
    }

    @JsonProperty("services")
    public void setServices(List<Service> services) {
	this.services = services;
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