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
public class LocalitySoap implements Serializable {
    private long _id;
    private String _name;
    private long _parentId;

    public LocalitySoap() {
    }

    public static LocalitySoap toSoapModel(Locality model) {
        LocalitySoap soapModel = new LocalitySoap();

        soapModel.setId(model.getId());
        soapModel.setName(model.getName());
        soapModel.setParentId(model.getParentId());

        return soapModel;
    }

    public static LocalitySoap[] toSoapModels(Locality[] models) {
        LocalitySoap[] soapModels = new LocalitySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LocalitySoap[][] toSoapModels(Locality[][] models) {
        LocalitySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LocalitySoap[models.length][models[0].length];
        } else {
            soapModels = new LocalitySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LocalitySoap[] toSoapModels(List<Locality> models) {
        List<LocalitySoap> soapModels = new ArrayList<LocalitySoap>(models.size());

        for (Locality model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LocalitySoap[soapModels.size()]);
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
