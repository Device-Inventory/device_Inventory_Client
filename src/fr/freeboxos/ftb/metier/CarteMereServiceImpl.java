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

import fr.freeboxos.ftb.metier.entitys.CarteMere;
import fr.freeboxos.ftb.metier.sort.ComparatorByIdCarteMere;
import fr.freeboxos.ftb.metier.sort.Sort;
import java.util.List;
import lml.rest.client.ClientRest;

public class CarteMereServiceImpl extends ClientRest<CarteMere> implements CarteMereService {

    public CarteMereServiceImpl() {
        super.init("CarteMereService", new RestServerLocalConfiguration());
    }

    @Override
    public CarteMere add(CarteMere t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(CarteMere t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(CarteMere t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public CarteMere getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<CarteMere> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<CarteMere> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public CarteMere[] sort() throws Exception {
        CarteMere[] carteMeres = this.getAll().toArray(new CarteMere[0]);
        ComparatorByIdCarteMere cmp = new ComparatorByIdCarteMere();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(carteMeres, cmp);

        return carteMeres;
    }

}
