package com.example.myservice.model.impl;

/**
 * The extended model implementation for the Vacancy service. Represents a row in the &quot;hh_api_Vacancy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.myservice.model.Vacancy} interface.
 * </p>
 *
 * @author hamid
 */
public class VacancyImpl extends VacancyBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a vacancy model instance should use the {@link com.example.myservice.model.Vacancy} interface instead.
     */
    public VacancyImpl() {
    }
    
    @Override
    public String toString() {
        return getName() + "\n"
                + getEmployer() + "\n"
                + ((getSalary() == null) ? "" : getSalary())
                + ((getAddress() == null) ? "" : getAddress());
                
    }
}
