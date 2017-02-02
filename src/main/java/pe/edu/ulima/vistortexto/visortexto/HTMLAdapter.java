/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.vistortexto.visortexto;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class HTMLAdapter implements AdapterVisor {

    @Override
    public ByteArrayOutputStream formatear(String titulo, String contenido) throws IOException {
        
        String respuesta = "";

        respuesta += "<html>";
        respuesta += "<head>";
        respuesta += "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"/>";
        respuesta += "</head>";
        respuesta += "<body class='container'>";
        respuesta += "<h1>" + titulo + "</h1>";
        respuesta += "<div class=\"panel panel-default\">";
        respuesta += "<div class=\"panel-body\">" + contenido + "</div>";
        respuesta += "</div?";
        respuesta += "</body>";
        respuesta += "</html>";
        
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(respuesta.getBytes());
        
        return baos;

    }
    
    private ByteArrayOutputStream getByteArrayOutputStream(String ruta) throws IOException {

        File file = new File(ruta);

        FileInputStream fis = new FileInputStream(file);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[256];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                System.out.println("read " + readNum + " bytes,");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return bos;
    }

}
