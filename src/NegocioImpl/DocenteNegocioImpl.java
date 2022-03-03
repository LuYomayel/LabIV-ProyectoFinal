package NegocioImpl;

import java.util.ArrayList;

import Dao.DocenteDao;
import DaoImpl.DocenteDaoImpl;
import Entidad.Docente;
import Negocio.DocenteNegocio;

public class DocenteNegocioImpl implements DocenteNegocio{
	DocenteDao ddao = new DocenteDaoImpl();
	
	@Override
	public int agregarDocente(Docente docente) {
		int estado=-1;
		if(docente.getLegajo()>0 && 
				docente.getDni().trim().length()>0 &&
				docente.getNombre().trim().length()>0 &&
				docente.getApellido().trim().length()>0 &&
				docente.getFechanacimiento().trim().length()>0 &&
				docente.getDireccion().trim().length()>0 &&
				docente.getLocalidad().trim().length()>0 &&
				docente.getNacionalidad().trim().length()>0 &&
				docente.getProvincia().trim().length()>0 &&
				docente.getEmail().trim().length()>0 &&
				docente.getTelefono().trim().length()>0) 
		{
			estado=ddao.agregarDocente(docente);
		}
		System.out.println("Estado:" + estado);
		return estado;
	}

	@Override
	public ArrayList<Docente> ListarDocentes() {
		return ddao.ListarDocentes();
	}

	@Override
	public int eliminarDocente(int id) {
		int estado=-1;
		DocenteDaoImpl docenteDao = new DocenteDaoImpl();
		Docente docente = docenteDao.getDocente(id);
		if(docente.getLegajo()>0 )//El tema es que el ID lo maneja la base de datos. 
		{
			estado=ddao.eliminarDocente(id);
		}
		
		return estado;  
	}

	@Override
	public Docente obtenerDocente(String apellido) {
		Docente docente = new Docente();
		docente = obtenerDocente(apellido);
		if(docente.getLegajo()>0 )
		{
			docente=ddao.obtenerDocente(apellido);
		}
		return docente; 
	}

	@Override
	public Docente obtenerIdDocente(String mail) {
		Docente docente = new Docente();
		//Docente docente = obtenerIdDocente(mail);
		if(docente.getLegajo()>0 )
		{
			//docente=ddao.obtenerIdDocente(mail);
		}
		return docente; 
	}

	@Override
	public Docente obtenerDocente(int legajo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modificarDocente(Docente docente) {
		int estado=-1;
		if(docente.getLegajo()>0 && 
				docente.getDni().trim().length()>0 &&
				docente.getNombre().trim().length()>0 &&
				docente.getApellido().trim().length()>0 &&
				docente.getFechanacimiento().trim().length()>0 &&
				docente.getDireccion().trim().length()>0 &&
				docente.getLocalidad().trim().length()>0 &&
				docente.getNacionalidad().trim().length()>0 &&
				docente.getProvincia().trim().length()>0 &&
				docente.getEmail().trim().length()>0 &&
				docente.getTelefono().trim().length()>0) 
		{
			estado=ddao.modificarDocente(docente);
		}
		System.out.println("Estado:" + estado);
		return estado;
	}

}
