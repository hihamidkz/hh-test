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
public class RegionSoap implements Serializable {
    private long _id;
    private String _name;
    private long _parentId;

    public RegionSoap() {
    }

    public static RegionSoap toSoapModel(Region model) {
        RegionSoap soapModel = new RegionSoap();

        soapModel.setId(model.getId());
        soapModel.setName(model.getName());
        soapModel.setParentId(model.getParentId());

        return soapModel;
    }

    public static RegionSoap[] toSoapModels(Region[] models) {
        RegionSoap[] soapModels = new RegionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RegionSoap[][] toSoapModels(Region[][] models) {
        RegionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RegionSoap[models.length][models[0].length];
        } else {
            soapModels = new RegionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RegionSoap[] toSoapModels(List<Region> models) {
        List<RegionSoap> soapModels = new ArrayList<RegionSoap>(models.size());

        for (Region model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RegionSoap[soapModels.size()]);
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

    public long getParentId() {
        return _parentId;
    }

    public void setParentId(long parentId) {
        _parentId = parentId;
    }
}
