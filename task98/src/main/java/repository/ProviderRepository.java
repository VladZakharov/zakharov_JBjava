package repository;

import model.Provider;

import java.util.List;

/**
 * Created by vlad on 27.10.15.
 */
public interface ProviderRepository {

    void addProvider(Provider provider);

    List<Provider> getAllProviders();

    Provider getProvider(Integer id);

}
