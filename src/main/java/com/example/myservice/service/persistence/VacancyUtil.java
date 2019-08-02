package com.example.myservice.service.persistence;

import com.example.myservice.model.Vacancy;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the vacancy service. This utility wraps {@link VacancyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hamid
 * @see VacancyPersistence
 * @see VacancyPersistenceImpl
 * @generated
 */
public class VacancyUtil {
    private static VacancyPersistence _persistence;

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
    public static void clearCache(Vacancy vacancy) {
        getPersistence().clearCache(vacancy);
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
    public static List<Vacancy> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Vacancy> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Vacancy> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Vacancy update(Vacancy vacancy) throws SystemException {
        return getPersistence().update(vacancy);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Vacancy update(Vacancy vacancy, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(vacancy, serviceContext);
    }

    /**
    * Caches the vacancy in the entity cache if it is enabled.
    *
    * @param vacancy the vacancy
    */
    public static void cacheResult(com.example.myservice.model.Vacancy vacancy) {
        getPersistence().cacheResult(vacancy);
    }

    /**
    * Caches the vacancies in the entity cache if it is enabled.
    *
    * @param vacancies the vacancies
    */
    public static void cacheResult(
        java.util.List<com.example.myservice.model.Vacancy> vacancies) {
        getPersistence().cacheResult(vacancies);
    }

    /**
    * Creates a new vacancy with the primary key. Does not add the vacancy to the database.
    *
    * @param id the primary key for the new vacancy
    * @return the new vacancy
    */
    public static com.example.myservice.model.Vacancy create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the vacancy with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the vacancy
    * @return the vacancy that was removed
    * @throws com.example.myservice.NoSuchVacancyException if a vacancy with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Vacancy remove(long id)
        throws com.example.myservice.NoSuchVacancyException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.example.myservice.model.Vacancy updateImpl(
        com.example.myservice.model.Vacancy vacancy)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(vacancy);
    }

    /**
    * Returns the vacancy with the primary key or throws a {@link com.example.myservice.NoSuchVacancyException} if it could not be found.
    *
    * @param id the primary key of the vacancy
    * @return the vacancy
    * @throws com.example.myservice.NoSuchVacancyException if a vacancy with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Vacancy findByPrimaryKey(long id)
        throws com.example.myservice.NoSuchVacancyException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the vacancy with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the vacancy
    * @return the vacancy, or <code>null</code> if a vacancy with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.example.myservice.model.Vacancy fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the vacancies.
    *
    * @return the vacancies
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Vacancy> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the vacancies.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.VacancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of vacancies
    * @param end the upper bound of the range of vacancies (not inclusive)
    * @return the range of vacancies
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Vacancy> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the vacancies.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.myservice.model.impl.VacancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of vacancies
    * @param end the upper bound of the range of vacancies (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of vacancies
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.example.myservice.model.Vacancy> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the vacancies from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of vacancies.
    *
    * @return the number of vacancies
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static VacancyPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (VacancyPersistence) PortletBeanLocatorUtil.locate(com.example.myservice.service.ClpSerializer.getServletContextName(),
                    VacancyPersistence.class.getName());

            ReferenceRegistry.registerReference(VacancyUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(VacancyPersistence persistence) {
    }
}
