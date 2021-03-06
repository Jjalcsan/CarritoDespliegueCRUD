package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa la entidad usuario de la BBDD
 * Un usuario estará identificado por su nick, también
 * tendrá una contraseña, utilizará estas dos propiedades para hacer login
 * Ademas tendrá información personal necesaria para realizar pedidos como
 * nombre completo, email, dirección y teléfono
 * Tendrá una lista de pedidos donde se irán añadiendo y borrando
 * @author usuario
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario {
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Propiedades
	
	/**
	 * El nick que tendrá el usuario en la aplicación del carrito de compra
	 * Se utiliza como la ID de la entidad ya que cada nick debe de ser único
	 */
	@Id
	private String nick;
	
	/**
	 * La contraseña que utilizará el usuario para iniciar sesión
	 */
	@Column(name = "contra", nullable = false)
	private String contra;
	
	/**
	 * El nombre completo del usuario
	 */
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	/**
	 * El email del usuario
	 */
	@Column(name = "email", nullable = false)
	private String email;
	
	/**
	 * La dirección del usuario a la cual le llegará el pedido
	 */
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	/**
	 * El teléfono del usuario
	 */
	@Column(name = "telefono", nullable = false)
	private String telefono;
	
	/**
	 * La lista de pedidos del usuario
	 */
	@OneToMany(fetch=FetchType.EAGER)
	private List<Pedido> pedidos;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	/**
	 * Constructor vacío
	 */
	public Usuario() {}

	/**
	 * Constructor con todos los parametros del usuario que inicializa la lista de pedidos vacía
	 * @param nick
	 * @param contra
	 * @param nombre
	 * @param email
	 * @param direccion
	 * @param telefono
	 */
	public Usuario(String nick, String contra, String nombre, String email, String direccion, String telefono) {
		
		super();
		this.nick = nick;
		this.contra = contra;
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pedidos = new ArrayList<>();
	
	}

	/**
	 * Constructor con las propiedades necesarias para hacer login
	 * @param nick
	 * @param contra
	 */
	public Usuario(String nick, String contra) {
		
		super();
		this.nick = nick;
		this.contra = contra;
		
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters
	
	/**
	 * Método get del nick del usuario
	 * @return
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * Método set del nick del usuario
	 * @param nick
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * Método get de la contraseña del usuario
	 * @return
	 */
	public String getContra() {
		return contra;
	}

	/**
	 * Método set de la contraseña del usuario
	 * @param nick
	 */
	public void setContra(String contra) {
		this.contra = contra;
	}

	/**
	 * Método get del nombre del usuario
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método set del nombre del usuario
	 * @param nick
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método get del email del usuario
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método set del email del usuario
	 * @param nick
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método get del teléfono del usuario
	 * @return
	 */
	public String getTelefono() {
		return telefono;
	}

	/** 
	 * Método set del teléfono del usuario
	 * @param nick
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método get de la dirección del usuarios
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Método set de la dirección del usuarios
	 * @param nick
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Método get de la lista de pedidos del usuario
	 * @return
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * Método set de la lista de pedidos del usuario
	 * @param nick
	 */
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override	
	
	/**
	 * Método override hashCode que genera un código Hash basado en el nick del usuario
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nick);
	}

	/**
	 * Método override equals que compara a dos usuarios a través de sus propiedades
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contra, other.contra) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(email, other.email) && Objects.equals(nick, other.nick)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	/**
	 * Método override toString que formará una linea con las propiedades del usuario
	 */
	@Override
	public String toString() {
		return "Usuario [nick=" + nick + ", contra=" + contra + ", nombre=" + nombre + ", email=" + email
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
	
}

