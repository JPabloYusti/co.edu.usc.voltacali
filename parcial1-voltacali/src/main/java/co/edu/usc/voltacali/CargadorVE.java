package co.edu.usc.voltacali;

import java.util.Vector;

public class CargadorVE {

    public enum TipoConector { TIPO_1, TIPO_2, CCS2, CHADEMO, GBT }
    public enum TipoCargador { MURAL, PEDESTAL, RAPIDO_DC, ULTRARRAPIDO, PORTATIL, BIDIRECCIONAL_V2G }
    public enum Ubicacion { CENTRO_COMERCIAL, UNIVERSIDAD, ESTACION_SERVICIO, PARQUEADERO_PUBLICO, RESIDENCIAL, HOTEL, TERMINAL, FLOTA_CORPORATIVA }

    
    private String fabricante;
    private int anioInstalacion;
    private int voltajeNominal;
    private TipoConector tipoConector;
    private TipoCargador tipoCargador;
    private int numeroConectores;
    private int puestosParqueo;
    private double potenciaMaxima;
    private Ubicacion ubicacion;
    private double potenciaActual;

    
    private Vector<RegistroSesion> bitacora;

    public static int totalCargadores = 0;
    public static int contadorRegistros = 0;
    public static final double LIMITE_RED = 50.0;
    public static final double INCREMENTO_DEFECTO = 5.0;

   
    public class RegistroSesion {
        private String evento;
        private boolean valido;
        private String fabricanteLog;
        private int anioInstalacionLog;
        private double potenciaActualLog;
        private int consecutivo;

        public RegistroSesion(String evento, boolean valido) {
            this.evento = evento;
            this.valido = valido;
            
            this.fabricanteLog = CargadorVE.this.fabricante;
            this.anioInstalacionLog = CargadorVE.this.anioInstalacion;
            this.potenciaActualLog = CargadorVE.this.potenciaActual;
            
            CargadorVE.contadorRegistros++;
            this.consecutivo = CargadorVE.contadorRegistros;
        }

        public void describir() {
            System.out.println("Reg #" + consecutivo + " | " + fabricanteLog + " (" + anioInstalacionLog + ") | " + evento + " | Valido: " + valido + " | Pot: " + potenciaActualLog + " kW");
        }
        
        public double getPotenciaActualLog() { return potenciaActualLog; }
        public boolean isValido() { return valido; }
    }

  
    public CargadorVE(String fabricante, int anioInstalacion, int voltajeNominal, TipoConector tipoConector, TipoCargador tipoCargador, int numeroConectores, int puestosParqueo, double potenciaMaxima, Ubicacion ubicacion) {
        this.fabricante = fabricante;
        this.anioInstalacion = anioInstalacion;
        this.voltajeNominal = voltajeNominal;
        this.tipoConector = tipoConector;
        this.tipoCargador = tipoCargador;
        this.numeroConectores = numeroConectores;
        this.puestosParqueo = puestosParqueo;
        this.potenciaMaxima = potenciaMaxima;
        this.ubicacion = ubicacion;
        this.potenciaActual = 0.0;
        this.bitacora = new Vector<>();
        totalCargadores++; 
    }
    
    public CargadorVE(String fabricante, int anioInstalacion, double potenciaMaxima) {
        this(fabricante, anioInstalacion, 220, TipoConector.TIPO_2, TipoCargador.PEDESTAL, 1, 1, potenciaMaxima, Ubicacion.PARQUEADERO_PUBLICO);
    }


    public CargadorVE(CargadorVE otro) {
        this(otro.fabricante, otro.anioInstalacion, otro.voltajeNominal, otro.tipoConector, otro.tipoCargador, otro.numeroConectores, otro.puestosParqueo, otro.potenciaMaxima, otro.ubicacion);
    }

 
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public int getAnioInstalacion() { return anioInstalacion; }
    public void setAnioInstalacion(int anioInstalacion) { this.anioInstalacion = anioInstalacion; }
    public int getVoltajeNominal() { return voltajeNominal; }
    public void setVoltajeNominal(int voltajeNominal) { this.voltajeNominal = voltajeNominal; }
    public TipoConector getTipoConector() { return tipoConector; }
    public void setTipoConector(TipoConector tipoConector) { this.tipoConector = tipoConector; }
    public TipoCargador getTipoCargador() { return tipoCargador; }
    public void setTipoCargador(TipoCargador tipoCargador) { this.tipoCargador = tipoCargador; }
    public int getNumeroConectores() { return numeroConectores; }
    public void setNumeroConectores(int numeroConectores) { this.numeroConectores = numeroConectores; }
    public int getPuestosParqueo() { return puestosParqueo; }
  