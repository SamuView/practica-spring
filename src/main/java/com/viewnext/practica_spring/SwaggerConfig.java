package com.viewnext.practica_spring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
			title = "Practica API REST Spring + Swagger",
			description = "Our app is to create/read/update/delete products from a warehouse",
			termsOfService = "www.mipagina.com/terminos_y_servicios",
			version = "1.0.0",
			contact = @Contact(
					name = "Samuel Trujillo",
					url = "www.mipagina.com/contact",
					email = "samuel.trujillo@viewnext.com"
			),
			license = @License(
					name = "Standar Software Use License for MiPagina",
					url = "www.mipagina.com/license"
			)
		),
		servers = {
				@Server(
						description = "DEV SERVER",
						url = "http://localhost:8080"
				),
				@Server(
						description = "PROD SERVER",
						url = "http://mipagina:8080"
				)
		}
)
public class SwaggerConfig {}
