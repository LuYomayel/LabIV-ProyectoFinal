/*package NegocioImpl;

import java.util.ArrayList;

import Dao.UsuarioDao;
import DaoImpl.UsuarioDaoImpl;
import Entidad.Usuario;
import Negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{
	UsuarioDao udao = new UsuarioDaoImpl();
	
	@Override
	public int agregarUsuario(Usuario usuario) {
		int estado=0;
		if(	usuario.getUsuario()>0 && 
				usuario.getContrasena()>=0)
		{
			estado=udao.agregarUsuario(usuario);
		}
		return estado;
	}

	@Override
	public ArrayList<Usuario> ListarUsuarios() {
		return udao.ListarUsuarios();
	}

	@Override
	public int eliminarUsuario(int id) {
		int estado=0;
		Usuario usuario =obtenerUsuario(id);
		if(usuario.getUsuario()>0 )//El tema es que el ID lo maneja la base de datos. 
		{
			estado=udao.eliminarUsuario(id);
		}
		return estado;  //estado al ser int pregunto por el 0
	}

		@Override
	public Alumno obtenerAdmin(String apellido) {

		return null;
	}
		@Override
	public Alumno obtenerUsuario(int id) {
	return null;
	}

}*/
