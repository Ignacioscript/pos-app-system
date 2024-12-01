package org.ignacioScript.co.model;

import org.ignacioScript.co.interfaces.DataTransferObject;

public class Job implements DataTransferObject {

    private int jobId;
    private String jobTitle;
    private double salary;

    public Job(int jobId, String jobTitle, double salary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
