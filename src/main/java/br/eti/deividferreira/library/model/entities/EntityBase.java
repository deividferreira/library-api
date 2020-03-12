/*
 * Copyright 2019 Deivid Ferreira, Inc.
 */

package br.eti.deividferreira.library.model.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 *
 * @author Deivid Ferreira
 *
 * @version
 * @since 01/03/2020 21:26:29
 */
public interface EntityBase<T extends Serializable> extends Serializable {
	/**
	 *
	 * @return
	 */
	T getId();

	/**
	 *
	 * @return
	 */
	@JsonIgnore
	boolean isSaved();

	/**
	 *
	 * @return
	 */
	@JsonIgnore
	default boolean isNotSaved() {
		return !this.isSaved();
	}

}
