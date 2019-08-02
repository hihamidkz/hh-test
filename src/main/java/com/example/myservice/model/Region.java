package com.example.myservice.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Region service. Represents a row in the &quot;hh_api_Region&quot; database table, with each column mapped to a property of this class.
 *
 * @author hamid
 * @see RegionModel
 * @see com.example.myservice.model.impl.RegionImpl
 * @see com.example.myservice.model.impl.RegionModelImpl
 * @generated
 */
public interface Region extends RegionModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.example.myservice.model.impl.RegionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public java.util.List<com.example.myservice.model.Locality> getLocalities()
        throws com.liferay.portal.kernel.exception.SystemException;
}
