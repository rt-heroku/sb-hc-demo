package com.heroku.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.heroku.demo.domain.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long>, 
        JpaSpecificationExecutor<Account> {
	
	
	@Query(value="SELECT * FROM salesforce.account WHERE SIMILARITY(_name,:name) > 0.6 ORDER BY similarity (_name,:name) DESC",
			  nativeQuery = true)
	Page<Account> findNameBySimilarity(@Param("name") String name, Pageable p);
	
}
