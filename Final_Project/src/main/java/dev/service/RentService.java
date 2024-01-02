package dev.service;

import dev.domain.Rent;
import dev.domain.Seller;
import dev.domain.User;
import dev.repository.RentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RentService {

    private RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public void create(Rent rent) {
        rent.setName(rent.getName().toUpperCase());
        rentRepository.create(rent);
    }

    public List<Rent> getAllRent() {
        return rentRepository.getAll();
    }
}
