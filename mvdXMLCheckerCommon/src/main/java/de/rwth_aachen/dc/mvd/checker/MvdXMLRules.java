package de.rwth_aachen.dc.mvd.checker;

import java.util.List;

public interface MvdXMLRules<ModelViewType, TemplateType, ConstraintRootSetType> {
	boolean isValid();

	List<ModelViewType> getModelViews();

	List<TemplateType> getAllTemplates() throws Exception;

	List<ConstraintRootSetType> getMVDConstraints();
}
