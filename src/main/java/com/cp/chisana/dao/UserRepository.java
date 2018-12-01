package com.cp.chisana.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cp.chisana.domain.User;

/**
 * Created by Chandra.Sarathe on 12/1/2018.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
