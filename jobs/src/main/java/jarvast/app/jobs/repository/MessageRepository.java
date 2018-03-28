/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Message;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TomiPC
 */
public interface MessageRepository extends CrudRepository<Message, Long>{
    
    //public List<Message> find
}
