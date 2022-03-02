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
import DaoImpl.DocenteDaoImpl;
import DaoImpl.UsuarioDaoImpl;
import Entidad.Alumno;
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
				DocenteDaoImpl daoDocente = new	DocenteDaoImpl();
				int idDocente = daoDocente.obtenerIdDocente(usuario.getUsuario());
				System.out.println("idDocente: "+ idDocente);
				AlumnoDaoImpl dao = new AlumnoDaoImpl();
				ArrayList<Alumno> lista= dao.ListarAlumnos();
				request.setAttribute("listaA", lista);
				session.setAttribute("sesion", 1);
				session.setAttribute("idDocenteSesion", idDocente);
				RequestDispatcher rd = request.getRequestDispatcher("/ListadoAlumnos.jsp");   
		        rd.forward(request, response);
			}
			else if(login == 0){
				request.setAttribute("error", false);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");   
		        rd.forward(request, response);
			}else if(login ==2) {
				session.setAttribute("sesion", 2);
				RequestDispatcher rd = request.getRequestDispatcher("/IndexAdministrador.jsp");   
		        rd.forward(request, response);
			}
			
		}
	}

}
