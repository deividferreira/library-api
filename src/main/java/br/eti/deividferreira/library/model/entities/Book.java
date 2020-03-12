/*
 * Copyright 2019 Deivid Ferreira, Inc.
 */

package br.eti.deividferreira.library.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
 * @since 01/03/2020 21:35:38
 */
@Entity
@Builder
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "books")
public class Book extends AbstractEntityBase {

	@Getter
	@NotBlank(message = "{book.isbn}")
	@Column(name = "isbn", nullable = false, length = 20)
	private String isbn;
	@Getter
	@NotBlank(message = "{book.title}")
	@Column(name = "title", nullable = false, length = 90)
	private String title;
	@Getter
	@Column(name = "subtitle", length = 90)
	private String subtitle;
	@Getter
	@Column(name = "published_on")
	private LocalDate publishedOn;
	@Getter
	@NotBlank(message = "{book.summary}")
	@Column(name = "summary", nullable = false, length = 500)
	private String summary;
	@Getter
	@Column(name = "active", nullable = false)
	private boolean active;

	@Getter
	@ManyToOne(optional = false)
	@NotNull(message = "{book.author}")
	@JoinColumn(name = "id_author", nullable = false)
	private Author author;

	/**
	 * Constructor
	 */
	public Book() {
		this.active = true;
	}
}
