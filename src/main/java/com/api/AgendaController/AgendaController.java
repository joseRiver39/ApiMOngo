/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.AgendaController;

import com.api.AgendaRepo.AgendaRepository;
import com.api.model.Agenda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agenda")
public class AgendaController {


 @Autowired
  private AgendaRepository agendaRepository;

@GetMapping("")
  List<Agenda> Index(){

  return  agendaRepository.findAll();
}
@ResponseStatus(HttpStatus.CREATED)
@PostMapping("")
Agenda create(@RequestBody Agenda Agenda){
  return agendaRepository.save(Agenda);

}

@PutMapping("{íd}")
Agenda  update(@PathVariable String id,@RequestBody Agenda agenda){
  Agenda AgendaDB= agendaRepository
    .findById(id)
     .orElseThrow(RuntimeException::new);
  AgendaDB.setNombre(agenda.getNombre()); 
  AgendaDB.setCompletado(agenda.isCompletado());
  

  return agendaRepository.save(AgendaDB);

}

@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping ("{íd}")
  void  delete(@PathVariable String id){
  Agenda AgendaDB= agendaRepository
                    .findById(id)
                    .orElseThrow(RuntimeException::new);

  agendaRepository.delete(AgendaDB);

}

}
   