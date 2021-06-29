/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

/**
 *
 * @author Freyder
 */
public class SesionValidacion {

    public static boolean validarUsuario(String usuario) {
        return usuario.isEmpty() && noEsNumerico(usuario);
    }

    private static boolean noEsNumerico(String palabra) {
        return palabra.matches("[0-9]*");
    }

    public static boolean contraseña(String password) {
        return password.isEmpty() && tamano(password);
    }

    private static boolean tamano(String password) {
        return password.length()<8;
    }
}
