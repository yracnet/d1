package bo.edu.uagrm.soe.practica2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // curl -X GET -vs http://localhost:8080/usuarios |jq
    // curl -X POST -v -H 'Content-Type: application/json' -d '{ "id": "2", "email": "ivan.es@gmail.com", "nombres": "ivan", "apellidos": "ulo", "descripcion":"administrador1" }' http://localhost:8080/customers |jq

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
