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
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueCpu;
import fr.freeboxos.ftb.metier.sort.ComparatorByIdConfigMarqueCpu;
import fr.freeboxos.ftb.metier.sort.Sort;
import java.util.List;
import lml.rest.client.ClientRest;

public class ConfigMarqueCpuServiceImpl extends ClientRest<ConfigMarqueCpu> implements ConfigMarqueCpuService {

    public ConfigMarqueCpuServiceImpl() {
        super.init("ConfigMarqueCpuService", new RestServerLocalConfiguration());
    }

    @Override
    public ConfigMarqueCpu add(ConfigMarqueCpu t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(ConfigMarqueCpu t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(ConfigMarqueCpu t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public ConfigMarqueCpu getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<ConfigMarqueCpu> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<ConfigMarqueCpu> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public ConfigMarqueCpu[] sort() throws Exception {
        ConfigMarqueCpu[] configMarqueCpus = this.getAll().toArray(new ConfigMarqueCpu[0]);
        ComparatorByIdConfigMarqueCpu cmp = new ComparatorByIdConfigMarqueCpu();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(configMarqueCpus, cmp);

        return configMarqueCpus;
    }

    @Override
    public ConfigMarqueCpu getByMarque(String marque) throws Exception {
        super.setPath("marque/" + marque);
        return super.getEntity();
    }

}
