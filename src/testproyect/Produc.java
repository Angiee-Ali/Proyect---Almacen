
package testproyect;


public class Produc {
    private String cod;
    private String nomb;
    private int stock;
public Produc(String cod, String nomb, int stock){
        this.cod = cod;
        this.nomb = nomb;
        this.stock = stock;
    }

    public String getCodigo() { return cod; }
    public String getNombre() { return nomb; }
    public int getStock() { return stock; }

    // Método para registrar entrada (suma) o salida (resta)
    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
    }

    @Override
    public String toString() {
        return "Producto [" + cod + "] - " + nomb + " | Stock: " + stock;
    }
}