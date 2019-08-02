package com.example.myservice.model;

import com.example.myservice.service.ClpSerializer;
import com.example.myservice.service.VacancyLocalServiceUtil;

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


public class VacancyClp extends BaseModelImpl<Vacancy> implements Vacancy {
    private long _id;
    private String _name;
    private String _publishedAt;
    private String _employer;
    private String _salary;
    private String _address;
    private BaseModel<?> _vacancyRemoteModel;

    public VacancyClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Vacancy.class;
    }

    @Override
    public String getModelClassName() {
        return Vacancy.class.getName();
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
        attributes.put("publishedAt", getPublishedAt());
        attributes.put("employer", getEmployer());
        attributes.put("salary", getSalary());
        attributes.put("address", getAddress());

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

        String publishedAt = (String) attributes.get("publishedAt");

        if (publishedAt != null) {
            setPublishedAt(publishedAt);
        }

        String employer = (String) attributes.get("employer");

        if (employer != null) {
            setEmployer(employer);
        }

        String salary = (String) attributes.get("salary");

        if (salary != null) {
            setSalary(salary);
        }

        String address = (String) attributes.get("address");

        if (address != null) {
            setAddress(address);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_vacancyRemoteModel != null) {
            try {
                Class<?> clazz = _vacancyRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_vacancyRemoteModel, id);
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

        if (_vacancyRemoteModel != null) {
            try {
                Class<?> clazz = _vacancyRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_vacancyRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPublishedAt() {
        return _publishedAt;
    }

    @Override
    public void setPublishedAt(String publishedAt) {
        _publishedAt = publishedAt;

        if (_vacancyRemoteModel != null) {
            try {
                Class<?> clazz = _vacancyRemoteModel.getClass();

                Method method = clazz.getMethod("setPublishedAt", String.class);

                method.invoke(_vacancyRemoteModel, publishedAt);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmployer() {
        return _employer;
    }

    @Override
    public void setEmployer(String employer) {
        _employer = employer;

        if (_vacancyRemoteModel != null) {
            try {
                Class<?> clazz = _vacancyRemoteModel.getClass();

                Method method = clazz.getMethod("setEmployer", String.class);

                method.invoke(_vacancyRemoteModel, employer);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSalary() {
        return _salary;
    }

    @Override
    public void setSalary(String salary) {
        _salary = salary;

        if (_vacancyRemoteModel != null) {
            try {
                Class<?> clazz = _vacancyRemoteModel.getClass();

                Method method = clazz.getMethod("setSalary", String.class);

                method.invoke(_vacancyRemoteModel, salary);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAddress() {
        return _address;
    }

    @Override
    public void setAddress(String address) {
        _address = address;

        if (_vacancyRemoteModel != null) {
            try {
                Class<?> clazz = _vacancyRemoteModel.getClass();

                Method method = clazz.getMethod("setAddress", String.class);

                method.invoke(_vacancyRemoteModel, address);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getVacancyRemoteModel() {
        return _vacancyRemoteModel;
    }

    public void setVacancyRemoteModel(BaseModel<?> vacancyRemoteModel) {
        _vacancyRemoteModel = vacancyRemoteModel;
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

        Class<?> remoteModelClass = _vacancyRemoteModel.getClass();

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

        Object returnValue = method.invoke(_vacancyRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            VacancyLocalServiceUtil.addVacancy(this);
        } else {
            VacancyLocalServiceUtil.updateVacancy(this);
        }
    }

    @Override
    public Vacancy toEscapedModel() {
        return (Vacancy) ProxyUtil.newProxyInstance(Vacancy.class.getClassLoader(),
            new Class[] { Vacancy.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        VacancyClp clone = new VacancyClp();

        clone.setId(getId());
        clone.setName(getName());
        clone.setPublishedAt(getPublishedAt());
        clone.setEmployer(getEmployer());
        clone.setSalary(getSalary());
        clone.setAddress(getAddress());

        return clone;
    }

    @Override
    public int compareTo(Vacancy vacancy) {
        long primaryKey = vacancy.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof VacancyClp)) {
            return false;
        }

        VacancyClp vacancy = (VacancyClp) obj;

        long primaryKey = vacancy.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", publishedAt=");
        sb.append(getPublishedAt());
        sb.append(", employer=");
        sb.append(getEmployer());
        sb.append(", salary=");
        sb.append(getSalary());
        sb.append(", address=");
        sb.append(getAddress());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.example.myservice.model.Vacancy");
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
            "<column><column-name>publishedAt</column-name><column-value><![CDATA[");
        sb.append(getPublishedAt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>employer</column-name><column-value><![CDATA[");
        sb.append(getEmployer());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>salary</column-name><column-value><![CDATA[");
        sb.append(getSalary());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>address</column-name><column-value><![CDATA[");
        sb.append(getAddress());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
