package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
