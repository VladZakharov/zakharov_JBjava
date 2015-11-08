package service.impl;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OfficeRepository;
import service.OfficeService;

import java.util.List;

/**
 * Created by vlad on 28.10.15.
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    OfficeRepository repository;

    @Override
    public Office getOffice(Integer id) {
        return repository.getOffice(id);
    }

    @Override
    public List<People> getOfficePatients(Integer id) {
        return repository.getOfficePatients(id);
    }

    @Override
    public List<People> getOfficeStuffs(Integer id) {
        return repository.getOfficeStuffs(id);
    }

    @Override
    public People addPeople(People people) {
        return repository.addPeople(people);
    }

    @Override
    public List<Provider> getOfficeProviders(Integer id) {
        return repository.getOfficeProviders(id);
    }

    @Override
    public Provider addProvider(Provider provider) {
        return repository.addProvider(provider);
    }

    @Override
    public void addJI(JuridicalInfo ji) {
        repository.addJI(ji);
    }

    @Override
    public OperationSupplier addOperationSupplier(OperationSupplier op) {
        return repository.addOperationSupplier(op);
    }

    @Override
    public List<OperationSupplier> getOperationSuppliers(Integer id) {
        return repository.getOperationSuppliers(id);
    }

    @Override
    public Integer getAverageSalary(Integer id) {
        return repository.getAverageSalary(id);
    }

    @Override
    public Integer getAverageCost(Integer id) {
        return repository.getAverageCost(id);

    }
}
