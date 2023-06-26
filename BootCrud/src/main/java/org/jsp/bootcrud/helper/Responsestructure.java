package org.jsp.bootcrud.helper;

import java.util.List;
import java.util.Optional;

import org.jsp.bootcrud.dto.Student;

import lombok.Data;

@Data
public class Responsestructure<T> {
	String message;
	int status;
	T data;
	

}
