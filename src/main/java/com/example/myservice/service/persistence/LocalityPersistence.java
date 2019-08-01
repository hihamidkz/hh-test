package com.example.myservice.service.persistence;

import com.example.myservice.model.Locality;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the locality service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hamid
 * @see LocalityPersistenceImpl
 * @see LocalityUtil
 * @generated
 */
public interface LocalityPersistence extends BasePersistence<Locality> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LocalityUtil} to access the locality persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the localities where name = &#63;.
    *
    * @param name the name
    * @return the matching localities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.myservice.model.Locality> findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the localities where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.LocalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of localities
    * @param end the upper bound of the range of localities (not inclusive)
    * @return the range of matching localities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.myservice.model.Locality> findByName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the localities where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.LocalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of localities
    * @param end the upper bound of the range of localities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching localities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.myservice.model.Locality> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first locality in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching locality
    * @throws com.example.myservice.NoSuchLocalityException if a matching locality could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality findByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchLocalityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first locality in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching locality, or <code>null</code> if a matching locality could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality fetchByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last locality in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching locality
    * @throws com.example.myservice.NoSuchLocalityException if a matching locality could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality findByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchLocalityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last locality in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching locality, or <code>null</code> if a matching locality could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality fetchByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the localities before and after the current locality in the ordered set where name = &#63;.
    *
    * @param id the primary key of the current locality
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next locality
    * @throws com.example.myservice.NoSuchLocalityException if a locality with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality[] findByName_PrevAndNext(
        long id, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchLocalityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the localities where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public void removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of localities where name = &#63;.
    *
    * @param name the name
    * @return the number of matching localities
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the localities where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the matching localities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.myservice.model.Locality> findByParentId(
        long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the localities where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.LocalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of localities
    * @param end the upper bound of the range of localities (not inclusive)
    * @return the range of matching localities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.myservice.model.Locality> findByParentId(
        long parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the localities where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.LocalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of localities
    * @param end the upper bound of the range of localities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching localities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.myservice.model.Locality> findByParentId(
        long parentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first locality in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching locality
    * @throws com.example.myservice.NoSuchLocalityException if a matching locality could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality findByParentId_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchLocalityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first locality in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching locality, or <code>null</code> if a matching locality could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality fetchByParentId_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last locality in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching locality
    * @throws com.example.myservice.NoSuchLocalityException if a matching locality could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality findByParentId_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchLocalityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last locality in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching locality, or <code>null</code> if a matching locality could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality fetchByParentId_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the localities before and after the current locality in the ordered set where parentId = &#63;.
    *
    * @param id the primary key of the current locality
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next locality
    * @throws com.example.myservice.NoSuchLocalityException if a locality with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality[] findByParentId_PrevAndNext(
        long id, long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.example.myservice.NoSuchLocalityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the localities where parentId = &#63; from the database.
    *
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByParentId(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of localities where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the number of matching localities
    * @throws SystemException if a system exception occurred
    */
    public int countByParentId(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the locality in the entity cache if it is enabled.
    *
    * @param locality the locality
    */
    public void cacheResult(com.example.myservice.model.Locality locality);

    /**
    * Caches the localities in the entity cache if it is enabled.
    *
    * @param localities the localities
    */
    public void cacheResult(
        java.util.List<com.example.myservice.model.Locality> localities);

    /**
    * Creates a new locality with the primary key. Does not add the locality to the database.
    *
    * @param id the primary key for the new locality
    * @return the new locality
    */
    public com.example.myservice.model.Locality create(long id);

    /**
    * Removes the locality with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the locality
    * @return the locality that was removed
    * @throws com.example.myservice.NoSuchLocalityException if a locality with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality remove(long id)
        throws com.example.myservice.NoSuchLocalityException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.example.myservice.model.Locality updateImpl(
        com.example.myservice.model.Locality locality)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the locality with the primary key or throws a {@link com.example.myservice.NoSuchLocalityException} if it could not be found.
    *
    * @param id the primary key of the locality
    * @return the locality
    * @throws com.example.myservice.NoSuchLocalityException if a locality with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality findByPrimaryKey(long id)
        throws com.example.myservice.NoSuchLocalityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the locality with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the locality
    * @return the locality, or <code>null</code> if a locality with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.myservice.model.Locality fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the localities.
    *
    * @return the localities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.myservice.model.Locality> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.example.myservice.model.Locality> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the localities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.LocalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of localities
    * @param end the upper bound of the range of localities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of localities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.myservice.model.Locality> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the localities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of localities.
    *
    * @return the number of localities
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
