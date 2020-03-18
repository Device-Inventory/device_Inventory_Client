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
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueGpu;
import fr.freeboxos.ftb.metier.sort.Sort;
import fr.freeboxos.ftb.metier.sort.config.ComparatorByIdConfigMarqueGpu;
import java.util.List;
import lml.rest.client.ClientRest;

public class ConfigMarqueGpuServiceImpl extends ClientRest<ConfigMarqueGpu> implements ConfigMarqueGpuService {

    public ConfigMarqueGpuServiceImpl() {
        super.init("ConfigMarqueGpuService", new RestServerLocalConfiguration());
    }

    @Override
    public ConfigMarqueGpu[] sort() throws Exception {
        ConfigMarqueGpu[] configMarqueGpus = this.getAll().toArray(new ConfigMarqueGpu[0]);
        ComparatorByIdConfigMarqueGpu cmp = new ComparatorByIdConfigMarqueGpu();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(configMarqueGpus, cmp);

        return configMarqueGpus;
    }

    @Override
    public ConfigMarqueGpu add(ConfigMarqueGpu t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(ConfigMarqueGpu t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(ConfigMarqueGpu t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public ConfigMarqueGpu getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<ConfigMarqueGpu> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<ConfigMarqueGpu> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public ConfigMarqueGpu getByMarqueGpu(String s) throws Exception {
        super.setPath("marque/" + s);
        return super.getEntity();
    }

}
