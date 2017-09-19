package com.caveofprogramming.spring.web.service;

import com.caveofprogramming.spring.web.model.Offer;

import org.springframework.stereotype.Service;


@Service
public class OfferServiceImpl implements OfferService {
  

    @Override
    public void save(Offer offer) {
   	/*    user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);*/
       
    }

   /* @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}*/
}
