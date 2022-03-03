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
import DaoImpl.AlumnoxcursoDaoImpl;
import DaoImpl.CursoDaoImpl;
import DaoImpl.DocenteDaoImpl;
import DaoImpl.MateriaDaoImpl;
import Entidad.Alumno;
import Entidad.Alumnoxcurso;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Materia;
import Negocio.AlumnoxcursoNegocio;
import NegocioImpl.AlumnoNegocioImpl;
import NegocioImpl.AlumnoxcursoNegocioImpl;
import NegocioImpl.CursoNegocioImpl;
import NegocioImpl.DocenteNegocioImpl;
import NegocioImpl.MateriaNegocioImpl;

/**
 * Servlet implementation class ServletCursos
 */
@WebServlet("/ServletMaterias")
public class ServletMaterias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMaterias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Materias")!= null) {
			
			MateriaNegocioImpl materiaNegocio = new MateriaNegocioImpl();
			ArrayList<Materia> listaMaterias = materiaNegocio.listarMaterias();
			
			request.setAttribute("listaMaterias", listaMaterias);
			RequestDispatcher rd = request.getRequestDispatcher("/Materias.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("AgregarMateria")!=null) {
			MateriaNegocioImpl materiaNegocio = new MateriaNegocioImpl();
			Materia materia = new Materia();
			materia.setNombreMateria(request.getParameter("Materia"));
			int estado = materiaNegocio.agregarMateria(materia);
			
			ArrayList<Materia> listaMaterias = materiaNegocio.listarMaterias();
			
			request.setAttribute("estadoAgregar", estado);
			request.setAttribute("listaMaterias", listaMaterias);
			RequestDispatcher rd = request.getRequestDispatcher("/Materias.jsp");
			rd.forward(request, response);
		}
	}

}
