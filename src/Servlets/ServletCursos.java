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
import DaoImpl.MateriaDaoImpl;
import Entidad.Alumno;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Materia;

/**
 * Servlet implementation class ServletCursos
 */
@WebServlet("/ServletCursos")
public class ServletCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("Agregar")!=null) {
			MateriaDaoImpl dao = new MateriaDaoImpl();
			ArrayList<Materia> listaMaterias = dao.listarMaterias();
			DocenteDaoImpl daoDoc = new DocenteDaoImpl();
			ArrayList<Docente> listaDocente = daoDoc.ListarDocentes();
			request.setAttribute("listaMaterias", listaMaterias);
			request.setAttribute("listaDocente", listaDocente);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregadoCursado.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Listar")!=null) {
			CursoDaoImpl cursoDao = new CursoDaoImpl();
			AlumnoDaoImpl alumnoDao = new AlumnoDaoImpl();
			ArrayList<Curso> listaCursos = new ArrayList<Curso>();
			listaCursos = cursoDao.listarCursos((int)session.getAttribute("idDocenteSesion"));
			for(Curso curso : listaCursos) {
				curso.setAlumno(alumnoDao.ListarAlumnosCurso(curso.getId()));
			}
			
			request.setAttribute("listaC", listaCursos);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoCursos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("AgregarAlumnos") != null) {
			
			AlumnoDaoImpl daoAlumno = new AlumnoDaoImpl();
			ArrayList<Alumno> listaAlumnos = daoAlumno.ListarAlumnos();
			ArrayList<Alumno> listaAlumnosACursado = new ArrayList<Alumno>();
			if(session.getAttribute("listaAlumnosACursado")!= null) {
				listaAlumnosACursado = (ArrayList<Alumno>) session.getAttribute("listaAlumnosACursado");
			}
			request.setAttribute("listaAlumnos", listaAlumnos);
			session.setAttribute("listaAlumnosACursado", listaAlumnosACursado);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumnosACursado.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("btnAgregar") != null) {
			ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
			try {
			if(session.getAttribute("listaAlumnosACursado") != null) {
				
				ArrayList<Alumno> listaAlumnos1 = new ArrayList<Alumno>();
				AlumnoDaoImpl daoAlumno = new AlumnoDaoImpl();
				Alumno al = daoAlumno.getAlumno(Integer.parseInt(request.getParameter("idAlumno")));
				
				listaAlumnos1 = (ArrayList<Alumno>) session.getAttribute("listaAlumnosACursado");
				
				int cont = 0;
				
				for(Alumno ala : listaAlumnos1) {
					
					if(ala.equals(al)) {
						cont++;
					}
					
					
				}
				if(cont<1) {
					listaAlumnos1.add(al);
				}
				
				listaAlumnos = listaAlumnos1;
			}else {
				
				//session.setAttribute("listaAlumnosACursado", listaAlumnos);
			}
			
			AlumnoDaoImpl daoAlumno = new AlumnoDaoImpl();
			ArrayList<Alumno> listaAlumnosCompleta = daoAlumno.ListarAlumnos();
			request.setAttribute("listaAlumnos", listaAlumnosCompleta);
			session.setAttribute("listaAlumnosACursado", listaAlumnos);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumnosACursado.jsp");
			rd.forward(request, response);
			}catch(Exception e) {
				
			}
			
		}
		if(request.getParameter("btnCargarLista") != null) {
			try {
				MateriaDaoImpl dao = new MateriaDaoImpl();
				ArrayList<Materia> listaMaterias = dao.listarMaterias();
				DocenteDaoImpl daoDoc = new DocenteDaoImpl();
				ArrayList<Docente> listaDocente = daoDoc.ListarDocentes();
				request.setAttribute("listaMaterias", listaMaterias);
				request.setAttribute("listaDocente", listaDocente);
				ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>)session.getAttribute("listaAlumnosACursado");
				
				
				request.setAttribute("listaAlumnosACursado", listaAlumnos);
				
				RequestDispatcher rd = request.getRequestDispatcher("/AgregadoCursado.jsp");
				rd.forward(request, response);
			}catch(Exception e) {
				
			}
		}
		if(request.getParameter("eliminarAlumnoDeLista") != null) {
			ArrayList<Alumno> listaAlumnosCursado = (ArrayList<Alumno>)session.getAttribute("listaAlumnosACursado");
			int index;
			index = Integer.parseInt(request.getParameter("index"));
			AlumnoDaoImpl daoAlumno = new AlumnoDaoImpl();
			ArrayList<Alumno> listaAlumnosCompleta = daoAlumno.ListarAlumnos();
			request.setAttribute("listaAlumnos", listaAlumnosCompleta);
			listaAlumnosCursado.remove(index);
			request.setAttribute("listaAlumnosACursado", listaAlumnosCursado);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumnosACursado.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnCargarCurso")!= null) {
			
			if(request.getParameter("Docentes")!= null && request.getParameter("Materias")!= null && request.getParameter("anio") != null && request.getParameter("semestre") != null) {
				
				CursoDaoImpl cursoDao = new CursoDaoImpl();
				ArrayList<Alumno> listaAlumnosCursado = (ArrayList<Alumno>)session.getAttribute("listaAlumnosACursado");
				Curso curso = new Curso();
				Docente docente = new Docente ();
				Materia materia = new Materia ();
				docente.setId(Integer.parseInt(request.getParameter("Docentes")));
				materia.setIdMateria(Integer.parseInt(request.getParameter("Materias")));
				curso.setAño(Integer.parseInt(request.getParameter("anio")));
				curso.setSemestre(request.getParameter("semestre"));
				curso.setDocente(docente);
				curso.setMateria(materia);
				curso.setAlumno(listaAlumnosCursado);
				
				cursoDao.agregarCurso(curso);
				session.setAttribute("listaAlumnosACursado", listaAlumnosCursado);
				RequestDispatcher rd = request.getRequestDispatcher("/AgregadoCursado.jsp");
				rd.forward(request, response);
			}else {
				System.out.println(request.getParameter("Docentes"));
				System.out.println(request.getParameter("Materias"));
				System.out.println(request.getParameter("anio"));
				System.out.println(request.getParameter("semestre"));
			}
		}
		if(request.getParameter("btnVerCurso")!= null) {
			int idCurso = Integer.parseInt(request.getParameter("idCurso"));
			ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
			CursoDaoImpl cursoDao = new CursoDaoImpl();
			Curso curso = cursoDao.getCurso(idCurso);
			System.out.println(curso.getId());
			AlumnoDaoImpl alumnoDao = new AlumnoDaoImpl();
			curso.setAlumno(alumnoDao.ListarAlumnosCurso(curso.getId()));
			request.setAttribute("Curso", curso);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoNotasAlumnos.jsp");
			rd.forward(request, response);
		}
	}

}
