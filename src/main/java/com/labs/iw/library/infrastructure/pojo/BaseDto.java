package com.labs.iw.library.infrastructure.pojo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDto {
	private String uuid;
	private Date createdOn;
}
