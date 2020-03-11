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
package fr.freeboxos.ftb.client.observable;

import fr.freeboxos.ftb.client.ihm.ChargementIhm;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;

/**
 *
 * @author alan
 */
public class Chargement extends Observable implements WindowListener {

    private ChargementIhm chargementIHM;

    public void execute() {
        this.chargementIHM = new ChargementIhm();
        this.chargementIHM.addWindowListener(this);
        this.chargementIHM.setLocationRelativeTo(null);
        this.chargementIHM.setVisible(true);

    }

    void setData(Data data) {
        if (data != null) {
            this.setChanged();
            this.notifyObservers(data);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        Data data = this.chargementIHM.getD();
        this.setData(data);
        this.chargementIHM.setVisible(false);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
