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
import fr.freeboxos.ftb.metier.entitys.config.ConfigFormatCarteMere;
import fr.freeboxos.ftb.metier.sort.Sort;
import fr.freeboxos.ftb.metier.sort.config.ComparatorByIdConfigFormatCarteMere;
import java.util.List;
import lml.rest.client.ClientRest;

/**
 *
 * @author alan
 */
public class ConfigFormatCarteMereServiceImpl extends ClientRest<ConfigFormatCarteMere> implements ConfigFormatCarteMereService {

    public ConfigFormatCarteMereServiceImpl() {
        super.init("ConfigFormatCarteMereService", new RestServerLocalConfiguration());
    }

    @Override
    public ConfigFormatCarteMere[] sort() throws Exception {
        ConfigFormatCarteMere[] configFormatCarteMeres = this.getAll().toArray(new ConfigFormatCarteMere[0]);
        ComparatorByIdConfigFormatCarteMere cmp = new ComparatorByIdConfigFormatCarteMere();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(configFormatCarteMeres, cmp);

        return configFormatCarteMeres;
    }

    @Override
    public ConfigFormatCarteMere add(ConfigFormatCarteMere t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(ConfigFormatCarteMere t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(ConfigFormatCarteMere t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public ConfigFormatCarteMere getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<ConfigFormatCarteMere> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<ConfigFormatCarteMere> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public ConfigFormatCarteMere getByFormatCarteMere(String format) throws Exception {
        super.setPath("format/" + format);
        return super.getEntity();
    }

}
