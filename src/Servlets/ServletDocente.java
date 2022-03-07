package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.AlumnoDaoImpl;
import DaoImpl.DocenteDaoImpl;
import DaoImpl.LocalidadDaoImpl;
import DaoImpl.PaisDaoImpl;
import DaoImpl.ProvinciaDaoImpl;
import Entidad.Alumno;
import Entidad.Docente;
import Entidad.Localidad;
import Entidad.Pais;
import Entidad.Provincia;
import NegocioImpl.DocenteNegocioImpl;


/**
 * Servlet implementation class ServletDocente
 */
@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Agregar")!=null) {
			int legajo = 1000;
			DocenteNegocioImpl docenteNegocio = new DocenteNegocioImpl();
			ArrayList<Docente> lista= docenteNegocio.ListarDocentes();
			request.setAttribute("listaA", lista);
			
			if(lista != null) {
				for(Docente docente : lista) {
					if(docente.getLegajo()>legajo) legajo = docente.getLegajo();
					
				}
				
			}
			legajo++;
			
			request.setAttribute("legajo", legajo);
			
			PaisDaoImpl pDao = new PaisDaoImpl();
			ArrayList<Pais> listaPais = pDao.ListarPais();
			ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
			ArrayList<Provincia> listaProv = provDao.ListarProvincia();
			LocalidadDaoImpl lDao = new LocalidadDaoImpl();
			ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();
			request.setAttribute("ListarProvincia", listaProv);
			request.setAttribute("ListarPais", listaPais);
			request.setAttribute("ListarLocalidad", listaLocal);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarProfesores.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("Modificar")!= null) {
			DocenteNegocioImpl docenteNegocio = new DocenteNegocioImpl();
			ArrayList<Docente> lista= docenteNegocio.ListarDocentes();
			request.setAttribute("listaD", lista);
			PaisDaoImpl pDao = new PaisDaoImpl();
			ArrayList<Pais> listaPais = pDao.ListarPais();
			ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
			ArrayList<Provincia> listaProv = provDao.ListarProvincia();
			LocalidadDaoImpl lDao = new LocalidadDaoImpl();
			ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();
			request.setAttribute("ListarProvincia", listaProv);
			request.setAttribute("ListarPais", listaPais);
			request.setAttribute("ListarLocalidad", listaLocal);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarProfesor.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("Param")!= null) {
			DocenteNegocioImpl docenteNegocio = new DocenteNegocioImpl();
			ArrayList<Docente> lista= docenteNegocio.ListarDocentes();
			request.setAttribute("listaD", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoProfesores.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAgregar") !=null){
			Docente docente = new Docente();
			DocenteNegocioImpl docenteNegocio = new DocenteNegocioImpl();
			
			docente.setLegajo(Integer.parseInt(request.getParameter("Legajo")));
			docente.setDni(request.getParameter("txtDni"));
			docente.setNombre(request.getParameter("txtNombre"));
			docente.setApellido(request.getParameter("txtApellido"));
			docente.setFechanacimiento(request.getParameter("txtFecha"));
			docente.setDireccion(request.getParameter("txtDireccion"));
			docente.setNacionalidad(request.getParameter("Nacionalidad"));
			docente.setProvincia(request.getParameter("Provincia"));
			docente.setLocalidad(request.getParameter("Localidad"));
			docente.setEmail(request.getParameter("txtEmail"));
			docente.setContraseña(request.getParameter("txtContraseña"));
			docente.setTelefono(request.getParameter("txtTelefono"));
			
			int estado = docenteNegocio.agregarDocente(docente);
			
			PaisDaoImpl pDao = new PaisDaoImpl();
			ArrayList<Pais> listaPais = pDao.ListarPais();
			ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
			ArrayList<Provincia> listaProv = provDao.ListarProvincia();
			LocalidadDaoImpl lDao = new LocalidadDaoImpl();
			ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();

			request.setAttribute("ListarProvincia", listaProv);
			request.setAttribute("ListarPais", listaPais);
			request.setAttribute("ListarLocalidad", listaLocal);
			request.setAttribute("estadoAgregar", estado);
			
			int legajo = Integer.parseInt(request.getParameter("Legajo"));
			legajo++;
			request.setAttribute("legajo", legajo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarProfesores.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnModificar") !=null){
			//System.out.println(request.getParameter("idAlumno"));
			Docente doc = new Docente();
			DocenteNegocioImpl docenteNegocio = new DocenteNegocioImpl();
			DocenteDaoImpl dao = new DocenteDaoImpl();
			
			doc.setLegajo(Integer.parseInt(request.getParameter("idDocente")));
			doc.setDni(request.getParameter("dniDocente"));
			doc.setNombre(request.getParameter("NombreDocente"));
			doc.setApellido(request.getParameter("ApellidoDocente"));
			doc.setFechanacimiento(request.getParameter("NacDocente"));
			doc.setDireccion(request.getParameter("DireccionDocente"));
			doc.setNacionalidad(request.getParameter("Nacionalidad"));
			doc.setProvincia(request.getParameter("Provincia"));
			doc.setLocalidad(request.getParameter("Localidad"));
			doc.setEmail(request.getParameter("EmailDocente"));
			doc.setTelefono(request.getParameter("TelefonoDocente"));
			
			int estado = docenteNegocio.modificarDocente(doc);
			PaisDaoImpl pDao = new PaisDaoImpl();
			ArrayList<Pais> listaPais = pDao.ListarPais();
			ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
			ArrayList<Provincia> listaProv = provDao.ListarProvincia();
			LocalidadDaoImpl lDao = new LocalidadDaoImpl();
			ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();

			request.setAttribute("ListarProvincia", listaProv);
			request.setAttribute("ListarPais", listaPais);
			request.setAttribute("ListarLocalidad", listaLocal);
			request.setAttribute("estadoModificar", estado);
			
			ArrayList<Docente> lista= docenteNegocio.ListarDocentes();
			request.setAttribute("listaD", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoProfesores.jsp");
			rd.forward(request, response);
				
				
			
		}
		if(request.getParameter("btnEliminar")!=null)
		{
			
			String aux = request.getParameter("idDocente").toString();
			
			int id = Integer.parseInt(request.getParameter("idDocente").toString()) ;
			DocenteNegocioImpl docenteNegocio = new DocenteNegocioImpl();
			int estado = docenteNegocio.eliminarDocente(id);
			
            ArrayList<Docente> lista= docenteNegocio.ListarDocentes();
			request.setAttribute("listaD", lista);
			request.setAttribute("estadoEliminar", estado);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoProfesores.jsp");   
	        rd.forward(request, response);
		}
	}

}
