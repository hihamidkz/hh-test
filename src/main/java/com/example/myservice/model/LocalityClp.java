package com.example.myservice.model;

import com.example.myservice.service.ClpSerializer;
import com.example.myservice.service.LocalityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class LocalityClp extends BaseModelImpl<Locality> implements Locality {
    private long _id;
    private String _name;
    private long _parentId;
    private BaseModel<?> _localityRemoteModel;

    public LocalityClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Locality.class;
    }

    @Override
    public String getModelClassName() {
        return Locality.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("name", getName());
        attributes.put("parentId", getParentId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Long parentId = (Long) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_localityRemoteModel != null) {
            try {
                Class<?> clazz = _localityRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_localityRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_localityRemoteModel != null) {
            try {
                Class<?> clazz = _localityRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_localityRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getParentId() {
        return _parentId;
    }

    @Override
    public void setParentId(long parentId) {
        _parentId = parentId;

        if (_localityRemoteModel != null) {
            try {
                Class<?> clazz = _localityRemoteModel.getClass();

                Method method = clazz.getMethod("setParentId", long.class);

                method.invoke(_localityRemoteModel, parentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLocalityRemoteModel() {
        return _localityRemoteModel;
    }

    public void setLocalityRemoteModel(BaseModel<?> localityRemoteModel) {
        _localityRemoteModel = localityRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _localityRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_localityRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LocalityLocalServiceUtil.addLocality(this);
        } else {
            LocalityLocalServiceUtil.updateLocality(this);
        }
    }

    @Override
    public Locality toEscapedModel() {
        return (Locality) ProxyUtil.newProxyInstance(Locality.class.getClassLoader(),
            new Class[] { Locality.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LocalityClp clone = new LocalityClp();

        clone.setId(getId());
        clone.setName(getName());
        clone.setParentId(getParentId());

        return clone;
    }

    @Override
    public int compareTo(Locality locality) {
        int value = 0;

        value = getName().compareTo(locality.getName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LocalityClp)) {
            return false;
        }

        LocalityClp locality = (LocalityClp) obj;

        long primaryKey = locality.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", parentId=");
        sb.append(getParentId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.example.myservice.model.Locality");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentId</column-name><column-value><![CDATA[");
        sb.append(getParentId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
