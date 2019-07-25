package com.example.model;

public class Vacancy {
    private String name;
    private String publishedAt;
    private Employer employer;
    private Salary salary;
    private Address address;

    public Vacancy(String name,
                   String publishedAt,
                   Employer employer,
                   Salary salary,
                   Address address) {
        this.name = name;
        this.publishedAt = publishedAt;
        this.employer = employer;
        this.salary = salary;
        this.address = address;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
    	return name + "\n"
    			+ "Опубликовано " 
    			+ publishedAt + "\n"
    			+ employer.toString() + "\n"
    			+ address.toString();
    }
}
