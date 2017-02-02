package pe.edu.ulima.vistortexto.visortexto;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.eclipse.jetty.io.Connection;
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.stop;

public class Main {

    public static void main(String[] args) {
        get("/parar", (req, resp) -> {
            stop();
            return "";
        });

        get("/", (req, resp) -> {
            return new ModelAndView(null, "main.html");
        }, new Jinja2TemplateEngine());

        post("/mostrar", (req, resp) -> {
            String titulo = req.queryParams("titulo");
            String contenido = req.queryParams("contenido");
            String tipo = req.queryParams("tipo");

            String respuesta = "";

            GestorFachada gestor = new GestorFachada();
            ByteArrayOutputStream baos = gestor.formatear(tipo, titulo, contenido);

            baos.writeTo(resp.raw().getOutputStream());
            resp.raw().getOutputStream().flush();

            
            return respuesta;

        });
    }

}
