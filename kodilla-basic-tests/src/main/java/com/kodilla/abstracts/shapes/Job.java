package com.kodilla.abstracts.shapes;

public abstract class Job {
    private int salary;
    private String responsibilities;

    public Job (int salary, String responsibilities){
        this.salary = salary;
        this.responsibilities = responsibilities;
    }
    public int getSalary(){
        return salary;
    }
    public String getResponsibilities(){
        return responsibilities;
    }
}
