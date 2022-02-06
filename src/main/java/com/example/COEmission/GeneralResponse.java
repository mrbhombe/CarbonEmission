package com.example.COEmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class GeneralResponse<T> {
	private T data;
	private String msg;
	private Boolean success;
	private Long timeStamp;
	private Integer statusCode;


	/*public GeneralResponse(T data, String msg, Boolean success, Long timeStamp, HttpStatus statusCode) {
		this.data = data;
		this.msg = msg;
		this.success = success;
		this.timeStamp = timeStamp;
		this.statusCode = statusCode.value();
	}*/
	public GeneralResponse(T data, String msg, Boolean success, Long timeStamp, HttpStatus statusCode) {
		this.data = data;
		this.msg = msg;
		this.success = success;
		this.timeStamp = timeStamp;
		this.statusCode = statusCode.value();
	}

}
