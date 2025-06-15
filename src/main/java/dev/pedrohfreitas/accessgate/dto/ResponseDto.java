package dev.pedrohfreitas.accessgate.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
	
	private T data;
	
	public ResponseEntity<ResponseDto<T>> getReponse(T data,HttpStatus status){
		return new ResponseEntity<ResponseDto<T>>(new ResponseDto<T>(data), status);
	}

}
