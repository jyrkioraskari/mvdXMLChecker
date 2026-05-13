package de.rwth_aachen.dc.mvd.checker;

public enum MvdXMLVersion {
	LEGACY_1_1("1_1", "http://buildingsmart-tech.org/mvdXML/mvdXML1-1"),
	V1_1("1.1", "http://buildingsmart-tech.org/mvd/XML/1.1"),
	V1_2("1.2", "http://buildingsmart-tech.org/mvd/XML/1.2"),
	UNKNOWN("unknown", null);

	private final String label;
	private final String namespace;

	MvdXMLVersion(String label, String namespace) {
		this.label = label;
		this.namespace = namespace;
	}

	public String getLabel() {
		return label;
	}

	public String getNamespace() {
		return namespace;
	}
}
