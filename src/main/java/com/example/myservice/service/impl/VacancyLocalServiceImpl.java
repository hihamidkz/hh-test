package com.example.myservice.service.impl;

import com.example.myservice.NoSuchVacancyException;
import com.example.myservice.model.Vacancy;
import com.example.myservice.service.VacancyLocalServiceUtil;
import com.example.myservice.service.base.VacancyLocalServiceBaseImpl;
import com.example.myservice.service.persistence.VacancyUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;

/**
 * The implementation of the vacancy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.myservice.service.VacancyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hamid
 * @see com.example.myservice.service.base.VacancyLocalServiceBaseImpl
 * @see com.example.myservice.service.VacancyLocalServiceUtil
 */
public class VacancyLocalServiceImpl extends VacancyLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.example.myservice.service.VacancyLocalServiceUtil} to access the vacancy local service.
     */
    
    public void addOrUpdate(Vacancy vacancy) throws SystemException {
        Vacancy v = VacancyUtil.fetchByPrimaryKey(vacancy.getId());
        if (v != null) {
            VacancyLocalServiceUtil.updateVacancy(v);
        } else {
            VacancyLocalServiceUtil.addVacancy(vacancy);
        }
    }
    
}
