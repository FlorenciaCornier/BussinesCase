package starter.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.fluentlenium.core.annotation.Page;
import page_objects.HomePage;

public class HomeStepDef {
    @Page
    HomePage homePage;

    @Dado("que soy un usuario que se dirige a Alquiler Argentina")
    public void queSoyUnUsuarioQueSeDirigeAAlquilerArgentina() {
        homePage.openAlquilerArgentina();
    }

    @Cuando("ingreso {string} como localidad")
    public void ingresoComoLocalidad(String localidad) {
        homePage.imputLocalidad(localidad);
    }

    @Y("selecciono las fechas de estadia")
    public void seleccionoLasFechasDeEstadia() {
        homePage.selectCalendario();
        homePage.selectLlegada();
        homePage.selectSalida();
    }

    @E("ingreso los integrantes del viaje para iniciar una busqueda")
    public void seleccionoLosIntegrantesDelViaje()  {
        homePage.selectAdultos();
        homePage.selectKids();
        homePage.selectMascota();
        homePage.selectListo();
        homePage.selectBuscar();
    }
}