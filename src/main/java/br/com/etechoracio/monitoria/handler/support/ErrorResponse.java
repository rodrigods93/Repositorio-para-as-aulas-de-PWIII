package br.com.etechoracio.monitoria.handler.support;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
	
	private int status;
	private String message;
	private Map<String, String> violations;
	
}
