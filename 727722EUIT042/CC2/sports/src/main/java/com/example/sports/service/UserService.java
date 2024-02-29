package com.example.sports.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.sports.model.Product;
import com.example.sports.model.User;
import com.example.sports.repository.ProductRepo;
import com.example.sports.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;
    public User postUser(User user)
    {
        return userRepo.save(user);
    }
    public List<User> getUser()
    {
        return userRepo.findAll();
    }
    public Optional<User> getUserById(Long id)
    {
        return userRepo.findById(id);
    }
    public User getUserByEmail(String email) {
        // Using getUserByEmail method
         return userRepo.getUserByEmail(email);
        
        
    }
    public User putUser(User user,Long id)
    {
        User userAvail= userRepo.findById(id).orElse(null);
        if(userAvail!=null)
        {
            userAvail.setUserName(user.getUserName());
            userAvail.setEmail(user.getEmail());
            userAvail.setPassword(user.getPassword());
            return userRepo.saveAndFlush(userAvail);
        }
        else
        return null;
    }
    public String deleteUser(Long id)
    {
        userRepo.deleteById(id);
        return ("User deleted");
    }
    public Product postProduct(Product product)
    {
        return productRepo.save(product);
    }
    public List<Product> getProduct()
    {
        return productRepo.findAll();
    }
    public Product putProduct(Product product,Long pId)
    {
        Product productAvail= productRepo.findById(pId).orElse(null);
        if(productAvail!=null)
        {
            productAvail.setpName(product.getpName());
            productAvail.setpPrice(product.getpPrice());
            return productRepo.saveAndFlush(productAvail);
        }
        else
        return null;
    }
    public String deleteProduct(Long pId)
    {
        productRepo.deleteById(pId);
        return ("User deleted");
    }
    public List<Product> getProductsWithSorting(String field)
    {
        return productRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }
    public List<Product> getProductsWithPaging(int pageNumber,int pageSize)
    {
        return productRepo.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
    public List<Product> getProductsWithPagingAndSorting(int pageNumber,int pageSize,String field)
    {
        return productRepo.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
}