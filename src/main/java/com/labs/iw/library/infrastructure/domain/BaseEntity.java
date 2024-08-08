package com.labs.iw.library.infrastructure.domain;

import java.io.Serializable;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", insertable = true, updatable = false)
	private Date createdOn;

	@Column(name = "uuid", updatable = false)
	private String uuid;

	@PrePersist
	public void init() {
		uuid = UUID.randomUUID().toString();
		createdOn = Date.from(java.time.ZonedDateTime.now(ZoneOffset.UTC).toInstant());
	}
}