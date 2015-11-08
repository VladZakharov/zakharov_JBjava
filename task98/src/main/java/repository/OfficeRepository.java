package repository;

import model.*;

import java.util.List;

/**
 * Created by vlad on 28.10.15.
 */
public interface OfficeRepository {
    
    Office getOffice(Integer id);

    List<People> getOfficePatients(Integer id);

    People addPeople(People people);

    List<Provider> getOfficeProviders(Integer id);

    Provider addProvider(Provider provider);

    void addJI(JuridicalInfo ji);

    List<People> getOfficeStuffs(Integer id);

    OperationSupplier addOperationSupplier(OperationSupplier op);

    List<OperationSupplier> getOperationSuppliers(Integer id);

    Integer getAverageSalary(Integer id);

    Integer getAverageCost(Integer id);
}
