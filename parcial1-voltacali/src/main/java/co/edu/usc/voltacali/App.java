package co.edu.usc.voltacali;

public class App {
    public static void main(String[] args) {
     
        CargadorVE c1 = new CargadorVE("ABB", 2023, 400, CargadorVE.TipoConector.CCS2, CargadorVE.TipoCargador.RAPIDO_DC, 2, 2, 60, CargadorVE.Ubicacion.UNIVERSIDAD);
        CargadorVE c2 = new CargadorVE("Siemens", 2022, 220, CargadorVE.TipoConector.TIPO_2, CargadorVE.TipoCargador.MURAL, 1, 1, 22, CargadorVE.Ubicacion.CENTRO_COMERCIAL);
        CargadorVE c3 = new CargadorVE("Delta", 2024, 800, CargadorVE.TipoConector.CCS2, CargadorVE.TipoCargador.ULTRARRAPIDO, 2, 2, 150, CargadorVE.Ubicacion.ESTACION_SERVICIO);
        CargadorVE c4 = new CargadorVE("Wallbox", 2021, 220, CargadorVE.TipoConector.TIPO_2, CargadorVE.TipoCargador.MURAL, 1, 1, 11, CargadorVE.Ubicacion.RESIDENCIAL);
        CargadorVE c5 = new CargadorVE("Enel X", 2025, 22); 

        CargadorVE[] flota = {c1, c2, c3, c4, c5};
        System.out.println("Flota creada.");
    }
}