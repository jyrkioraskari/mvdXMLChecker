package de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans;

import java.util.ArrayList;
import java.util.List;

import de.rwth_aachen.dc.mvd.beans.IssueBean;

public class IssueReportBean extends ResponseBean{
    private List<IssueBean> issues = new ArrayList<>();
    
    public IssueReportBean() {
	super();
    }

    public List<IssueBean> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueBean> issues) {
        this.issues = issues;
    }

    
}
