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

import fr.freeboxos.ftb.metier.entitys.CarteGraphique;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class CarteGraphiqueTableModel extends AbstractTableModel {

    private final String[] header = {"Marque", "Modèle", "Chipset graphique", "Marque chipset", "Fréquence", "Overclocker", "Nombre de GPU", "Bus", "Taille mémoire", "Interface mémoire", "Type de mémoire", "Connecteur d'alimentation", "Consommation", "Prix"};
    private CarteGraphique[] carteGraphiques;

    public CarteGraphiqueTableModel(CarteGraphique[] carteGraphiques) {
        this.carteGraphiques = carteGraphiques;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.carteGraphiques.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CarteGraphique carteGraphique = this.carteGraphiques[rowIndex];
        switch (columnIndex) {
            case 0:
                return carteGraphique.getMarque();
            case 1:
                return carteGraphique.getModele();
            case 2:
                return carteGraphique.getChipsetGraphique();
            case 3:
                return carteGraphique.getMarqueChipset();
            case 4:
                return carteGraphique.getFrequence();
            case 5:
                return carteGraphique.isOverclockee();
            case 6:
                return carteGraphique.getNombreGpu();
            case 7:
                return carteGraphique.getBus();
            case 8:
                return carteGraphique.getTailleMemoire() + " " + carteGraphique.getUniteMemoire();
            case 9:
                return carteGraphique.getInterfaceMemoire() + " bit(s)";
            case 10:
                return carteGraphique.getTypeMemoire();
            case 11:
                return carteGraphique.getConnecteurAlimentation();
            case 12:
                return carteGraphique.getConsommation() + " W";
            case 13:
                return carteGraphique.getPrix() + " €";
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
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 4:
            case 6:
            case 8:
            case 9:
            case 12:
                return Integer.class;
//            case 13:
//                return Float.class;
            case 5:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    public CarteGraphique getCarteGraphiqueAt(int rowIndex) {
        return this.carteGraphiques[rowIndex];
    }

    public void update(CarteGraphique[] carteGraphiques) {
        this.carteGraphiques = carteGraphiques;
        this.fireTableDataChanged();
    }

}
