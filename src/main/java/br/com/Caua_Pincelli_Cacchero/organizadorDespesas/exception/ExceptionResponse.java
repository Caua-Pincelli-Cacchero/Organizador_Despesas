package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
