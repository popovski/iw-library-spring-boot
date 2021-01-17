package com.labs.iw.library.infrastructure.domain;

import java.io.Serializable;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATIONDATETIME", insertable = true, updatable = false)
	private Date creationDateTime;

	@Column(name = "UUID", updatable = false)
	private String uuid;

	@PrePersist
	public void init() {
		uuid = UUID.randomUUID().toString().replace("-", "");
		creationDateTime = Date.from(java.time.ZonedDateTime.now(ZoneOffset.UTC).toInstant());
	}

}
