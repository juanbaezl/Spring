package co.edu.escuelaing.app.handlers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.app.entities.Numero;

@SpringBootApplication
@RestController
public class WebSiteController {
    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. " + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now() + ". " + "The server is Running!\"}";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/helloPost")
    @ResponseBody
    public String helloPost(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/start")
    public String start() {
        Numero juego = Numero.getInstance();
        juego.newNum();
        return juego.getNum().toString();
    }

    @GetMapping("/comparacion")
    public String comparacion(@RequestParam(value = "numero", defaultValue = "0000") String numero) {
        Numero juego = Numero.getInstance();
        return juego.comparacion(numero);
    }

    @GetMapping("/intentosNum")
    public int intentosNum() {
        Numero juego = Numero.getInstance();
        return juego.getIntentos();
    }
}
