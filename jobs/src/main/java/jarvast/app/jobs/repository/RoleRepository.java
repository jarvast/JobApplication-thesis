/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Role;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TomiPC
 */
public interface RoleRepository extends CrudRepository<Role, Long>{
    
}
