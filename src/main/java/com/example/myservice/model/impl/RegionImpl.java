package com.example.myservice.model.impl;

import com.example.myservice.model.Locality;
import com.example.myservice.service.LocalityLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The extended model implementation for the Region service. Represents a row in the &quot;hh_api_Region&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.myservice.model.Region} interface.
 * </p>
 *
 * @author hamid
 */
public class RegionImpl extends RegionBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a region model instance should use the {@link com.example.myservice.model.Region} interface instead.
     */
    public RegionImpl() {
    }
    
    public List<Locality> getLocalities() throws SystemException {
        return LocalityLocalServiceUtil.getLocalitiesForParentId(getId());
    }
}
