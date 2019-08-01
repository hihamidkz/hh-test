package com.example.myservice.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Locality}.
 * </p>
 *
 * @author hamid
 * @see Locality
 * @generated
 */
public class LocalityWrapper implements Locality, ModelWrapper<Locality> {
    private Locality _locality;

    public LocalityWrapper(Locality locality) {
        _locality = locality;
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

    /**
    * Returns the primary key of this locality.
    *
    * @return the primary key of this locality
    */
    @Override
    public long getPrimaryKey() {
        return _locality.getPrimaryKey();
    }

    /**
    * Sets the primary key of this locality.
    *
    * @param primaryKey the primary key of this locality
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _locality.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this locality.
    *
    * @return the ID of this locality
    */
    @Override
    public long getId() {
        return _locality.getId();
    }

    /**
    * Sets the ID of this locality.
    *
    * @param id the ID of this locality
    */
    @Override
    public void setId(long id) {
        _locality.setId(id);
    }

    /**
    * Returns the name of this locality.
    *
    * @return the name of this locality
    */
    @Override
    public java.lang.String getName() {
        return _locality.getName();
    }

    /**
    * Sets the name of this locality.
    *
    * @param name the name of this locality
    */
    @Override
    public void setName(java.lang.String name) {
        _locality.setName(name);
    }

    /**
    * Returns the parent ID of this locality.
    *
    * @return the parent ID of this locality
    */
    @Override
    public long getParentId() {
        return _locality.getParentId();
    }

    /**
    * Sets the parent ID of this locality.
    *
    * @param parentId the parent ID of this locality
    */
    @Override
    public void setParentId(long parentId) {
        _locality.setParentId(parentId);
    }

    @Override
    public boolean isNew() {
        return _locality.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _locality.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _locality.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _locality.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _locality.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _locality.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _locality.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _locality.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _locality.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _locality.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _locality.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LocalityWrapper((Locality) _locality.clone());
    }

    @Override
    public int compareTo(com.example.myservice.model.Locality locality) {
        return _locality.compareTo(locality);
    }

    @Override
    public int hashCode() {
        return _locality.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.example.myservice.model.Locality> toCacheModel() {
        return _locality.toCacheModel();
    }

    @Override
    public com.example.myservice.model.Locality toEscapedModel() {
        return new LocalityWrapper(_locality.toEscapedModel());
    }

    @Override
    public com.example.myservice.model.Locality toUnescapedModel() {
        return new LocalityWrapper(_locality.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _locality.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _locality.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _locality.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LocalityWrapper)) {
            return false;
        }

        LocalityWrapper localityWrapper = (LocalityWrapper) obj;

        if (Validator.equals(_locality, localityWrapper._locality)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Locality getWrappedLocality() {
        return _locality;
    }

    @Override
    public Locality getWrappedModel() {
        return _locality;
    }

    @Override
    public void resetOriginalValues() {
        _locality.resetOriginalValues();
    }
}
