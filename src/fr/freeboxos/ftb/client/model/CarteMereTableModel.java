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
package fr.freeboxos.ftb.client.model;

import fr.freeboxos.ftb.metier.entitys.CarteMere;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class CarteMereTableModel extends AbstractTableModel {

    private final String[] header = {"Marque", "Modèle", "Désignation"}; //todo : finir de remplir le header
    private CarteMere[] carteMeres;

    public CarteMereTableModel(CarteMere[] carteMeres) {
        this.carteMeres = carteMeres;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.carteMeres.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { //todo : finir de remplir le switch case
        CarteMere carteMere = this.carteMeres[rowIndex];
        switch (columnIndex) {
            case 0:
                List<String> marqueList = carteMere.getMarque();
                String marque = null;
                for (int i = 0; i < marqueList.size(); i++) {
                    if (i == 0) {
                        marque = marqueList.get(i);
                    } else {
                        marque = marque + " " + marqueList.get(i);
                    }
                }
                return marque;
            case 1:
                return carteMere.getModele();
            case 2:
                return carteMere.getDesignation();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            default:
                return false;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) { //todo : remplir le switch case
        switch (columnIndex) {
            case 0:
                return List.class;
            default:
                return String.class;
        }
    }

    public CarteMere getCarteMereAt(int rowIndex) {
        return this.carteMeres[rowIndex];
    }

    public void update(CarteMere[] carteMeres) {
        this.carteMeres = carteMeres;
        this.fireTableDataChanged();
    }

}
