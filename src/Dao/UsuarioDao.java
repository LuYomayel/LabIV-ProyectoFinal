package Dao;

import Entidad.Usuario;
import Entidad.Docente;
public interface UsuarioDao {
	public int obtenerUsuario(Usuario usuario);
	public boolean obtenerAdmin (Usuario usuario);
	public void agregarDocente(Docente docente);
}
