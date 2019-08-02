package com.example.myservice.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Locality. This utility wraps
 * {@link com.example.myservice.service.impl.LocalityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author hamid
 * @see LocalityLocalService
 * @see com.example.myservice.service.base.LocalityLocalServiceBaseImpl
 * @see com.example.myservice.service.impl.LocalityLocalServiceImpl
 * @generated
 */
public class LocalityLocalServiceUtil {
    private static LocalityLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.example.myservice.service.impl.LocalityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the locality to the database. Also notifies the appropriate model listeners.
    *
    * @param locality the locality
    * @return the locality that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Locality addLocality(
        com.example.myservice.model.Locality locality)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLocality(locality);
    }

    /**
    * Creates a new locality with the primary key. Does not add the locality to the database.
    *
    * @param id the primary key for the new locality
    * @return the new locality
    */
    public static com.example.myservice.model.Locality createLocality(long id) {
        return getService().createLocality(id);
    }

    /**
    * Deletes the locality with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the locality
    * @return the locality that was removed
    * @throws PortalException if a locality with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Locality deleteLocality(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLocality(id);
    }

    /**
    * Deletes the locality from the database. Also notifies the appropriate model listeners.
    *
    * @param locality the locality
    * @return the locality that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Locality deleteLocality(
        com.example.myservice.model.Locality locality)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLocality(locality);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.example.myservice.model.Locality fetchLocality(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLocality(id);
    }

    /**
    * Returns the locality with the primary key.
    *
    * @param id the primary key of the locality
    * @return the locality
    * @throws PortalException if a locality with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Locality getLocality(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLocality(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.example.myservice.model.Locality> getLocalities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLocalities(start, end);
    }

    /**
    * Returns the number of localities.
    *
    * @return the number of localities
    * @throws SystemException if a system exception occurred
    */
    public static int getLocalitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLocalitiesCount();
    }

    /**
    * Updates the locality in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param locality the locality
    * @return the locality that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Locality updateLocality(
        com.example.myservice.model.Locality locality)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLocality(locality);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void addOrUpdate(
        com.example.myservice.model.Locality locality)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addOrUpdate(locality);
    }

    public static java.util.List<com.example.myservice.model.Locality> getLocalitiesForParentId(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLocalitiesForParentId(id);
    }

    public static java.util.List<com.example.myservice.model.Locality> getLocalityForName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLocalityForName(name);
    }

    public static void clearService() {
        _service = null;
    }

    public static LocalityLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LocalityLocalService.class.getName());

            if (invokableLocalService instanceof LocalityLocalService) {
                _service = (LocalityLocalService) invokableLocalService;
            } else {
                _service = new LocalityLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LocalityLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LocalityLocalService service) {
    }
}
