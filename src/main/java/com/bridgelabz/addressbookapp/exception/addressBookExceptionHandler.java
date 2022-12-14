package com.bridgelabz.addressbookapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.addressbookapp.dto.addressBookResponseDTO;

@ControllerAdvice
public class addressBookExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<addressBookResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsgList = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		addressBookResponseDTO responseDTO = new addressBookResponseDTO("Exception while processing error msg",errMsgList);
		return new ResponseEntity<addressBookResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
		
	}
	

}
