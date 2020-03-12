/*
 * Copyright 2019 Deivid Ferreira, Inc.
 */

package br.eti.deividferreira.library.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *
 *
 * @author Deivid Ferreira
 *
 * @version
 * @since 01/03/2020 21:31:24
 */
@Entity
@Builder
@AllArgsConstructor
@Table(name = "authors")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Author extends AbstractEntityBase {

	@Getter
	@NotBlank(message = "{author.name}")
	@Column(name = "name", length = 90, nullable = false)
	private String name;
	@Getter
	@Past(message = "{author.born-date-past}")
	@Column(name = "born_date")
	private LocalDate bornDate;
	@Getter
	@NotBlank(message = "{author.email}")
	@Column(name = "email", length = 90, nullable = false)
	private String email;
	@Getter
	@Column(name = "active", nullable = false)
	private boolean active;

	/**
	 *
	 */
	public Author() {
		this.active = true;
	}

}
