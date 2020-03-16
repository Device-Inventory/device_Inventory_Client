/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.metier;

import fr.freeboxos.ftb.metier.config.ConfigChipsetCpuService;
import fr.freeboxos.ftb.metier.config.ConfigChipsetCpuServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigFormatCarteMereService;
import fr.freeboxos.ftb.metier.config.ConfigFormatCarteMereServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigMarqueCarteMereService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueCarteMereServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigMarqueChipsetGpuService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueChipsetGpuServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigMarqueCpuService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueCpuServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigMarqueGpuService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueGpuServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigMarqueHddService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueHddServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigMarqueRamService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueRamServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigSupportDuProcesseurService;
import fr.freeboxos.ftb.metier.config.ConfigSupportDuProcesseurServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigTypeCableService;
import fr.freeboxos.ftb.metier.config.ConfigTypeCableServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigTypeMemoireService;
import fr.freeboxos.ftb.metier.config.ConfigTypeMemoireServiceImpl;
import fr.freeboxos.ftb.metier.config.ConfigTypeSsdService;
import fr.freeboxos.ftb.metier.config.ConfigTypeSsdServiceImpl;
import fr.freeboxos.ftb.metier.sort.InsertionOptimisedSort;
import fr.freeboxos.ftb.metier.sort.Sort;

/**
 *
 * @author alan
 */
public class MetierFactory {

    //Partie Entity
    private static final AutreService AUTRE_SERVICE = new AutreServiceImpl();

    public static AutreService getAutreService() {
        return AUTRE_SERVICE;
    }

    private static final CableService CABLE_SERVICE = new CableServiceImpl();

    public static CableService getCableService() {
        return CABLE_SERVICE;
    }

    private static final HddService H_DDSERVICE = new HddServiceImpl();

    public static HddService getHddService() {
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

    //Partie configuration
    private static final ConfigChipsetCpuService CONFIG_CHIPSET_CPU_SERVICE = new ConfigChipsetCpuServiceImpl();

    public static ConfigChipsetCpuService getConfigChipsetCpuService() {
        return CONFIG_CHIPSET_CPU_SERVICE;
    }

    private static final ConfigFormatCarteMereService CONFIG_FORMAT_CARTE_MERE_SERVICE = new ConfigFormatCarteMereServiceImpl();

    public static ConfigFormatCarteMereService getConfigFormatCarteMereService() {
        return CONFIG_FORMAT_CARTE_MERE_SERVICE;
    }

    private static final ConfigMarqueCarteMereService CONFIG_MARQUE_CARTE_MERE_SERVICE = new ConfigMarqueCarteMereServiceImpl();

    public static ConfigMarqueCarteMereService getConfigMarqueCarteMereService() {
        return CONFIG_MARQUE_CARTE_MERE_SERVICE;
    }

    private static final ConfigMarqueChipsetGpuService CONFIG_MARQUE_CHIPSET_GPU_SERVICE = new ConfigMarqueChipsetGpuServiceImpl();

    public static ConfigMarqueChipsetGpuService getConfigMarqueChipsetGpuService() {
        return CONFIG_MARQUE_CHIPSET_GPU_SERVICE;
    }

    private static final ConfigMarqueCpuService CONFIG_MARQUE_CPU_SERVICE = new ConfigMarqueCpuServiceImpl();

    public static ConfigMarqueCpuService getConfigMarqueCpuService() {
        return CONFIG_MARQUE_CPU_SERVICE;
    }

    private static final ConfigMarqueGpuService CONFIG_MARQUE_GPU_SERVICE = new ConfigMarqueGpuServiceImpl();

    public static ConfigMarqueGpuService getConfigMarqueGpuService() {
        return CONFIG_MARQUE_GPU_SERVICE;
    }

    private static final ConfigMarqueHddService CONFIG_MARQUE_HDD_SERVICE = new ConfigMarqueHddServiceImpl();

    public static ConfigMarqueHddService getConfigMarqueHddService() {
        return CONFIG_MARQUE_HDD_SERVICE;
    }

    private static final ConfigMarqueRamService CONFIG_MARQUE_RAM_SERVICE = new ConfigMarqueRamServiceImpl();

    public static ConfigMarqueRamService getConfigMarqueRamService() {
        return CONFIG_MARQUE_RAM_SERVICE;
    }

    private static final ConfigSupportDuProcesseurService CONFIG_SUPPORT_DU_PROCESSEUR_SERVICE = new ConfigSupportDuProcesseurServiceImpl();

    public static ConfigSupportDuProcesseurService getConfigSupportDuProcesseurService() {
        return CONFIG_SUPPORT_DU_PROCESSEUR_SERVICE;
    }

    private static final ConfigTypeCableService CONFIG_TYPE_CABLE_SERVICE = new ConfigTypeCableServiceImpl();

    public static ConfigTypeCableService getConfigTypeCableService() {
        return CONFIG_TYPE_CABLE_SERVICE;
    }

    private static final ConfigTypeMemoireService CONFIG_TYPE_MEMOIRE_SERVICE = new ConfigTypeMemoireServiceImpl();

    public static ConfigTypeMemoireService getConfigTypeMemoireService() {
        return CONFIG_TYPE_MEMOIRE_SERVICE;
    }

    private static final ConfigTypeSsdService CONFIG_TYPE_SSD_SERVICE = new ConfigTypeSsdServiceImpl();

    public static ConfigTypeSsdService getConfigTypeSsdService() {
        return CONFIG_TYPE_SSD_SERVICE;
    }
}
