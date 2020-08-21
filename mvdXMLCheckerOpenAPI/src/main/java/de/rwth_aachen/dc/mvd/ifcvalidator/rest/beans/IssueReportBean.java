package de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans;

import java.util.ArrayList;
import java.util.List;

import de.rwth_aachen.dc.mvd.beans.IssueBean;

public class IssueReportBean extends ResponseBean{
    private List<IssueBean> issues = new ArrayList<>();
    private List<String> general_comments = new ArrayList<>();
    
    public IssueReportBean() {
	super();
    }

    public List<IssueBean> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueBean> issues) {
        this.issues = issues;
    }
    
   

    public List<String> getGeneral_comments() {
        return general_comments;
    }

    public void setGeneral_comments(List<String> general_comments) {
        this.general_comments = general_comments;
    }

    @Override
    public String getResult() {
        if(issues.size()>0)
            return "Not passed.";
        else
            return "The model is fine.";
    }
}
