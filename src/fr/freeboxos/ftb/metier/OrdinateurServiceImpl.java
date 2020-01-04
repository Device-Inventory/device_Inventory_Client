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
import fr.freeboxos.ftb.metier.sort.ComparatorByIdOrdinateur;
import fr.freeboxos.ftb.metier.sort.Sort;
import java.util.List;
import lml.rest.client.ClientRest;

public class OrdinateurServiceImpl extends ClientRest<Ordinateur> implements OrdinateurService {

    public OrdinateurServiceImpl() {
        super.init("OrdinateurService", new RestServerLocalConfiguration());
    }

    @Override
    public Ordinateur[] sort() throws Exception {
        Ordinateur[] ordinateurs = this.getAll().toArray(new Ordinateur[0]);
        ComparatorByIdOrdinateur cmp = new ComparatorByIdOrdinateur();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(ordinateurs, cmp);

        return ordinateurs;
    }

    @Override
    public Ordinateur add(Ordinateur t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Ordinateur t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Ordinateur t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Ordinateur getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Ordinateur> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Ordinateur> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public Ordinateur getByProcesseur(Processeur processeur) throws Exception {
        super.setPath("getByProcesseur/" + processeur.getId());
        return super.getEntity();
    }

    @Override
    public Ordinateur getByMemoire(Memoire memoire) throws Exception {
        super.setPath("getByMemoire/" + memoire.getId());
        return super.getEntity();
    }

    @Override
    public Ordinateur getByHdd(HDD hdd) throws Exception {
        super.setPath("getByHdd/" + hdd.getId());
        return super.getEntity();
    }

    @Override
    public Boolean isProcesseurAttribue(Processeur processeur) throws Exception {
        super.setPath("processeurAttribue/" + processeur.getId());
        return super.equals(this);
    }

    @Override
    public Boolean isMemoireAttribue(Memoire memoire) throws Exception {
        super.setPath("memoireAttribue/" + memoire.getId());
        return super.equals(this);
    }

    @Override
    public Boolean isHddAttribue(HDD hdd) throws Exception {
        super.setPath("hddAttribue/" + hdd.getId());
        return super.equals(this);
    }

}
