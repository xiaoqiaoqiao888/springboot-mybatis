package com.rails.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "唯一主键", dataType = "integer")
	private Integer id;
	@ApiModelProperty(value = "姓氏", dataType = "String")
	private String lastName;
	@ApiModelProperty(value = "性别", dataType = "String")
	private String gender;
	@ApiModelProperty(value = "邮箱", dataType = "String")
	private String email;

}
