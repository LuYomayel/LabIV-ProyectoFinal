package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import Dao.UsuarioDao;
import Entidad.Alumno;
import Entidad.Docente;
import Entidad.Usuario;


public class UsuarioDaoImpl implements UsuarioDao{
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "root";// "root";
	private static String dbName = "dbutn2";
	
	
	@Override
	public int obtenerUsuario(Usuario usuario) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		Usuario x = new Usuario();
		Connection cn = null;
		int login = 0 ;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			//String query = "select u.contrasenia contrasenia, d.email, u.usuario_administrador administrador from usuarios u join docentes d on d.idDocente = u.idDocente_Usuario where u.IdDocente_Usuario = "+;
			//ResultSet rs = st.executeQuery(query);
			//rs.next();
			
			DocenteDaoImpl docente = new DocenteDaoImpl();
			int id = docente.obtenerIdDocente(usuario.getUsuario());
			System.out.println(id);
			if(id > 0) {
				String query = "select u.contrasenia contrasenia, u.IdDocente_Usuario from usuarios u where u.IdDocente_Usuario =" + id;
				ResultSet rs = st.executeQuery(query);
				rs.next();
				String contra = rs.getString("contrasenia");
				String contra2 = usuario.getContrasena();
				System.out.println(contra);
				System.out.println(contra2);
				if(contra.equals(contra2)) {
					System.out.println("Entre");
					login = 1;
				} else login = 0;
			} 
			else {
				UsuarioDaoImpl us = new UsuarioDaoImpl();
				boolean admin = us.obtenerAdmin(usuario);
				if(admin) login =2;
				else login =0;
			}
			//x.setTelefono(rs.getString("telefono"));			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(login);
		return login;
	}


	@Override
	public boolean obtenerAdmin(Usuario usuario) {
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "select u.contrasenia contrasenia, u.usuario_administrador admin from usuarios u where u.usuario_administrador ='" + usuario.getUsuario()+"'";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			if(rs.getString("contrasenia").equals(usuario.getContrasena()) && rs.getString("admin").equals(usuario.getUsuario())) {
				return true;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}


	@Override
	public void agregarDocente(Docente docente) {
		System.out.println(docente.getContraseña());
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		int filas =0;
		DocenteDaoImpl dao = new DocenteDaoImpl();
		int id = dao.obtenerIdDocentexLegajo(docente);
		System.out.println(id);
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			String query = "insert into usuarios(idDocente_Usuario,contrasenia)values("+id+",'"+docente.getContraseña()+"')";
			filas = st.executeUpdate(query);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
}
