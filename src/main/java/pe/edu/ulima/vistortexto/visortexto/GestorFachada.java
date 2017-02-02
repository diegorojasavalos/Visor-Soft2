/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.vistortexto.visortexto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class GestorFachada {
    public ByteArrayOutputStream formatear(String tipo, String titulo, String contenido) throws IOException{
        
        FactoryVisor factory = new FactoryVisor();
        AdapterVisor adapter = factory.obtenerAdapter(tipo);
        ByteArrayOutputStream baos = adapter.formatear(titulo, contenido);
        
        return baos;
        
    }
            
            
    
}
