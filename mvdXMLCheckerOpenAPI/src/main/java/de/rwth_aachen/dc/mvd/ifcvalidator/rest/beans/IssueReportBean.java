package de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans;

import java.util.ArrayList;
import java.util.List;

import de.rwth_aachen.dc.mvd.beans.Issue;

public class IssueReportBean extends ResponseBean{
    private List<Issue> issues = new ArrayList<>();
    
    public IssueReportBean() {
	super();
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    
}
