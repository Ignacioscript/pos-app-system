package org.ignacioScript.co.dto;

public class JobDTO {

    private String jobTitle;
    private double salary;

    public JobDTO(String jobTitle, double salary) {
        this.jobTitle = jobTitle;
        this.salary = salary;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Job [jobTitle=").append(jobTitle)
                .append(", salary=").append(salary)
                .append("]");
      return sb.toString();
    }
}
