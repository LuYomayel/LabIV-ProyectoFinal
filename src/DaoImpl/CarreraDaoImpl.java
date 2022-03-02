package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Dao.CarreraDao;
import Entidad.Alumno;
import Entidad.Carrera;

public class CarreraDaoImpl implements CarreraDao {
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "root";  // "root"
	private static String dbName = "dbutn2";
	
	@Override
	public int getIdCarrera(String nombreCarrera) {
		Connection cn = null;
		int id = -1;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "select IdCarrera from Carreras where Descripcion_Carrera= '"+nombreCarrera+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				id = rs.getInt("idCarrera");
				
			}
			
			
		}catch(Exception e) {
			System.out.println("ERROR XD");
			e.printStackTrace();
		}
		return id;
	}
	
}
