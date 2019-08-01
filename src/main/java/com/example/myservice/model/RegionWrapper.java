package com.example.myservice.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Region}.
 * </p>
 *
 * @author hamid
 * @see Region
 * @generated
 */
public class RegionWrapper implements Region, ModelWrapper<Region> {
    private Region _region;

    public RegionWrapper(Region region) {
        _region = region;
    }

    @Override
    public Class<?> getModelClass() {
        return Region.class;
    }

    @Override
    public String getModelClassName() {
        return Region.class.getName();
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
    * Returns the primary key of this region.
    *
    * @return the primary key of this region
    */
    @Override
    public long getPrimaryKey() {
        return _region.getPrimaryKey();
    }

    /**
    * Sets the primary key of this region.
    *
    * @param primaryKey the primary key of this region
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _region.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this region.
    *
    * @return the ID of this region
    */
    @Override
    public long getId() {
        return _region.getId();
    }

    /**
    * Sets the ID of this region.
    *
    * @param id the ID of this region
    */
    @Override
    public void setId(long id) {
        _region.setId(id);
    }

    /**
    * Returns the name of this region.
    *
    * @return the name of this region
    */
    @Override
    public java.lang.String getName() {
        return _region.getName();
    }

    /**
    * Sets the name of this region.
    *
    * @param name the name of this region
    */
    @Override
    public void setName(java.lang.String name) {
        _region.setName(name);
    }

    /**
    * Returns the parent ID of this region.
    *
    * @return the parent ID of this region
    */
    @Override
    public long getParentId() {
        return _region.getParentId();
    }

    /**
    * Sets the parent ID of this region.
    *
    * @param parentId the parent ID of this region
    */
    @Override
    public void setParentId(long parentId) {
        _region.setParentId(parentId);
    }

    @Override
    public boolean isNew() {
        return _region.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _region.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _region.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _region.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _region.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _region.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _region.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _region.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _region.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _region.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _region.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new RegionWrapper((Region) _region.clone());
    }

    @Override
    public int compareTo(com.example.myservice.model.Region region) {
        return _region.compareTo(region);
    }

    @Override
    public int hashCode() {
        return _region.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.example.myservice.model.Region> toCacheModel() {
        return _region.toCacheModel();
    }

    @Override
    public com.example.myservice.model.Region toEscapedModel() {
        return new RegionWrapper(_region.toEscapedModel());
    }

    @Override
    public com.example.myservice.model.Region toUnescapedModel() {
        return new RegionWrapper(_region.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _region.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _region.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _region.persist();
    }

    @Override
    public java.util.List<com.example.myservice.model.Locality> getLocalities()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _region.getLocalities();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RegionWrapper)) {
            return false;
        }

        RegionWrapper regionWrapper = (RegionWrapper) obj;

        if (Validator.equals(_region, regionWrapper._region)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Region getWrappedRegion() {
        return _region;
    }

    @Override
    public Region getWrappedModel() {
        return _region;
    }

    @Override
    public void resetOriginalValues() {
        _region.resetOriginalValues();
    }
}
