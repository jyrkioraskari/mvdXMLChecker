package de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import de.rwth_aachen.dc.mvd.report.Issue;

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
