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
			MateriaNegocioImpl materiaNegocio = new MateriaNegocioImpl();
			ArrayList<Materia> listaMaterias = materiaNegocio.listarMaterias();
			
			DocenteNegocioImpl docenteNegocio = new DocenteNegocioImpl();
			ArrayList<Docente> listaDocente = docenteNegocio.ListarDocentes();
			
			request.setAttribute("listaMaterias", listaMaterias);
			request.setAttribute("listaDocente", listaDocente);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregadoCursado.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Listar")!=null) {
			/*DocenteDaoImpl docenteDao = new DocenteDaoImpl();
			int idDocente = docenteDao.obtenerIdDocente(usuario.getUsuario());
			CursoDaoImpl cursoDao = new CursoDaoImpl();
			AlumnoDaoImpl alumnoDao = new AlumnoDaoImpl();
			ArrayList<Curso> listaCursos = new ArrayList<Curso>();
			listaCursos = cursoDao.listarCursos(idDocente);*/
			
			CursoNegocioImpl cursoNegocio = new CursoNegocioImpl();
			AlumnoNegocioImpl alumnoNegocio = new AlumnoNegocioImpl();
			
			ArrayList<Curso> listaCursos = new ArrayList<Curso>();
			listaCursos = cursoNegocio.listarCursos((int)session.getAttribute("idDocenteSesion"));
			
			for(Curso curso : listaCursos) {
				curso.setAlumno(alumnoNegocio.ListarAlumnosCurso(curso.getId()));
			}
			
			request.setAttribute("listaC", listaCursos);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoCursos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("AgregarAlumnos") != null) {
			AlumnoNegocioImpl alumnoNegocio = new AlumnoNegocioImpl();
			ArrayList<Alumno> listaAlumnos = alumnoNegocio.ListarAlumnos();
			
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
				AlumnoNegocioImpl alumnoNegocio = new AlumnoNegocioImpl();
				ArrayList<Alumno> listaAlumnos1 = new ArrayList<Alumno>();

				Alumno al = alumnoNegocio.getAlumno(Integer.parseInt(request.getParameter("idAlumno")));
				
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
			}
			
			AlumnoNegocioImpl alumnoNegocio = new AlumnoNegocioImpl();
			ArrayList<Alumno> listaAlumnosCompleta = alumnoNegocio.ListarAlumnos();
			
			request.setAttribute("listaAlumnos", listaAlumnosCompleta);
			session.setAttribute("listaAlumnosACursado", listaAlumnos);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumnosACursado.jsp");
			rd.forward(request, response);
			}catch(Exception e) {
				
			}
			
		}
		if(request.getParameter("btnCargarLista") != null) {
			try {
				MateriaNegocioImpl materiaNegocio = new MateriaNegocioImpl();
				ArrayList<Materia> listaMaterias = materiaNegocio.listarMaterias();
				
				DocenteNegocioImpl docenteNegocio = new DocenteNegocioImpl();
				ArrayList<Docente> listaDocente = docenteNegocio.ListarDocentes();
				
				ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>)session.getAttribute("listaAlumnosACursado");
				
				request.setAttribute("listaMaterias", listaMaterias);
				request.setAttribute("listaDocente", listaDocente);
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
			
			AlumnoNegocioImpl alumnoNegocio = new AlumnoNegocioImpl();
			ArrayList<Alumno> listaAlumnosCompleta = alumnoNegocio.ListarAlumnos();
			
			
			listaAlumnosCursado.remove(index);
			
			request.setAttribute("listaAlumnos", listaAlumnosCompleta);
			request.setAttribute("listaAlumnosACursado", listaAlumnosCursado);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumnosACursado.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnCargarCurso")!= null) {
				CursoNegocioImpl cursoNegocio = new CursoNegocioImpl();
				ArrayList<Alumno> listaAlumnosCursado = (ArrayList<Alumno>)session.getAttribute("listaAlumnosACursado");
				Curso curso = new Curso();
				Docente docente = new Docente ();
				Materia materia = new Materia ();
				if((request.getParameter("Docentes")!=null))docente.setId(Integer.parseInt(request.getParameter("Docentes")));
				if((request.getParameter("Materias")!=null))materia.setIdMateria(Integer.parseInt(request.getParameter("Materias")));
				if(request.getParameter("anio")!=null && request.getParameter("anio")!= "")curso.setAño(Integer.parseInt(request.getParameter("anio")));
				curso.setSemestre(request.getParameter("semestre"));
				curso.setDocente(docente);
				curso.setMateria(materia);
				curso.setAlumno(listaAlumnosCursado);
				int estado = cursoNegocio.agregarCurso(curso);
				
				MateriaNegocioImpl materiaNegocio = new MateriaNegocioImpl();
				ArrayList<Materia> listaMaterias = materiaNegocio.listarMaterias();
				
				DocenteNegocioImpl docenteNegocio = new DocenteNegocioImpl();
				ArrayList<Docente> listaDocente = docenteNegocio.ListarDocentes();
				
				request.setAttribute("listaMaterias", listaMaterias);
				request.setAttribute("listaDocente", listaDocente);
				request.setAttribute("estadoAgregar", estado);
				session.setAttribute("listaAlumnosACursado", listaAlumnosCursado);
				RequestDispatcher rd = request.getRequestDispatcher("/AgregadoCursado.jsp");
				rd.forward(request, response);
			
		}
		if(request.getParameter("btnVerCurso")!= null) {
			int idCurso = Integer.parseInt(request.getParameter("idCurso"));
			ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
			
			CursoNegocioImpl cursoNegocio = new CursoNegocioImpl();
			CursoDaoImpl cursoDao = new CursoDaoImpl();
			Curso curso = cursoNegocio.getCurso(idCurso);
			//System.out.println(curso.getId());
			
			AlumnoxcursoNegocioImpl alumnoNegocio = new AlumnoxcursoNegocioImpl();
			curso.setListaAlumnosCurso(alumnoNegocio.ListarAlumnosxcurso(curso.getId()));
			request.setAttribute("Curso", curso);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoNotasAlumnos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnCargarNotas") !=null) {
			int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
			Alumnoxcurso alumno = new Alumnoxcurso();
			alumno.setIdAlumno(idAlumno);
			double nota = 0;
			double cantidad = 0;
			if(request.getParameter("notaParcial1")!= null) {
				double nota1 = Double.parseDouble(request.getParameter("notaParcial1"));
				alumno.setParcial1(nota1);
				nota += nota1;
				if(nota1>0)cantidad++;
			}
			if(request.getParameter("notaParcial2")!= null) {
				double nota1 = Double.parseDouble(request.getParameter("notaParcial2"));
				alumno.setParcial2(nota1);
				nota += nota1;
				if(nota1>0)cantidad++;
			}
			if(request.getParameter("notaRecuperatorio1")!= null) {
				double nota1 = Double.parseDouble(request.getParameter("notaRecuperatorio1"));
				alumno.setRecupera1(nota1);
				nota += nota1;
				if(nota1>0)cantidad++;
			}
			if(request.getParameter("notaRecuperatorio2")!= null) {
				double nota1 = Double.parseDouble(request.getParameter("notaRecuperatorio2"));
				alumno.setRecupera2(nota1);
				nota += nota1;
				if(nota1>0)cantidad++;
			}
			double notafinal = 0;
			if(nota > 0) {
				notafinal = nota/cantidad;
			}
			if(notafinal > 0) {
				if(notafinal < 6) {
					alumno.setEstado("Libre");
				}
				if(notafinal >= 6 && notafinal < 8) {
					alumno.setEstado("Regular");
				}
				if(notafinal >= 8) {
					alumno.setEstado("Promocionado");
				}
			}
			AlumnoxcursoNegocioImpl alumnoNegocio = new AlumnoxcursoNegocioImpl();
			
			int idCurso = Integer.parseInt(request.getParameter("idCurso"));
			System.out.println("Nota Final:"+ notafinal);
			alumno.setIdCurso(idCurso);
			
			int estado = alumnoNegocio.agregarAlumnoxcurso(alumno);
			
			CursoDaoImpl cursoDao = new CursoDaoImpl();
			Curso curso = cursoDao.getCurso(idCurso);
			
			
			curso.setListaAlumnosCurso(alumnoNegocio.ListarAlumnosxcurso(curso.getId()));
			request.setAttribute("Curso", curso);
			request.setAttribute("estadoModificar", estado);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoNotasAlumnos.jsp");
			rd.forward(request, response);
		}
	}

}
