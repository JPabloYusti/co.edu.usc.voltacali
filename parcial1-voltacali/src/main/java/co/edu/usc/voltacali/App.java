package co.edu.usc.voltacali;

public class App {
    public static void main(String[] args) {
        // Parte E: Paso 1 - Crear la flota
        CargadorVE c1 = new CargadorVE("ABB", 2023, 400, CargadorVE.TipoConector.CCS2, CargadorVE.TipoCargador.RAPIDO_DC, 2, 2, 60.0, CargadorVE.Ubicacion.UNIVERSIDAD);
        CargadorVE c2 = new CargadorVE("Siemens", 2022, 220, CargadorVE.TipoConector.TIPO_2, CargadorVE.TipoCargador.MURAL, 1, 1, 22.0, CargadorVE.Ubicacion.CENTRO_COMERCIAL);
        CargadorVE c3 = new CargadorVE("Delta", 2024, 800, CargadorVE.TipoConector.CCS2, CargadorVE.TipoCargador.ULTRARRAPIDO, 2, 2, 150.0, CargadorVE.Ubicacion.ESTACION_SERVICIO);
        CargadorVE c4 = new CargadorVE("Wallbox", 2021, 220, CargadorVE.TipoConector.TIPO_2, CargadorVE.TipoCargador.MURAL, 1, 1, 11.0, CargadorVE.Ubicacion.RESIDENCIAL);
        CargadorVE c5 = new CargadorVE("Enel X", 2025, 22.0); // Usa constructor reducido

        CargadorVE[] flota = {c1, c2, c3, c4, c5};

        // Paso 2 - Sesión de carga sobre C1
        System.out.println("[P01] "); c1.setPotenciaActual(40.0); System.out.println("Potencia C1: " + c1.getPotenciaActual() + " kW");
        System.out.println("[P02] "); c1.aumentarPotencia(15.0); System.out.println("Potencia C1: " + c1.getPotenciaActual() + " kW");
        System.out.println("[P03] Tiempo estimado C1: " + String.format("%.2f", c1.tiempoEstimadoCarga(66.0)) + " horas");
        System.out.println("[P04] "); c1.aumentarPotencia(10.0); System.out.println("Potencia C1: " + c1.getPotenciaActual() + " kW");
        System.out.println("[P05] "); c1.reducirPotencia(30.0); System.out.println("Potencia C1: " + c1.getPotenciaActual() + " kW");
        System.out.println("[P06] Tiempo estimado C1: " + String.format("%.2f", c1.tiempoEstimadoCarga(50.0, 2, 15.0)) + " horas");
        System.out.println("[P07] Tiempo estimado C1: " + String.format("%.2f", c1.tiempoEstimadoCarga(50.0, 40.0)) + " horas");
        System.out.println("[P08] "); c1.aumentarPotencia(); System.out.println("Potencia C1: " + c1.getPotenciaActual() + " kW");
        System.out.println("[P09] "); c1.aumentarPotencia(5.0, 3); System.out.println("Potencia C1: " + c1.getPotenciaActual() + " kW");
        System.out.println("[P10] "); c1.reducirPotencia(50.0); System.out.println("Potencia C1: " + c1.getPotenciaActual() + " kW");
        System.out.println("[P11] "); c1.cortarCarga(); System.out.println("Potencia C1: " + c1.getPotenciaActual() + " kW");
        System.out.println("[P12] Tiempo estimado C1: " + String.format("%.2f", c1.tiempoEstimadoCarga(10.0)) + " horas");

        // Paso 3 - Operaciones sobre el resto de la flota
        System.out.println("\n[P13]");
        c2.setPotenciaActual(22.0); System.out.println("Potencia C2: " + c2.getPotenciaActual() + " kW");
        c3.setPotenciaActual(120.0); System.out.println("Potencia C3: " + c3.getPotenciaActual() + " kW");
        c4.aumentarPotencia(7.4); System.out.println("Potencia C4: " + c4.getPotenciaActual() + " kW");
        c5.aumentarPotencia(30.0); System.out.println("Potencia C5: " + c5.getPotenciaActual() + " kW");

        // Paso 4 - Estadísticas y validaciones
        System.out.println("\n[P14]");
        int[] conteoTipos = CargadorVE.contarPorTipo(flota);
        for (int i = 0; i < conteoTipos.length; i++) {