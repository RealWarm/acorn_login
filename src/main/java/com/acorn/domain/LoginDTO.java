package com.acorn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDTO {
	private String uid;
	private String upw;
	private boolean useCookie;
	
	
} // end class
