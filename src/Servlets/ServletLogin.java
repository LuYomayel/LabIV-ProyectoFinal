package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImpl.AlumnoDaoImpl;
import DaoImpl.CursoDaoImpl;
import DaoImpl.DocenteDaoImpl;
import DaoImpl.UsuarioDaoImpl;
import Entidad.Alumno;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("CerrarSesion")!=null) {
			HttpSession session = request.getSession();
			session.removeAttribute("docente");
			session.removeAttribute("admin");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");   
	        rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAceptar")!=null) {
			HttpSession session = request.getSession();
			String user = request.getParameter("usuario");
			String pass = request.getParameter("contrasena");
			Usuario usuario = new Usuario();
			usuario.setContrasena(pass);
			usuario.setUsuario(user);
			
			UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
			int login = usuarioDao.obtenerUsuario(usuario); 
			if (login == 1) {
				
				DocenteDaoImpl docenteDao = new DocenteDaoImpl();
				int idDocente = docenteDao.obtenerIdDocente(usuario.getUsuario());
				CursoDaoImpl cursoDao = new CursoDaoImpl();
				AlumnoDaoImpl alumnoDao = new AlumnoDaoImpl();
				ArrayList<Curso> listaCursos = new ArrayList<Curso>();
				listaCursos = cursoDao.listarCursos(idDocente);
				for(Curso curso : listaCursos) {
					curso.setAlumno(alumnoDao.ListarAlumnosCurso(curso.getId()));
				}
				Docente docente  = docenteDao.getDocente(idDocente);
				session.setAttribute("idDocenteSesion", idDocente);
				session.setAttribute("docente", docente);
				request.setAttribute("listaC", listaCursos);
				session.setAttribute("sesion", 1);
				RequestDispatcher rd = request.getRequestDispatcher("/ListadoCursos.jsp");   
		        rd.forward(request, response);
			}
			else if(login == 0){
				request.setAttribute("error", false);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");   
		        rd.forward(request, response);
			}else if(login ==2) {
				System.out.println(usuario.getUsuario());
				session.setAttribute("admin", usuario);
				session.setAttribute("sesion", 2);
				RequestDispatcher rd = request.getRequestDispatcher("/IndexAdministrador.jsp");   
		        rd.forward(request, response);
			}
			
		}
		
	}

}
