package com.example.myservice.service.persistence;

import com.example.myservice.NoSuchLocalityException;
import com.example.myservice.model.Locality;
import com.example.myservice.model.impl.LocalityImpl;
import com.example.myservice.model.impl.LocalityModelImpl;
import com.example.myservice.service.persistence.LocalityPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the locality service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hamid
 * @see LocalityPersistence
 * @see LocalityUtil
 * @generated
 */
public class LocalityPersistenceImpl extends BasePersistenceImpl<Locality>
    implements LocalityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LocalityUtil} to access the locality persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LocalityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityModelImpl.FINDER_CACHE_ENABLED, LocalityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityModelImpl.FINDER_CACHE_ENABLED, LocalityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityModelImpl.FINDER_CACHE_ENABLED, LocalityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityModelImpl.FINDER_CACHE_ENABLED, LocalityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
            new String[] { String.class.getName() },
            LocalityModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "locality.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "locality.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(locality.name IS NULL OR locality.name = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityModelImpl.FINDER_CACHE_ENABLED, LocalityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
        new FinderPath(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityModelImpl.FINDER_CACHE_ENABLED, LocalityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
            new String[] { Long.class.getName() },
            LocalityModelImpl.PARENTID_COLUMN_BITMASK |
            LocalityModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "locality.parentId = ?";
    private static final String _SQL_SELECT_LOCALITY = "SELECT locality FROM Locality locality";
    private static final String _SQL_SELECT_LOCALITY_WHERE = "SELECT locality FROM Locality locality WHERE ";
    private static final String _SQL_COUNT_LOCALITY = "SELECT COUNT(locality) FROM Locality locality";
    private static final String _SQL_COUNT_LOCALITY_WHERE = "SELECT COUNT(locality) FROM Locality locality WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "locality.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Locality exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Locality exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LocalityPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static Locality _nullLocality = new LocalityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Locality> toCacheModel() {
                return _nullLocalityCacheModel;
            }
        };

    private static CacheModel<Locality> _nullLocalityCacheModel = new CacheModel<Locality>() {
            @Override
            public Locality toEntityModel() {
                return _nullLocality;
            }
        };

    public LocalityPersistenceImpl() {
        setModelClass(Locality.class);
    }

    /**
     * Returns all the localities where name = &#63;.
     *
     * @param name the name
     * @return the matching localities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Locality> findByName(String name) throws SystemException {
        return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Locality> findByName(String name, int start, int end)
        throws SystemException {
        return findByName(name, start, end, null);
    }

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
    @Override
    public List<Locality> findByName(String name, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name, start, end, orderByComparator };
        }

        List<Locality> list = (List<Locality>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Locality locality : list) {
                if (!Validator.equals(name, locality.getName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LOCALITY_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LocalityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                if (!pagination) {
                    list = (List<Locality>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Locality>(list);
                } else {
                    list = (List<Locality>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first locality in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching locality
     * @throws com.example.myservice.NoSuchLocalityException if a matching locality could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality findByName_First(String name,
        OrderByComparator orderByComparator)
        throws NoSuchLocalityException, SystemException {
        Locality locality = fetchByName_First(name, orderByComparator);

        if (locality != null) {
            return locality;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLocalityException(msg.toString());
    }

    /**
     * Returns the first locality in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching locality, or <code>null</code> if a matching locality could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality fetchByName_First(String name,
        OrderByComparator orderByComparator) throws SystemException {
        List<Locality> list = findByName(name, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last locality in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching locality
     * @throws com.example.myservice.NoSuchLocalityException if a matching locality could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality findByName_Last(String name,
        OrderByComparator orderByComparator)
        throws NoSuchLocalityException, SystemException {
        Locality locality = fetchByName_Last(name, orderByComparator);

        if (locality != null) {
            return locality;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLocalityException(msg.toString());
    }

    /**
     * Returns the last locality in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching locality, or <code>null</code> if a matching locality could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality fetchByName_Last(String name,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByName(name);

        if (count == 0) {
            return null;
        }

        List<Locality> list = findByName(name, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Locality[] findByName_PrevAndNext(long id, String name,
        OrderByComparator orderByComparator)
        throws NoSuchLocalityException, SystemException {
        Locality locality = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Locality[] array = new LocalityImpl[3];

            array[0] = getByName_PrevAndNext(session, locality, name,
                    orderByComparator, true);

            array[1] = locality;

            array[2] = getByName_PrevAndNext(session, locality, name,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Locality getByName_PrevAndNext(Session session,
        Locality locality, String name, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOCALITY_WHERE);

        boolean bindName = false;

        if (name == null) {
            query.append(_FINDER_COLUMN_NAME_NAME_1);
        } else if (name.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_NAME_NAME_3);
        } else {
            bindName = true;

            query.append(_FINDER_COLUMN_NAME_NAME_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(LocalityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindName) {
            qPos.add(name);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(locality);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Locality> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the localities where name = &#63; from the database.
     *
     * @param name the name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByName(String name) throws SystemException {
        for (Locality locality : findByName(name, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(locality);
        }
    }

    /**
     * Returns the number of localities where name = &#63;.
     *
     * @param name the name
     * @return the number of matching localities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByName(String name) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

        Object[] finderArgs = new Object[] { name };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOCALITY_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the localities where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @return the matching localities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Locality> findByParentId(long parentId)
        throws SystemException {
        return findByParentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

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
    @Override
    public List<Locality> findByParentId(long parentId, int start, int end)
        throws SystemException {
        return findByParentId(parentId, start, end, null);
    }

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
    @Override
    public List<Locality> findByParentId(long parentId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
            finderArgs = new Object[] { parentId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
            finderArgs = new Object[] { parentId, start, end, orderByComparator };
        }

        List<Locality> list = (List<Locality>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Locality locality : list) {
                if ((parentId != locality.getParentId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LOCALITY_WHERE);

            query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LocalityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parentId);

                if (!pagination) {
                    list = (List<Locality>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Locality>(list);
                } else {
                    list = (List<Locality>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first locality in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching locality
     * @throws com.example.myservice.NoSuchLocalityException if a matching locality could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality findByParentId_First(long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchLocalityException, SystemException {
        Locality locality = fetchByParentId_First(parentId, orderByComparator);

        if (locality != null) {
            return locality;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLocalityException(msg.toString());
    }

    /**
     * Returns the first locality in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching locality, or <code>null</code> if a matching locality could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality fetchByParentId_First(long parentId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Locality> list = findByParentId(parentId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last locality in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching locality
     * @throws com.example.myservice.NoSuchLocalityException if a matching locality could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality findByParentId_Last(long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchLocalityException, SystemException {
        Locality locality = fetchByParentId_Last(parentId, orderByComparator);

        if (locality != null) {
            return locality;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLocalityException(msg.toString());
    }

    /**
     * Returns the last locality in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching locality, or <code>null</code> if a matching locality could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality fetchByParentId_Last(long parentId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByParentId(parentId);

        if (count == 0) {
            return null;
        }

        List<Locality> list = findByParentId(parentId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Locality[] findByParentId_PrevAndNext(long id, long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchLocalityException, SystemException {
        Locality locality = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Locality[] array = new LocalityImpl[3];

            array[0] = getByParentId_PrevAndNext(session, locality, parentId,
                    orderByComparator, true);

            array[1] = locality;

            array[2] = getByParentId_PrevAndNext(session, locality, parentId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Locality getByParentId_PrevAndNext(Session session,
        Locality locality, long parentId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOCALITY_WHERE);

        query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(LocalityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(parentId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(locality);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Locality> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the localities where parentId = &#63; from the database.
     *
     * @param parentId the parent ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByParentId(long parentId) throws SystemException {
        for (Locality locality : findByParentId(parentId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(locality);
        }
    }

    /**
     * Returns the number of localities where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @return the number of matching localities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByParentId(long parentId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTID;

        Object[] finderArgs = new Object[] { parentId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOCALITY_WHERE);

            query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parentId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the locality in the entity cache if it is enabled.
     *
     * @param locality the locality
     */
    @Override
    public void cacheResult(Locality locality) {
        EntityCacheUtil.putResult(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityImpl.class, locality.getPrimaryKey(), locality);

        locality.resetOriginalValues();
    }

    /**
     * Caches the localities in the entity cache if it is enabled.
     *
     * @param localities the localities
     */
    @Override
    public void cacheResult(List<Locality> localities) {
        for (Locality locality : localities) {
            if (EntityCacheUtil.getResult(
                        LocalityModelImpl.ENTITY_CACHE_ENABLED,
                        LocalityImpl.class, locality.getPrimaryKey()) == null) {
                cacheResult(locality);
            } else {
                locality.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all localities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LocalityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LocalityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the locality.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Locality locality) {
        EntityCacheUtil.removeResult(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityImpl.class, locality.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Locality> localities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Locality locality : localities) {
            EntityCacheUtil.removeResult(LocalityModelImpl.ENTITY_CACHE_ENABLED,
                LocalityImpl.class, locality.getPrimaryKey());
        }
    }

    /**
     * Creates a new locality with the primary key. Does not add the locality to the database.
     *
     * @param id the primary key for the new locality
     * @return the new locality
     */
    @Override
    public Locality create(long id) {
        Locality locality = new LocalityImpl();

        locality.setNew(true);
        locality.setPrimaryKey(id);

        return locality;
    }

    /**
     * Removes the locality with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the locality
     * @return the locality that was removed
     * @throws com.example.myservice.NoSuchLocalityException if a locality with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality remove(long id)
        throws NoSuchLocalityException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the locality with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the locality
     * @return the locality that was removed
     * @throws com.example.myservice.NoSuchLocalityException if a locality with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality remove(Serializable primaryKey)
        throws NoSuchLocalityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Locality locality = (Locality) session.get(LocalityImpl.class,
                    primaryKey);

            if (locality == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLocalityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(locality);
        } catch (NoSuchLocalityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Locality removeImpl(Locality locality) throws SystemException {
        locality = toUnwrappedModel(locality);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(locality)) {
                locality = (Locality) session.get(LocalityImpl.class,
                        locality.getPrimaryKeyObj());
            }

            if (locality != null) {
                session.delete(locality);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (locality != null) {
            clearCache(locality);
        }

        return locality;
    }

    @Override
    public Locality updateImpl(com.example.myservice.model.Locality locality)
        throws SystemException {
        locality = toUnwrappedModel(locality);

        boolean isNew = locality.isNew();

        LocalityModelImpl localityModelImpl = (LocalityModelImpl) locality;

        Session session = null;

        try {
            session = openSession();

            if (locality.isNew()) {
                session.save(locality);

                locality.setNew(false);
            } else {
                session.merge(locality);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LocalityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((localityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { localityModelImpl.getOriginalName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);

                args = new Object[] { localityModelImpl.getName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);
            }

            if ((localityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        localityModelImpl.getOriginalParentId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
                    args);

                args = new Object[] { localityModelImpl.getParentId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LocalityModelImpl.ENTITY_CACHE_ENABLED,
            LocalityImpl.class, locality.getPrimaryKey(), locality);

        return locality;
    }

    protected Locality toUnwrappedModel(Locality locality) {
        if (locality instanceof LocalityImpl) {
            return locality;
        }

        LocalityImpl localityImpl = new LocalityImpl();

        localityImpl.setNew(locality.isNew());
        localityImpl.setPrimaryKey(locality.getPrimaryKey());

        localityImpl.setId(locality.getId());
        localityImpl.setName(locality.getName());
        localityImpl.setParentId(locality.getParentId());

        return localityImpl;
    }

    /**
     * Returns the locality with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the locality
     * @return the locality
     * @throws com.example.myservice.NoSuchLocalityException if a locality with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLocalityException, SystemException {
        Locality locality = fetchByPrimaryKey(primaryKey);

        if (locality == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLocalityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return locality;
    }

    /**
     * Returns the locality with the primary key or throws a {@link com.example.myservice.NoSuchLocalityException} if it could not be found.
     *
     * @param id the primary key of the locality
     * @return the locality
     * @throws com.example.myservice.NoSuchLocalityException if a locality with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality findByPrimaryKey(long id)
        throws NoSuchLocalityException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the locality with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the locality
     * @return the locality, or <code>null</code> if a locality with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Locality locality = (Locality) EntityCacheUtil.getResult(LocalityModelImpl.ENTITY_CACHE_ENABLED,
                LocalityImpl.class, primaryKey);

        if (locality == _nullLocality) {
            return null;
        }

        if (locality == null) {
            Session session = null;

            try {
                session = openSession();

                locality = (Locality) session.get(LocalityImpl.class, primaryKey);

                if (locality != null) {
                    cacheResult(locality);
                } else {
                    EntityCacheUtil.putResult(LocalityModelImpl.ENTITY_CACHE_ENABLED,
                        LocalityImpl.class, primaryKey, _nullLocality);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LocalityModelImpl.ENTITY_CACHE_ENABLED,
                    LocalityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return locality;
    }

    /**
     * Returns the locality with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the locality
     * @return the locality, or <code>null</code> if a locality with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Locality fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the localities.
     *
     * @return the localities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Locality> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Locality> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Locality> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Locality> list = (List<Locality>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LOCALITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LOCALITY;

                if (pagination) {
                    sql = sql.concat(LocalityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Locality>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Locality>(list);
                } else {
                    list = (List<Locality>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the localities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Locality locality : findAll()) {
            remove(locality);
        }
    }

    /**
     * Returns the number of localities.
     *
     * @return the number of localities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LOCALITY);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the locality persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.example.myservice.model.Locality")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Locality>> listenersList = new ArrayList<ModelListener<Locality>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Locality>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LocalityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
