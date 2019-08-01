package com.example.myservice.service.persistence;

import com.example.myservice.model.Region;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the region service. This utility wraps {@link RegionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hamid
 * @see RegionPersistence
 * @see RegionPersistenceImpl
 * @generated
 */
public class RegionUtil {
    private static RegionPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Region region) {
        getPersistence().clearCache(region);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Region update(Region region) throws SystemException {
        return getPersistence().update(region);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Region update(Region region, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(region, serviceContext);
    }

    /**
    * Returns all the regions where name = &#63;.
    *
    * @param name the name
    * @return the matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Region> findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByName(name);
    }

    /**
    * Returns a range of all the regions where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Region> findByName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByName(name, start, end);
    }

    /**
    * Returns an ordered range of all the regions where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Region> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByName(name, start, end, orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region
    * @throws com.example.myservice.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region findByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByName_First(name, orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region fetchByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName_First(name, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region
    * @throws com.example.myservice.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region findByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByName_Last(name, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region fetchByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName_Last(name, orderByComparator);
    }

    /**
    * Returns the regions before and after the current region in the ordered set where name = &#63;.
    *
    * @param id the primary key of the current region
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next region
    * @throws com.example.myservice.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region[] findByName_PrevAndNext(
        long id, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByName_PrevAndNext(id, name, orderByComparator);
    }

    /**
    * Removes all the regions where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByName(name);
    }

    /**
    * Returns the number of regions where name = &#63;.
    *
    * @param name the name
    * @return the number of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByName(name);
    }

    /**
    * Returns all the regions where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Region> findByParentId(
        long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentId(parentId);
    }

    /**
    * Returns a range of all the regions where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Region> findByParentId(
        long parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentId(parentId, start, end);
    }

    /**
    * Returns an ordered range of all the regions where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Region> findByParentId(
        long parentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByParentId(parentId, start, end, orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region
    * @throws com.example.myservice.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region findByParentId_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentId_First(parentId, orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region fetchByParentId_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByParentId_First(parentId, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region
    * @throws com.example.myservice.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region findByParentId_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentId_Last(parentId, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region fetchByParentId_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByParentId_Last(parentId, orderByComparator);
    }

    /**
    * Returns the regions before and after the current region in the ordered set where parentId = &#63;.
    *
    * @param id the primary key of the current region
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next region
    * @throws com.example.myservice.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region[] findByParentId_PrevAndNext(
        long id, long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByParentId_PrevAndNext(id, parentId, orderByComparator);
    }

    /**
    * Removes all the regions where parentId = &#63; from the database.
    *
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByParentId(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByParentId(parentId);
    }

    /**
    * Returns the number of regions where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the number of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static int countByParentId(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByParentId(parentId);
    }

    /**
    * Caches the region in the entity cache if it is enabled.
    *
    * @param region the region
    */
    public static void cacheResult(com.example.myservice.model.Region region) {
        getPersistence().cacheResult(region);
    }

    /**
    * Caches the regions in the entity cache if it is enabled.
    *
    * @param regions the regions
    */
    public static void cacheResult(
        java.util.List<com.example.myservice.model.Region> regions) {
        getPersistence().cacheResult(regions);
    }

    /**
    * Creates a new region with the primary key. Does not add the region to the database.
    *
    * @param id the primary key for the new region
    * @return the new region
    */
    public static com.example.myservice.model.Region create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the region
    * @return the region that was removed
    * @throws com.example.myservice.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region remove(long id)
        throws com.example.myservice.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.example.myservice.model.Region updateImpl(
        com.example.myservice.model.Region region)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(region);
    }

    /**
    * Returns the region with the primary key or throws a {@link com.example.myservice.NoSuchRegionException} if it could not be found.
    *
    * @param id the primary key of the region
    * @return the region
    * @throws com.example.myservice.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region findByPrimaryKey(long id)
        throws com.example.myservice.NoSuchRegionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the region with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the region
    * @return the region, or <code>null</code> if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Region fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the regions.
    *
    * @return the regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Region> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the regions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Region> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the regions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Region> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the regions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of regions.
    *
    * @return the number of regions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static RegionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RegionPersistence) PortletBeanLocatorUtil.locate(com.example.myservice.service.ClpSerializer.getServletContextName(),
                    RegionPersistence.class.getName());

            ReferenceRegistry.registerReference(RegionUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(RegionPersistence persistence) {
    }
}
