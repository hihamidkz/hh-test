package com.example.myservice.service.persistence;

import com.example.myservice.model.Vacancy;
import com.example.myservice.service.VacancyLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author hamid
 * @generated
 */
public abstract class VacancyActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public VacancyActionableDynamicQuery() throws SystemException {
        setBaseLocalService(VacancyLocalServiceUtil.getService());
        setClass(Vacancy.class);

        setClassLoader(com.example.myservice.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
