/*
 * Copyright (C) 2020 alan
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

import fr.freeboxos.ftb.metier.entitys.CarteGraphique;
import fr.freeboxos.ftb.metier.sort.ComparatorByIdCarteGraphique;
import fr.freeboxos.ftb.metier.sort.Sort;
import java.util.List;
import lml.rest.client.ClientRest;

public class CarteGraphiqueServiceImpl extends ClientRest<CarteGraphique> implements CarteGraphiqueService {

    public CarteGraphiqueServiceImpl() {
        super.init("CarteGraphique", new RestServerLocalConfiguration());
    }

    @Override
    public CarteGraphique[] sort() throws Exception {
        CarteGraphique[] carteGraphiques = this.getAll().toArray(new CarteGraphique[0]);
        ComparatorByIdCarteGraphique cmp = new ComparatorByIdCarteGraphique();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(carteGraphiques, cmp);

        return carteGraphiques;
    }

    @Override
    public CarteGraphique add(CarteGraphique t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(CarteGraphique t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(CarteGraphique t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public CarteGraphique getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<CarteGraphique> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<CarteGraphique> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

}
