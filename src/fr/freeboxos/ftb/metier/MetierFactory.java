/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.metier;

import fr.freeboxos.ftb.metier.sort.InsertionOptimisedSort;
import fr.freeboxos.ftb.metier.sort.Sort;

/**
 *
 * @author alan
 */
public class MetierFactory {

    private static final AutreService autreService = new AutreServiceImpl();

    public static AutreService getAutreService() {
        return autreService;
    }

    private static final CableService cableService = new CableServiceImpl();

    public static CableService getCableService() {
        return cableService;
    }

    private static final HDDService hddService = new HDDServiceImpl();

    public static HDDService getHDDService() {
        return hddService;
    }

    private static final MemoireService memoireService = new MemoireServiceImpl();

    public static MemoireService getMemoireService() {
        return memoireService;
    }

    private static final ProcesseurService processeurService = new ProcesseurServiceImpl();

    public static ProcesseurService getProcesseurService() {
        return processeurService;
    }

    private static final AdministrateurService administrateurService = new AdministrateurServiceImpl();

    public static AdministrateurService getAdministrateurService() {
        return administrateurService;
    }

    private static final Sort sortSrv = new InsertionOptimisedSort();

    public static Sort getSortSerivce() {
        return sortSrv;
    }
}
