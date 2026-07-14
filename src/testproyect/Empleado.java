
package testproyect;


public class Empleado {
    private String nomb;
    private String dni;
    public Empleado(String nomb, String dni){
        this.nomb = nomb;
        this.dni = dni; 
    }
    public String getNomb() {
        return nomb;
    }
    public String getDni() {
        return dni;
    }
    @Override
    public String toString() {
        return  nomb + "(DNI: " + dni + ")";
    }


}
