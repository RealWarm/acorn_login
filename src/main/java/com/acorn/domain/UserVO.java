package com.acorn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserVO {
	private String uid;
	private String upw;
	private String uname;
	private int upoint;
	
	

} // end class
