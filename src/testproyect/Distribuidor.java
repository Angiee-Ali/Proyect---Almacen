
package testproyect;


public class Distribuidor {
    private String RUC;
    private String empre;

        public Distribuidor(String RUC, String empre){
            this.RUC = RUC;
            this.empre = empre;
            
        }
        public String getRUC(){
            return RUC;
        }
        public String getNomb(){
            return empre;
        }
    @Override
    public String toString(){
        return empre + " (RUC: " + RUC + ")";
    }
}
    

