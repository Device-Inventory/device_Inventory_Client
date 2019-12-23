/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.metier;

import fr.freeboxos.ftb.metier.entitys.Processeur;
import fr.freeboxos.ftb.metier.sort.ComparatorByIdProcesseur;
import fr.freeboxos.ftb.metier.sort.Sort;
import java.util.List;
import lml.rest.client.ClientRest;

/**
 *
 * @author alan
 */
public class ProcesseurServiceImpl extends ClientRest<Processeur> implements ProcesseurService {

    public ProcesseurServiceImpl() {
        super.init("ProcesseurService", new RestServerLocalConfiguration());
    }

    @Override
    public Processeur add(Processeur t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Processeur t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Processeur t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Processeur getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Processeur> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Processeur> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public Processeur[] sort() throws Exception {
        Processeur[] processeurs = this.getAll().toArray(new Processeur[0]);
        ComparatorByIdProcesseur cmp = new ComparatorByIdProcesseur();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(processeurs, cmp);

        return processeurs;
    }

}
