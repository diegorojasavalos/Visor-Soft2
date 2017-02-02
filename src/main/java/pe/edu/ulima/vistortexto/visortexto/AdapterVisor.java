
package pe.edu.ulima.vistortexto.visortexto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public interface AdapterVisor {
    
    public ByteArrayOutputStream formatear (String titulo, String contenido) throws IOException;
    
    
    
}
