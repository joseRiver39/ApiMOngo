
package com.api.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;



@Data
@Document
public class Agenda {
    @Id
    private String id;
    
    private String nombre;
    
    private boolean completado;
    
    
    
}
