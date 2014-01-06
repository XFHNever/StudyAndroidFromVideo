package com.example.studyfromvideo.location;

import java.util.Arrays;
import java.util.List;

public class Result {
    private String[] type;
    private String formatted_address;
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	
	public Result(String[] type, String formatted_address) {
		super();
		this.type = type;
		this.formatted_address = formatted_address;
	}
	@Override
	public String toString() {
		return "Result [type=" + Arrays.toString(type) + ", formatted_address="
				+ formatted_address + "]";
	}
    
    
}
