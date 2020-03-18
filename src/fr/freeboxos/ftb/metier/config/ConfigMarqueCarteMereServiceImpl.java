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
package fr.freeboxos.ftb.metier.config;

import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.RestServerLocalConfiguration;
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueCarteMere;
import fr.freeboxos.ftb.metier.sort.Sort;
import fr.freeboxos.ftb.metier.sort.config.ComparatorByIdConfigMarqueCarteMere;
import java.util.List;
import lml.rest.client.ClientRest;

public class ConfigMarqueCarteMereServiceImpl extends ClientRest<ConfigMarqueCarteMere> implements ConfigMarqueCarteMereService {

    public ConfigMarqueCarteMereServiceImpl() {
        super.init("ConfigMarqueCarteMereService", new RestServerLocalConfiguration());
    }

    @Override
    public ConfigMarqueCarteMere[] sort() throws Exception {
        ConfigMarqueCarteMere[] configMarqueCarteMeres = this.getAll().toArray(new ConfigMarqueCarteMere[0]);
        ComparatorByIdConfigMarqueCarteMere cmp = new ComparatorByIdConfigMarqueCarteMere();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(configMarqueCarteMeres, cmp);

        return configMarqueCarteMeres;
    }

    @Override
    public ConfigMarqueCarteMere add(ConfigMarqueCarteMere t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(ConfigMarqueCarteMere t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(ConfigMarqueCarteMere t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public ConfigMarqueCarteMere getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<ConfigMarqueCarteMere> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<ConfigMarqueCarteMere> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public ConfigMarqueCarteMere getByMarqueCarteMere(String s) throws Exception {
        super.setPath("marque/" + s);
        return super.getEntity();
    }

}
