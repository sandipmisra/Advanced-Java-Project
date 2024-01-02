package dev.service;

import dev.domain.Seller;
import dev.domain.User;
import dev.repository.SellerRepository;
import dev.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SellerService {

    private SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public void create(Seller seller) {
        seller.setName(seller.getName().toUpperCase());
        sellerRepository.create(seller);
    }

    public List<Seller> getAllSeller() {
        return sellerRepository.getAll();
    }

    //public User getUserById(int sellerId) {
       // return sellerRepository.get(sellerId);
   // }

    //public void updateUser(User user) {sellerRepository.edit(user);}

   /* public User authenticate(String fullname, String password) {
        // Retrieve the user from the repository based on the provided credentials
        User user = sellerRepository.findByEmailAndPassword(fullname, password);

        // Return the authenticated user or null if authentication fails
        return user;
    }*/



}
