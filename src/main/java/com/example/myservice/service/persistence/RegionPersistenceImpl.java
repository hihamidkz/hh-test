package com.example.myservice.service.persistence;

import com.example.myservice.NoSuchRegionException;
import com.example.myservice.model.Region;
import com.example.myservice.model.impl.RegionImpl;
import com.example.myservice.model.impl.RegionModelImpl;
import com.example.myservice.service.persistence.RegionPersistence;

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
 * The persistence implementation for the region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hamid
 * @see RegionPersistence
 * @see RegionUtil
 * @generated
 */
public class RegionPersistenceImpl extends BasePersistenceImpl<Region>
    implements RegionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RegionUtil} to access the region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RegionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
            new String[] { String.class.getName() },
            RegionModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "region.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "region.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(region.name IS NULL OR region.name = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
        new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
            new String[] { Long.class.getName() },
            RegionModelImpl.PARENTID_COLUMN_BITMASK |
            RegionModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "region.parentId = ?";
    private static final String _SQL_SELECT_REGION = "SELECT region FROM Region region";
    private static final String _SQL_SELECT_REGION_WHERE = "SELECT region FROM Region region WHERE ";
    private static final String _SQL_COUNT_REGION = "SELECT COUNT(region) FROM Region region";
    private static final String _SQL_COUNT_REGION_WHERE = "SELECT COUNT(region) FROM Region region WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "region.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Region exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Region exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RegionPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static Region _nullRegion = new RegionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Region> toCacheModel() {
                return _nullRegionCacheModel;
            }
        };

    private static CacheModel<Region> _nullRegionCacheModel = new CacheModel<Region>() {
            @Override
            public Region toEntityModel() {
                return _nullRegion;
            }
        };

    public RegionPersistenceImpl() {
        setModelClass(Region.class);
    }

    /**
     * Returns all the regions where name = &#63;.
     *
     * @param name the name
     * @return the matching regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Region> findByName(String name) throws SystemException {
        return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Region> findByName(String name, int start, int end)
        throws SystemException {
        return findByName(name, start, end, null);
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
    @Override
    public List<Region> findByName(String name, int start, int end,
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

        List<Region> list = (List<Region>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Region region : list) {
                if (!Validator.equals(name, region.getName())) {
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

            query.append(_SQL_SELECT_REGION_WHERE);

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
                query.append(RegionModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Region>(list);
                } else {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
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
     * Returns the first region in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region
     * @throws com.example.myservice.NoSuchRegionException if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region findByName_First(String name,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByName_First(name, orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the first region in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByName_First(String name,
        OrderByComparator orderByComparator) throws SystemException {
        List<Region> list = findByName(name, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Region findByName_Last(String name,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByName_Last(name, orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the last region in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByName_Last(String name,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByName(name);

        if (count == 0) {
            return null;
        }

        List<Region> list = findByName(name, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Region[] findByName_PrevAndNext(long id, String name,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Region[] array = new RegionImpl[3];

            array[0] = getByName_PrevAndNext(session, region, name,
                    orderByComparator, true);

            array[1] = region;

            array[2] = getByName_PrevAndNext(session, region, name,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Region getByName_PrevAndNext(Session session, Region region,
        String name, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REGION_WHERE);

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
            query.append(RegionModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(region);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Region> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the regions where name = &#63; from the database.
     *
     * @param name the name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByName(String name) throws SystemException {
        for (Region region : findByName(name, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(region);
        }
    }

    /**
     * Returns the number of regions where name = &#63;.
     *
     * @param name the name
     * @return the number of matching regions
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

            query.append(_SQL_COUNT_REGION_WHERE);

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
     * Returns all the regions where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @return the matching regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Region> findByParentId(long parentId) throws SystemException {
        return findByParentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Region> findByParentId(long parentId, int start, int end)
        throws SystemException {
        return findByParentId(parentId, start, end, null);
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
    @Override
    public List<Region> findByParentId(long parentId, int start, int end,
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

        List<Region> list = (List<Region>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Region region : list) {
                if ((parentId != region.getParentId())) {
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

            query.append(_SQL_SELECT_REGION_WHERE);

            query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RegionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parentId);

                if (!pagination) {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Region>(list);
                } else {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
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
     * Returns the first region in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region
     * @throws com.example.myservice.NoSuchRegionException if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region findByParentId_First(long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByParentId_First(parentId, orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the first region in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByParentId_First(long parentId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Region> list = findByParentId(parentId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Region findByParentId_Last(long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByParentId_Last(parentId, orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the last region in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByParentId_Last(long parentId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByParentId(parentId);

        if (count == 0) {
            return null;
        }

        List<Region> list = findByParentId(parentId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Region[] findByParentId_PrevAndNext(long id, long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Region[] array = new RegionImpl[3];

            array[0] = getByParentId_PrevAndNext(session, region, parentId,
                    orderByComparator, true);

            array[1] = region;

            array[2] = getByParentId_PrevAndNext(session, region, parentId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Region getByParentId_PrevAndNext(Session session, Region region,
        long parentId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REGION_WHERE);

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
            query.append(RegionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(parentId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(region);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Region> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the regions where parentId = &#63; from the database.
     *
     * @param parentId the parent ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByParentId(long parentId) throws SystemException {
        for (Region region : findByParentId(parentId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(region);
        }
    }

    /**
     * Returns the number of regions where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @return the number of matching regions
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

            query.append(_SQL_COUNT_REGION_WHERE);

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
     * Caches the region in the entity cache if it is enabled.
     *
     * @param region the region
     */
    @Override
    public void cacheResult(Region region) {
        EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionImpl.class, region.getPrimaryKey(), region);

        region.resetOriginalValues();
    }

    /**
     * Caches the regions in the entity cache if it is enabled.
     *
     * @param regions the regions
     */
    @Override
    public void cacheResult(List<Region> regions) {
        for (Region region : regions) {
            if (EntityCacheUtil.getResult(
                        RegionModelImpl.ENTITY_CACHE_ENABLED, RegionImpl.class,
                        region.getPrimaryKey()) == null) {
                cacheResult(region);
            } else {
                region.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all regions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RegionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RegionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the region.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Region region) {
        EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionImpl.class, region.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Region> regions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Region region : regions) {
            EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                RegionImpl.class, region.getPrimaryKey());
        }
    }

    /**
     * Creates a new region with the primary key. Does not add the region to the database.
     *
     * @param id the primary key for the new region
     * @return the new region
     */
    @Override
    public Region create(long id) {
        Region region = new RegionImpl();

        region.setNew(true);
        region.setPrimaryKey(id);

        return region;
    }

    /**
     * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the region
     * @return the region that was removed
     * @throws com.example.myservice.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region remove(long id) throws NoSuchRegionException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the region
     * @return the region that was removed
     * @throws com.example.myservice.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region remove(Serializable primaryKey)
        throws NoSuchRegionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Region region = (Region) session.get(RegionImpl.class, primaryKey);

            if (region == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(region);
        } catch (NoSuchRegionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Region removeImpl(Region region) throws SystemException {
        region = toUnwrappedModel(region);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(region)) {
                region = (Region) session.get(RegionImpl.class,
                        region.getPrimaryKeyObj());
            }

            if (region != null) {
                session.delete(region);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (region != null) {
            clearCache(region);
        }

        return region;
    }

    @Override
    public Region updateImpl(com.example.myservice.model.Region region)
        throws SystemException {
        region = toUnwrappedModel(region);

        boolean isNew = region.isNew();

        RegionModelImpl regionModelImpl = (RegionModelImpl) region;

        Session session = null;

        try {
            session = openSession();

            if (region.isNew()) {
                session.save(region);

                region.setNew(false);
            } else {
                session.merge(region);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RegionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((regionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { regionModelImpl.getOriginalName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);

                args = new Object[] { regionModelImpl.getName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);
            }

            if ((regionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        regionModelImpl.getOriginalParentId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
                    args);

                args = new Object[] { regionModelImpl.getParentId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionImpl.class, region.getPrimaryKey(), region);

        return region;
    }

    protected Region toUnwrappedModel(Region region) {
        if (region instanceof RegionImpl) {
            return region;
        }

        RegionImpl regionImpl = new RegionImpl();

        regionImpl.setNew(region.isNew());
        regionImpl.setPrimaryKey(region.getPrimaryKey());

        regionImpl.setId(region.getId());
        regionImpl.setName(region.getName());
        regionImpl.setParentId(region.getParentId());

        return regionImpl;
    }

    /**
     * Returns the region with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the region
     * @return the region
     * @throws com.example.myservice.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region findByPrimaryKey(Serializable primaryKey)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByPrimaryKey(primaryKey);

        if (region == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return region;
    }

    /**
     * Returns the region with the primary key or throws a {@link com.example.myservice.NoSuchRegionException} if it could not be found.
     *
     * @param id the primary key of the region
     * @return the region
     * @throws com.example.myservice.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region findByPrimaryKey(long id)
        throws NoSuchRegionException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the region with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the region
     * @return the region, or <code>null</code> if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Region region = (Region) EntityCacheUtil.getResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                RegionImpl.class, primaryKey);

        if (region == _nullRegion) {
            return null;
        }

        if (region == null) {
            Session session = null;

            try {
                session = openSession();

                region = (Region) session.get(RegionImpl.class, primaryKey);

                if (region != null) {
                    cacheResult(region);
                } else {
                    EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                        RegionImpl.class, primaryKey, _nullRegion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                    RegionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return region;
    }

    /**
     * Returns the region with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the region
     * @return the region, or <code>null</code> if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the regions.
     *
     * @return the regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Region> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Region> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Region> findAll(int start, int end,
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

        List<Region> list = (List<Region>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_REGION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_REGION;

                if (pagination) {
                    sql = sql.concat(RegionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Region>(list);
                } else {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
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
     * Removes all the regions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Region region : findAll()) {
            remove(region);
        }
    }

    /**
     * Returns the number of regions.
     *
     * @return the number of regions
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

                Query q = session.createQuery(_SQL_COUNT_REGION);

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
     * Initializes the region persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.example.myservice.model.Region")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Region>> listenersList = new ArrayList<ModelListener<Region>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Region>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RegionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
