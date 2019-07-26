package com.example.myservice.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Vacancy}.
 * </p>
 *
 * @author hamid
 * @see Vacancy
 * @generated
 */
public class VacancyWrapper implements Vacancy, ModelWrapper<Vacancy> {
    private Vacancy _vacancy;

    public VacancyWrapper(Vacancy vacancy) {
        _vacancy = vacancy;
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

    /**
    * Returns the primary key of this vacancy.
    *
    * @return the primary key of this vacancy
    */
    @Override
    public long getPrimaryKey() {
        return _vacancy.getPrimaryKey();
    }

    /**
    * Sets the primary key of this vacancy.
    *
    * @param primaryKey the primary key of this vacancy
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _vacancy.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this vacancy.
    *
    * @return the ID of this vacancy
    */
    @Override
    public long getId() {
        return _vacancy.getId();
    }

    /**
    * Sets the ID of this vacancy.
    *
    * @param id the ID of this vacancy
    */
    @Override
    public void setId(long id) {
        _vacancy.setId(id);
    }

    /**
    * Returns the name of this vacancy.
    *
    * @return the name of this vacancy
    */
    @Override
    public java.lang.String getName() {
        return _vacancy.getName();
    }

    /**
    * Sets the name of this vacancy.
    *
    * @param name the name of this vacancy
    */
    @Override
    public void setName(java.lang.String name) {
        _vacancy.setName(name);
    }

    /**
    * Returns the published at of this vacancy.
    *
    * @return the published at of this vacancy
    */
    @Override
    public java.lang.String getPublishedAt() {
        return _vacancy.getPublishedAt();
    }

    /**
    * Sets the published at of this vacancy.
    *
    * @param publishedAt the published at of this vacancy
    */
    @Override
    public void setPublishedAt(java.lang.String publishedAt) {
        _vacancy.setPublishedAt(publishedAt);
    }

    /**
    * Returns the employer of this vacancy.
    *
    * @return the employer of this vacancy
    */
    @Override
    public java.lang.String getEmployer() {
        return _vacancy.getEmployer();
    }

    /**
    * Sets the employer of this vacancy.
    *
    * @param employer the employer of this vacancy
    */
    @Override
    public void setEmployer(java.lang.String employer) {
        _vacancy.setEmployer(employer);
    }

    /**
    * Returns the salary of this vacancy.
    *
    * @return the salary of this vacancy
    */
    @Override
    public java.lang.String getSalary() {
        return _vacancy.getSalary();
    }

    /**
    * Sets the salary of this vacancy.
    *
    * @param salary the salary of this vacancy
    */
    @Override
    public void setSalary(java.lang.String salary) {
        _vacancy.setSalary(salary);
    }

    /**
    * Returns the address of this vacancy.
    *
    * @return the address of this vacancy
    */
    @Override
    public java.lang.String getAddress() {
        return _vacancy.getAddress();
    }

    /**
    * Sets the address of this vacancy.
    *
    * @param address the address of this vacancy
    */
    @Override
    public void setAddress(java.lang.String address) {
        _vacancy.setAddress(address);
    }

    @Override
    public boolean isNew() {
        return _vacancy.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _vacancy.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _vacancy.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _vacancy.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _vacancy.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _vacancy.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _vacancy.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _vacancy.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _vacancy.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _vacancy.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _vacancy.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new VacancyWrapper((Vacancy) _vacancy.clone());
    }

    @Override
    public int compareTo(com.example.myservice.model.Vacancy vacancy) {
        return _vacancy.compareTo(vacancy);
    }

    @Override
    public int hashCode() {
        return _vacancy.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.example.myservice.model.Vacancy> toCacheModel() {
        return _vacancy.toCacheModel();
    }

    @Override
    public com.example.myservice.model.Vacancy toEscapedModel() {
        return new VacancyWrapper(_vacancy.toEscapedModel());
    }

    @Override
    public com.example.myservice.model.Vacancy toUnescapedModel() {
        return new VacancyWrapper(_vacancy.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _vacancy.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _vacancy.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _vacancy.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof VacancyWrapper)) {
            return false;
        }

        VacancyWrapper vacancyWrapper = (VacancyWrapper) obj;

        if (Validator.equals(_vacancy, vacancyWrapper._vacancy)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Vacancy getWrappedVacancy() {
        return _vacancy;
    }

    @Override
    public Vacancy getWrappedModel() {
        return _vacancy;
    }

    @Override
    public void resetOriginalValues() {
        _vacancy.resetOriginalValues();
    }
}
