package com.javaeeeee.dwstart.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	/** contains the same HTTP Status code returned by the server */
	@XmlElement(name = "status")
	int status;

	/** message describing the error*/
	@XmlElement(name = "message")
	String message;
/*
	public ErrorMessage(CustomException ex){
			this.message = ex.getMessage();
			this.status = ex.getStatus();
		}
*/
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorMessage(NotFoundException ex){
		this.status = Response.Status.NOT_FOUND.getStatusCode();
		this.message = ex.getMessage();
	}

	public ErrorMessage(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public ErrorMessage(int status) {
		this.status = status;
		if (status == 404) {
			this.message = "No hay datos para mostrar";
		} else if (status==1001) {
			this.message = "Este ticket ya fue calificado";
		} else if (status==1002) {
			this.message = "Este proyecto ya fue calificado";
		} else if (status==1003) {
			this.message = "No se pueden calificar tickets que no hayan sido cerrados";
		} else if (status==1004) {
			this.message = "No se pueden calificar proyectos que no hayan sido cerrados";
		} else if (status==1005) {
			this.message = "No se pueden calificar proyectos o tickets anteriores al lanzamiento de calificaciones";
		} else if (status==1006) {
			this.message = "La calificación debe ser un número entre 1 y 5";
		} else {
				this.message = "Se produjo un error al obtener los datos";
			}
	}

	public ErrorMessage() {};
}
