package dev.repository;

import dev.domain.Seller;
import dev.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellerRepository {

    private SessionFactory sessionFactory;

    public SellerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(Seller seller) {
        Session session = sessionFactory.getCurrentSession();
        session.save(seller);
    }

    public List<Seller> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Seller> sellerQuery = session.createQuery("SELECT s FROM Seller s", Seller.class);
        return sellerQuery.getResultList();
    }
}
