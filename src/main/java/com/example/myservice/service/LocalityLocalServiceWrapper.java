package com.example.myservice.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LocalityLocalService}.
 *
 * @author hamid
 * @see LocalityLocalService
 * @generated
 */
public class LocalityLocalServiceWrapper implements LocalityLocalService,
    ServiceWrapper<LocalityLocalService> {
    private LocalityLocalService _localityLocalService;

    public LocalityLocalServiceWrapper(
        LocalityLocalService localityLocalService) {
        _localityLocalService = localityLocalService;
    }

    /**
    * Adds the locality to the database. Also notifies the appropriate model listeners.
    *
    * @param locality the locality
    * @return the locality that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.myservice.model.Locality addLocality(
        com.example.myservice.model.Locality locality)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.addLocality(locality);
    }

    /**
    * Creates a new locality with the primary key. Does not add the locality to the database.
    *
    * @param id the primary key for the new locality
    * @return the new locality
    */
    @Override
    public com.example.myservice.model.Locality createLocality(long id) {
        return _localityLocalService.createLocality(id);
    }

    /**
    * Deletes the locality with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the locality
    * @return the locality that was removed
    * @throws PortalException if a locality with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.myservice.model.Locality deleteLocality(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.deleteLocality(id);
    }

    /**
    * Deletes the locality from the database. Also notifies the appropriate model listeners.
    *
    * @param locality the locality
    * @return the locality that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.myservice.model.Locality deleteLocality(
        com.example.myservice.model.Locality locality)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.deleteLocality(locality);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _localityLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.LocalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.LocalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.example.myservice.model.Locality fetchLocality(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.fetchLocality(id);
    }

    /**
    * Returns the locality with the primary key.
    *
    * @param id the primary key of the locality
    * @return the locality
    * @throws PortalException if a locality with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.myservice.model.Locality getLocality(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.getLocality(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the localities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.LocalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of localities
    * @param end the upper bound of the range of localities (not inclusive)
    * @return the range of localities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.example.myservice.model.Locality> getLocalities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.getLocalities(start, end);
    }

    /**
    * Returns the number of localities.
    *
    * @return the number of localities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLocalitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.getLocalitiesCount();
    }

    /**
    * Updates the locality in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param locality the locality
    * @return the locality that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.myservice.model.Locality updateLocality(
        com.example.myservice.model.Locality locality)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.updateLocality(locality);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _localityLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _localityLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _localityLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void addOrUpdate(com.example.myservice.model.Locality locality)
        throws com.liferay.portal.kernel.exception.SystemException {
        _localityLocalService.addOrUpdate(locality);
    }

    @Override
    public java.util.List<com.example.myservice.model.Locality> getLocalitiesForParentId(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.getLocalitiesForParentId(id);
    }

    @Override
    public java.util.List<com.example.myservice.model.Locality> getLocalityForName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _localityLocalService.getLocalityForName(name);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LocalityLocalService getWrappedLocalityLocalService() {
        return _localityLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLocalityLocalService(
        LocalityLocalService localityLocalService) {
        _localityLocalService = localityLocalService;
    }

    @Override
    public LocalityLocalService getWrappedService() {
        return _localityLocalService;
    }

    @Override
    public void setWrappedService(LocalityLocalService localityLocalService) {
        _localityLocalService = localityLocalService;
    }
}
