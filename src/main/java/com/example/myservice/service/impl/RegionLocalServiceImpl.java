package com.example.myservice.service.impl;

import com.example.myservice.model.Region;
import com.example.myservice.service.RegionLocalServiceUtil;
import com.example.myservice.service.base.RegionLocalServiceBaseImpl;
import com.example.myservice.service.persistence.RegionUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the region local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.myservice.service.RegionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hamid
 * @see com.example.myservice.service.base.RegionLocalServiceBaseImpl
 * @see com.example.myservice.service.RegionLocalServiceUtil
 */
public class RegionLocalServiceImpl extends RegionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.example.myservice.service.RegionLocalServiceUtil} to access the region local service.
     */
    
    public void addOrUpdate(Region region) throws SystemException {
        Region r = RegionUtil.fetchByPrimaryKey(region.getId());
        if (r != null) {
            RegionLocalServiceUtil.updateRegion(r);
        } else {
            RegionLocalServiceUtil.addRegion(region);
        }
    }
    
    public List<Region> getRegionForName(String name) throws SystemException {
        return RegionUtil.findByName(name);
    }
}
