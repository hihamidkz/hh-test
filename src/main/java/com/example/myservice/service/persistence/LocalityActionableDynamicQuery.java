package com.example.myservice.service.persistence;

import com.example.myservice.model.Locality;
import com.example.myservice.service.LocalityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author hamid
 * @generated
 */
public abstract class LocalityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LocalityActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LocalityLocalServiceUtil.getService());
        setClass(Locality.class);

        setClassLoader(com.example.myservice.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
