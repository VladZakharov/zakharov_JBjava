package repository.impl;

import model.Provider;
import org.springframework.stereotype.Repository;
import repository.ProviderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by vlad on 28.10.15.
 */
@Repository
public class ProviderRepositoryImpl implements ProviderRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addProvider(Provider provider) {
        em.merge(provider);
    }

    @Override
    public List<Provider> getAllProviders() {
        Query query = em.createNativeQuery("SELECT * FROM provider", Provider.class);
        return query.getResultList();
    }

    @Override
    public Provider getProvider(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM provider WHERE id = ?", Provider.class);
        query.setParameter(1, id);
        return (Provider) query.getSingleResult();
    }

}
