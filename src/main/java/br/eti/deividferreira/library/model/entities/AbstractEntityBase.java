/*
 * Copyright 2019 Deivid Ferreira, Inc.
 */

package br.eti.deividferreira.library.model.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 *
 * @author Deivid Ferreira
 *
 * @version
 * @since 01/03/2020 21:22:56
 */
@ToString
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "createdOn", "updatedOn" })
public abstract class AbstractEntityBase implements EntityBase<UUID> {
	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, updatable = false)
	private UUID id;

	@Getter
	@Column(name = "created_on", nullable = false)
	private LocalDateTime createdOn;
	@Getter
	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	/**
	 *
	 */
	@PrePersist
	protected void beforeInsert() {
		this.createdOn = LocalDateTime.now();
	}

	/**
	 *
	 */
	@PreUpdate
	protected void beforeUpdate() {
		this.updatedOn = LocalDateTime.now();
	}

	/**
	 * {@inheritDoc }
	 *
	 * @return
	 */
	@Override
	@JsonIgnore
	public boolean isSaved() {
		return this.id != null;
	}
}
