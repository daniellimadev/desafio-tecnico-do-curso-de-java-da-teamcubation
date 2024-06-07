package com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "desafio-tecnico",
        version = "1",
        description = "API desenvolvida para o Desafio técnico do curso intensivo de java da Teamcubation!"))
public class DesafioTecnicoDoCursoDeJavaDaTeamcubationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioTecnicoDoCursoDeJavaDaTeamcubationApplication.class, args);
    }

}
