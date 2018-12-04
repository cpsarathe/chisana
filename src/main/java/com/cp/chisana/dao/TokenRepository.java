package com.cp.chisana.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cp.chisana.domain.Token;
import com.cp.chisana.domain.User;

/**
 * Created by Chandra.Sarathe on 12/1/2018.
 */
@Repository
public interface TokenRepository extends CrudRepository<Token,Long> {

    Token findByToken(String token);

}
