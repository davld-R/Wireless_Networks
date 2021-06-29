package proxy1;

import java.io.Serializable;
/**
 *
 * @author David
 */
public class Intento implements Serializable{
    String usuario, comando, mensaje;
        
        public Intento(String Usuario, String comando, String mensaje){
            this.usuario = Usuario;
            this.comando = comando;
            this.mensaje = mensaje;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getComando() {
            return comando;
        }

        public void setComando(String comando) {
            this.comando = comando;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    
}
