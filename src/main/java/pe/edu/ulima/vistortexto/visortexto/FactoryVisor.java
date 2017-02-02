
package pe.edu.ulima.vistortexto.visortexto;

import java.io.ByteArrayOutputStream;


public class FactoryVisor {
    
    public AdapterVisor obtenerAdapter(String tipo){
        
        if (tipo.equals("pdf")) {
              return new PDFAdapter();
        }else if (tipo.equals("html")){
            return new HTMLAdapter();
                
       }else{
            return null;
        }
       
        
    }
    
}
