/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.metier;

import fr.freeboxos.ftb.metier.entitys.Administrateur;
import fr.freeboxos.ftb.metier.entitys.Cable;
import fr.freeboxos.ftb.metier.sort.ComparatorByIdAdministrateur;
import fr.freeboxos.ftb.metier.sort.ComparatorByIdCable;
import fr.freeboxos.ftb.metier.sort.Sort;
import java.util.List;
import lml.rest.client.ClientRest;

/**
 *
 * @author alan
 */
public class CableServiceImpl extends ClientRest<Cable> implements CableService {

    public CableServiceImpl() {
        super.init("CableService", new RestServerLocalConfiguration());
    }

    @Override
    public Cable add(Cable t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Cable t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Cable t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Cable getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Cable> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Cable> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public Cable[] sort() throws Exception {
        Cable[] cables = this.getAll().toArray(new Cable[0]);
        ComparatorByIdCable cmp = new ComparatorByIdCable();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(cables, cmp);

        return cables;
    }

}
