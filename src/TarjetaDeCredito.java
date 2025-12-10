import java.util.ArrayList;
import java.util.List;

public class TarjetaDeCredito {
    
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaVencimiento;
    private String codigoSeguridad;
    private double limiteCredito;
    private double saldoActual;
    private List<Compra> listaDeCompras;

    public TarjetaDeCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
        this.saldoActual = limiteCredito;
        this.listaDeCompras = new ArrayList<>();
    }

    public boolean lanzarCompra(Compra compra){
        if (this.saldoActual >= compra.getValor()){
            this.saldoActual -= compra.getValor();
            this.listaDeCompras.add(compra);
            return true;
        }
        return false;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }

    
}
