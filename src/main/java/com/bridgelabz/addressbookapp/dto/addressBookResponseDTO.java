package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class addressBookResponseDTO {
	private String messageString;
	private Object dataObject;
	public addressBookResponseDTO(String messageString, Object dataObject) {
		this.messageString=messageString;
		this.dataObject = dataObject;
	}
}
