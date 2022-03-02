package Entidad;

public class Alumno {
	private int id;
	private int legajo;
	private String dni;	
	private String nombre;
	private String apellido;
	private String fechanacimiento;
	private String direccion;
	private String nacionalidad;
	private String provincia;
	private String localidad;
	private String email;
	private String telefono;
	private int IdCarrera;
	private static int cont=9999;
	
	public Alumno() {
		
	}

	public Alumno(String dni, String nombre, String apellido, String fechanacimiento, String direccion, String nacionalidad,String provincia,String localidad, String email, String telefono, int idCarr) {
		super();
		
		this.legajo = devuelveProximoLegajo();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.provincia =provincia; 
		this.localidad = localidad;
		this.email = email;
		this.telefono = telefono;
		this.IdCarrera = idCarr;
	}
	public void setIdCarrera(int idCarrera) {
		IdCarrera = idCarrera;
	}

	public static int devuelveProximoLegajo() {
		return cont++;

		}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia =provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad =localidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getIdCarrera() {
		return IdCarrera;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + legajo;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (legajo != other.legajo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
