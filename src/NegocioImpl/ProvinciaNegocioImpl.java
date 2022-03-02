/*package NegocioImpl;

import java.util.ArrayList;

import Dao.ProvinciaDao;
import DaoImpl.ProvinciaDaoImpl;
import Entidad.Provincia;
import Negocio.ProvinciaNegocio;

public class ProvinciaNegocioImpl implements ProvinciaNegocio{
	ProvinciaDao udao = new ProvinciaDaoImpl();
	
	@Override
	public int agregarProvincia(Provincia provincia) {
		int estado=0;
		if(	Provincia.getIdPais()>0 && 
			provincia.getDescripcionProv.trim().length()>=0 &&
			Localidad.getIdPais()>0))
		{
			estado=prdao.agregarProvincia(provincia);
		}
		return estado;
	}

	@Override
	public ArrayList<Provincia> ListarProvincia() {
		return prdao.ListarProvincias();
	}

	@Override
	public int eliminarProvincias(int id) {
		int estado=0;
		Provincia provincia =obtenerProvincia(id);
		if(provincia.getIdProvincia()>0 )//El tema es que el ID lo maneja la base de datos. 
		{
			estado=padao.eliminarPais(id);
		}
		return estado;  //estado al ser int pregunto por el 0
	}

		@Override
	public Alumno obtenerPais(int id) {

		return null;
	}
		

}*/
