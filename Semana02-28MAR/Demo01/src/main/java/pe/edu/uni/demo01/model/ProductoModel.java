package pe.edu.uni.demo01.model;

/**
 *
 * @author Gustavo Coronel
 */
public class ProductoModel {

	// Variables
	private String nombre;
	private double precio;
	private int stock;
	private boolean estado;

	/**
	 * Constructor por defecto
	 */
	public ProductoModel() {
		this.nombre = "Laptop";
		this.precio = 890.00;
		this.stock = 600;
		this.estado = true;
		System.out.println("Objeto producto creado.");
	}

	/**
	 * Constructor adicional. Sobrecarga de constructores.
	 *
	 * @param nombre Nombre del producto.
	 * @param precio Precio del producto.
	 * @param stock Stock del producto.
	 * @param estado Estado del producto.
	 */
	public ProductoModel(String nombre, double precio, int stock, boolean estado) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Sobre-escritura del constructor,.
	 * @throws Throwable 
	 */
	@Override
	protected void finalize() throws Throwable {
		System.err.println("Chau objeto.");
	}

	
}
