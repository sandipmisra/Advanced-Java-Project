package dev.repository;

import dev.domain.Rent;
import dev.domain.Seller;
import dev.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentRepository {

    private SessionFactory sessionFactory;

    public RentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Rent rent) {
        Session session = sessionFactory.getCurrentSession();
        session.save(rent);
    }

    public List<Rent> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Rent> rentQuery = session.createQuery("SELECT r FROM Rent r", Rent.class);
        return rentQuery.getResultList();
    }

}
