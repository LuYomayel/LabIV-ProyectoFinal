package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.MateriaDao;
import Entidad.Alumno;
import Entidad.Materia;

public class MateriaDaoImpl implements MateriaDao{
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "root"; // "root"
	private static String dbName = "dbutn2";
	
	@Override
	public ArrayList<Materia> listarMaterias() {
		ArrayList<Materia> listaMaterias = new ArrayList<Materia>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			String query = "select idMateria, Descripcion_Materia from Materias"; 
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				
				Materia x = new Materia(rs.getInt("idMateria"),rs.getString("Descripcion_Materia"));
				
						
				listaMaterias.add(x);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listaMaterias;
	}

}
