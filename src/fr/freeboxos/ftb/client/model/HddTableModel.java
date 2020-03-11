/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client.model;

import fr.freeboxos.ftb.metier.entitys.HDD;
import fr.freeboxos.ftb.metier.entitys.SSD;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class HddTableModel extends AbstractTableModel {

    private final String[] header = {"Marque", "Modèle", "Interface ordinateur", "Format", "Capacité", "Vitesse de rotation", "Cache", "Type de mémoire", "NVME", "Controleur", "Vitesse de lecture", "Vitesse d'écriture", "IOPS", "Trim", "Prix"};
    private HDD[] hdds;

    public HddTableModel(HDD[] hdds) {
        this.hdds = hdds;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.hdds.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HDD hdd = this.hdds[rowIndex];
        switch (columnIndex) {
            case 0:
                return hdd.getMarque();
            case 1:
                return hdd.getModele();
            case 2:
                return hdd.getInterface_ordinateur();
            case 3:
                return hdd.getFormat();
            case 4:
                return hdd.getCapacite();

            case 5:
                return hdd.getVitesse_de_rotation();

            case 6:
                return hdd.getCache();

            case 7:
                String type = null;
                if (hdd instanceof SSD) {
                    SSD ssd = (SSD) hdd;
                    type = ssd.getType_memoire();
                }
                return type;

            case 8:
                boolean nvme = false;
                if (hdd instanceof SSD) {
                    SSD ssd = (SSD) hdd;
                    nvme = ssd.isNvme();
                }
                return nvme;

            case 9:
                String controleur = null;
                if (hdd instanceof SSD) {
                    SSD ssd = (SSD) hdd;
                    controleur = ssd.getControleur();
                }
                return controleur;

            case 10:
                String lecture = null;
                if (hdd instanceof SSD) {
                    SSD ssd = (SSD) hdd;
                    lecture = ssd.getLecture();
                }
                return lecture;

            case 11:
                String ecriture = null;
                if (hdd instanceof SSD) {
                    SSD ssd = (SSD) hdd;
                    ecriture = ssd.getEcriture();
                }
                return ecriture;

            case 12:
                long iops = 0;
                if (hdd instanceof SSD) {
                    SSD ssd = (SSD) hdd;
                    iops = ssd.getIops(); //Conversion long en string
                }
                return iops;

            case 13:
                boolean trim = false;
                if (hdd instanceof SSD) {
                    SSD ssd = (SSD) hdd;
                    trim = ssd.isTrim();
                }
                return trim;

            case 14:
                return hdd.getPrix();

            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 8:
            case 13:
                return Boolean.class;
            case 12:
                return Long.class;
            default:
                return String.class;
        }
    }

    public HDD getHddAt(int rowIndex) {
        return this.hdds[rowIndex];
    }

    public void update(HDD[] hdds) {
        this.hdds = hdds;
        this.fireTableDataChanged();
    }
}
