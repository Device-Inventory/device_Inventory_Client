/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.metier;

import fr.freeboxos.ftb.metier.entitys.HDD;
import fr.freeboxos.ftb.metier.entitys.Memoire;
import fr.freeboxos.ftb.metier.sort.ComparatorByIdHDD;
import fr.freeboxos.ftb.metier.sort.ComparatorByIdMemoire;
import fr.freeboxos.ftb.metier.sort.Sort;
import java.util.List;
import lml.rest.client.ClientRest;

/**
 *
 * @author alan
 */
public class MemoireServiceImpl extends ClientRest<Memoire> implements MemoireService {

    public MemoireServiceImpl() {
        super.init("MemoireService", new RestServerLocalConfiguration());
    }

    @Override
    public Memoire add(Memoire t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Memoire t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Memoire t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Memoire getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Memoire> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Memoire> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public Memoire[] sort() throws Exception {
        Memoire[] memoires = this.getAll().toArray(new Memoire[0]);
        ComparatorByIdMemoire cmp = new ComparatorByIdMemoire();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(memoires, cmp);

        return memoires;
    }
}
