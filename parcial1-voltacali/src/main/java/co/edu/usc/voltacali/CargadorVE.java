package co.edu.usc.voltacali;

import java.util.Vector;
import java.util.Arrays;


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

    }

    