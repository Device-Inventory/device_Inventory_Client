/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.metier;

import fr.freeboxos.ftb.metier.config.ConfigMarqueCpuService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueCpuServiceImpl;
import fr.freeboxos.ftb.metier.sort.InsertionOptimisedSort;
import fr.freeboxos.ftb.metier.sort.Sort;

/**
 *
 * @author alan
 */
public class MetierFactory {

    private static final AutreService AUTRE_SERVICE = new AutreServiceImpl();

    public static AutreService getAutreService() {
        return AUTRE_SERVICE;
    }

    private static final CableService CABLE_SERVICE = new CableServiceImpl();

    public static CableService getCableService() {
        return CABLE_SERVICE;
    }

    private static final HddService H_DDSERVICE = new HddServiceImpl();

    public static HddService getHDDService() {
        return H_DDSERVICE;
    }

    private static final MemoireService MEMOIRE_SERVICE = new MemoireServiceImpl();

    public static MemoireService getMemoireService() {
        return MEMOIRE_SERVICE;
    }

    private static final ProcesseurService PROCESSEUR_SERVICE = new ProcesseurServiceImpl();

    public static ProcesseurService getProcesseurService() {
        return PROCESSEUR_SERVICE;
    }

    private static final AdministrateurService ADMINISTRATEUR_SERVICE = new AdministrateurServiceImpl();

    public static AdministrateurService getAdministrateurService() {
        return ADMINISTRATEUR_SERVICE;
    }

    private static final OrdinateurService ORDINATEUR_SERVICE = new OrdinateurServiceImpl();

    public static OrdinateurService getOrdinateurService() {
        return ORDINATEUR_SERVICE;
    }

    private static final Sort SORT = new InsertionOptimisedSort();

    public static Sort getSortSerivce() {
        return SORT;
    }

    private static final CarteGraphiqueService CARTE_GRAPHIQUE_SERVICE = new CarteGraphiqueServiceImpl();

    public static CarteGraphiqueService getCarteGraphiqueService() {
        return CARTE_GRAPHIQUE_SERVICE;
    }

    private static final CarteMereService CARTE_MERE_SERVICE = new CarteMereServiceImpl();

    public static CarteMereService getCarteMereService() {
        return CARTE_MERE_SERVICE;
    }

    private static final ConfigMarqueCpuService CONFIG_MARQUE_CPU_SERVICE = new ConfigMarqueCpuServiceImpl();

    public static ConfigMarqueCpuService getConfigMarqueCpuService() {
        return CONFIG_MARQUE_CPU_SERVICE;
    }
}
