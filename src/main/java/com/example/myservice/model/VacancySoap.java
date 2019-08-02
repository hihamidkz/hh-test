package com.example.myservice.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author hamid
 * @generated
 */
public class VacancySoap implements Serializable {
    private long _id;
    private String _name;
    private String _publishedAt;
    private String _employer;
    private String _salary;
    private String _address;

    public VacancySoap() {
    }

    public static VacancySoap toSoapModel(Vacancy model) {
        VacancySoap soapModel = new VacancySoap();

        soapModel.setId(model.getId());
        soapModel.setName(model.getName());
        soapModel.setPublishedAt(model.getPublishedAt());
        soapModel.setEmployer(model.getEmployer());
        soapModel.setSalary(model.getSalary());
        soapModel.setAddress(model.getAddress());

        return soapModel;
    }

    public static VacancySoap[] toSoapModels(Vacancy[] models) {
        VacancySoap[] soapModels = new VacancySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static VacancySoap[][] toSoapModels(Vacancy[][] models) {
        VacancySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new VacancySoap[models.length][models[0].length];
        } else {
            soapModels = new VacancySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static VacancySoap[] toSoapModels(List<Vacancy> models) {
        List<VacancySoap> soapModels = new ArrayList<VacancySoap>(models.size());

        for (Vacancy model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new VacancySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getPublishedAt() {
        return _publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        _publishedAt = publishedAt;
    }

    public String getEmployer() {
        return _employer;
    }

    public void setEmployer(String employer) {
        _employer = employer;
    }

    public String getSalary() {
        return _salary;
    }

    public void setSalary(String salary) {
        _salary = salary;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }
}
