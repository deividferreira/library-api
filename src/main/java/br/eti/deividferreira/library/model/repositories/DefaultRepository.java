/*
 * Copyright 2019 Deivid Ferreira, Inc.
 */

package br.eti.deividferreira.library.model.repositories;

import java.util.UUID;

import javax.enterprise.context.Dependent;

import br.eti.deividferreira.library.model.entities.EntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

/**
 *
 *
 * @author Deivid Ferreira
 *
 * @version
 * @since 01/03/2020 21:39:58
 */
@Dependent
public class DefaultRepository<T extends EntityBase>
		implements PanacheRepositoryBase<T, UUID> {

}
