package com.heroku.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.heroku.demo.domain.Account;
import com.heroku.demo.exception.BadResourceException;
import com.heroku.demo.exception.ResourceAlreadyExistsException;
import com.heroku.demo.exception.ResourceNotFoundException;
import com.heroku.demo.repository.AccountRepository;
import com.heroku.demo.specification.AccountSpecification;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    private boolean existsById(Long id) {
        return accountRepository.existsById(id);
    }
    
    /**
     * BEGIN -- CUSTOM FUNCTIONS
     */
    
    /**
     * 
     * @param il
     * @param pageNumber
     * @param rowPerPage
     * @return
     */
    public List<Account> findBySimilarity(String il, int pageNumber, int rowPerPage) throws ResourceNotFoundException  {
        List<Account> names = new ArrayList<>();
        
        if (il==null || il.trim().equals("")) {
            throw new ResourceNotFoundException("Name to search must be present and cannot be empty");
        }
        
        accountRepository.findNameBySimilarity(il, PageRequest.of(pageNumber - 1, rowPerPage)).forEach(names::add);
        return names;
    }
    
    /**
     * END -- CUSTOM FUNCTIONS
     */

    public Account findById(Long id) throws ResourceNotFoundException {
    	Account il = accountRepository.findById(id).orElse(null);
        if (il==null) {
            throw new ResourceNotFoundException("Cannot find Name with id: " + id);
        }
        else return il;
    }
    
    public List<Account> findAll(int pageNumber, int rowPerPage) {
        List<Account> names = new ArrayList<>();
        accountRepository.findAll(PageRequest.of(pageNumber - 1, rowPerPage)).forEach(names::add);
        return names;
    }
    
    public List<Account> findAllByName(String il, int pageNumber, int rowPerPage) {
    	Account filter = new Account();
        filter.setName(il);
        Specification<Account> spec = new AccountSpecification(filter);
        
        List<Account> names = new ArrayList<>();
        accountRepository.findAll(spec, PageRequest.of(pageNumber - 1, rowPerPage)).forEach(names::add);
        return names;
    }

    public Account save(Account il) throws BadResourceException, ResourceAlreadyExistsException {
        if (!StringUtils.hasText(il.getName())) {
            if (il.getId() != null && existsById(il.getId())) { 
                throw new ResourceAlreadyExistsException("Name with id: " + il.getId() +
                        " already exists");
            }
            return accountRepository.save(il);
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save name");
            exc.addErrorMessage("Name is null or empty");
            throw exc;
        }
    }
    
    public void update(Account il) 
            throws BadResourceException, ResourceNotFoundException {
        if (!StringUtils.hasText(il.getName())) {
            if (!existsById(il.getId())) {
                throw new ResourceNotFoundException("Cannot find Name with id: " + il.getId());
            }
            accountRepository.save(il);
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save name");
            exc.addErrorMessage("Name is null or empty");
            throw exc;
        }
    }
        
    public void deleteById(Long id) throws ResourceNotFoundException {
        if (!existsById(id)) { 
            throw new ResourceNotFoundException("Cannot find name with id: " + id);
        }
        else {
            accountRepository.deleteById(id);
        }
    }
    
    public Long count() {
        return accountRepository.count();
    }
}
