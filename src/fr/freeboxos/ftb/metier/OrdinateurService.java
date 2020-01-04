/*
 * Copyright (C) 2019 alan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.freeboxos.ftb.metier;

import fr.freeboxos.ftb.metier.entitys.HDD;
import fr.freeboxos.ftb.metier.entitys.Memoire;
import fr.freeboxos.ftb.metier.entitys.Ordinateur;
import fr.freeboxos.ftb.metier.entitys.Processeur;
import lml.persistence.CrudService;

/**
 *
 * @author alan
 */
public interface OrdinateurService extends CrudService<Ordinateur> {

    public Ordinateur[] sort() throws Exception;

    public Ordinateur getByProcesseur(Processeur processeur) throws Exception;

    public Ordinateur getByMemoire(Memoire memoire) throws Exception;

    public Ordinateur getByHdd(HDD hdd) throws Exception;

    public Boolean isProcesseurAttribue(Processeur processeur) throws Exception;

    public Boolean isMemoireAttribue(Memoire memoire) throws Exception;

    public Boolean isHddAttribue(HDD hdd) throws Exception;

}
