package uk.me.eastmans.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by markeastman on 23/08/2016.
 */
@ApplicationScoped
public class CounterRepository {
    @Inject
    private EntityManager em;

    public Counter findByName( String name )
    {
        TypedQuery<Counter> query = em.createQuery( "select c from Counter c where c.name = :name", Counter.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
