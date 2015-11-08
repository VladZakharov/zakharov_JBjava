package service.impl;

import model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProviderRepository;
import service.ProviderService;

import java.util.List;

/**
 * Created by vlad on 28.10.15.
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderRepository repository;

    @Override
    public void addProvider(Provider provider) {
        repository.addProvider(provider);
    }

    @Override
    public List<Provider> getAllProviders() {
        return repository.getAllProviders();
    }

    @Override
    public Provider getProvider(Integer id) {
        return repository.getProvider(id);
    }

}
