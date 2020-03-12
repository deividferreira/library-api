/*
 * Copyright 2019 Deivid Ferreira, Inc.
 */

package br.eti.deividferreira.library.api.data;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @author Deivid Ferreira
 *
 * @version
 * @since 01/03/2020 21:59:26
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "name" })
public class AuthorNew {

	@Getter
	@NotBlank(message = "{author.name}")
	private String name;
	@Getter
	@Past(message = "{author.born-date-past}")
	private LocalDate bornDate;
	@Getter
	@NotBlank(message = "{author.email}")
	private String email;

}
