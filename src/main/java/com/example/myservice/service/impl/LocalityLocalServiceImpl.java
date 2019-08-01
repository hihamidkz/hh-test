package com.example.myservice.service.impl;

import com.example.myservice.model.Locality;
import com.example.myservice.service.LocalityLocalServiceUtil;
import com.example.myservice.service.base.LocalityLocalServiceBaseImpl;
import com.example.myservice.service.persistence.LocalityUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the locality local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.myservice.service.LocalityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hamid
 * @see com.example.myservice.service.base.LocalityLocalServiceBaseImpl
 * @see com.example.myservice.service.LocalityLocalServiceUtil
 */
public class LocalityLocalServiceImpl extends LocalityLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.example.myservice.service.LocalityLocalServiceUtil} to access the locality local service.
     */
    
    public void addOrUpdate(Locality locality) throws SystemException {
        Locality l = LocalityUtil.fetchByPrimaryKey(locality.getId());
        if (l != null) {
            LocalityLocalServiceUtil.updateLocality(l);
        } else {
            LocalityLocalServiceUtil.addLocality(locality);
        }
    }
    
    public List<Locality> getLocalitiesForParentId(long id) throws SystemException {
        return LocalityUtil.findByParentId(id);
    }
    
    public List<Locality> getLocalityForName(String name) throws SystemException {
        return LocalityUtil.findByName(name);
    }
}
