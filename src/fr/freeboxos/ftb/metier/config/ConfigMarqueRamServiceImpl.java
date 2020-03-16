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
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueRam;
import fr.freeboxos.ftb.metier.sort.Sort;
import fr.freeboxos.ftb.metier.sort.config.ComparatorByIdConfigMarqueRam;
import java.util.List;
import lml.rest.client.ClientRest;

public class ConfigMarqueRamServiceImpl extends ClientRest<ConfigMarqueRam> implements ConfigMarqueRamService {

    public ConfigMarqueRamServiceImpl() {
        super.init("ConfigMarqueRamService", new RestServerLocalConfiguration());
    }

    @Override
    public ConfigMarqueRam[] sort() throws Exception {
        ConfigMarqueRam[] configMarqueRams = this.getAll().toArray(new ConfigMarqueRam[0]);
        ComparatorByIdConfigMarqueRam cmp = new ComparatorByIdConfigMarqueRam();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(configMarqueRams, cmp);

        return configMarqueRams;
    }

    @Override
    public ConfigMarqueRam add(ConfigMarqueRam t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(ConfigMarqueRam t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(ConfigMarqueRam t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public ConfigMarqueRam getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<ConfigMarqueRam> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<ConfigMarqueRam> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

}
