/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client;

import javax.swing.JFrame;

/**
 *
 * @author alan
 */
public class ClientFactory {

    private ClientFactory() {
    }

    private static JFrame ihm = null;

    public static JFrame getIhm() throws Exception {
        if (ClientFactory.ihm == null) {
            ClientFactory.ihm = new LoginIhm();
        }
        return ClientFactory.ihm;
    }

}
