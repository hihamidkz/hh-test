package com.example.myservice.service.persistence;

import com.example.myservice.model.Region;
import com.example.myservice.service.RegionLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author hamid
 * @generated
 */
public abstract class RegionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RegionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RegionLocalServiceUtil.getService());
        setClass(Region.class);

        setClassLoader(com.example.myservice.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
