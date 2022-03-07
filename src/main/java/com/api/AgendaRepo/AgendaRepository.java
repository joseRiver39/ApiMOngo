
package com.api.AgendaRepo;

import com.api.model.Agenda;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author usuario
 */
public interface AgendaRepository  extends MongoRepository<Agenda,String>{
}
