package negocio;

/**
 * Esta clase representa un objeto Coche con información sobre su marca, modelo, año y precio.
 */
 public class Coche {


    private String marca;
    private String modelo;
    private int año;
    private double precio;

     /**
     * Constructor para crear un objeto Coche.
     *
     * @param marca   La marca del coche.
     * @param modelo  El modelo del coche.
     * @param año     El año de fabricación del coche.
     * @param precio  El precio del coche.
     */
    public Coche(String marca, String modelo, int año, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
    }

     /**
     * Obtiene la marca del coche.
     *
     * @return La marca del coche.
     */
    public String getMarca() {
	return marca;
    }

     /**
     * Obtiene el modelo del coche.
     *
     * @return El modelo del coche.
     */
    public String getModelo() {
	return modelo;
    }

     /**
     * Obtiene el año de fabricación del coche.
     *
     * @return El año de fabricación del coche.
     */
    public int getAño() {
        return año;
    }

     /**
     * Obtiene el precio del coche.
     *
     * @return El precio del coche.
     */
    public double getPrecio() {
        return precio;
    }

     /**
     * Devuelve una representación de cadena del coche que incluye marca, modelo, año y precio.
     *
     * @return Una representación de cadena del coche.
     */
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año + ", Precio: $" + precio;
    }
}
 

