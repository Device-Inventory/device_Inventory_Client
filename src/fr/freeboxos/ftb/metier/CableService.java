/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.metier;

import fr.freeboxos.ftb.metier.entitys.Cable;
import lml.persistence.CrudService;

/**
 *
 * @author alan
 */
public interface CableService extends CrudService<Cable> {

    public Cable[] sort() throws Exception;
}
