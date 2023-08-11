package starter.stepdefinitions;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.fluentlenium.core.annotation.Page;
import page_objects.AlojamientosFiltradosPage;
import static org.assertj.core.api.Assertions.assertThat;

public class AlojamientosFiltradosStepDef {

    //Definir que declara una pagina - crea la instancia de la clase
    @Page
    AlojamientosFiltradosPage alojamientosFiltradosPage;

    @Entonces("el sistema muestra {int} propiedades")
    public void elSistemaMuestraPropiedades(int cantidadAlojamientos) {
        assertThat(alojamientosFiltradosPage.getTolalAlojamientosEnPaginaActual())
                .overridingErrorMessage("ERROR: La cantidad de alojamientos encontrada es distinta a la esperada.")
                .isEqualTo(cantidadAlojamientos);
    }

    @Y("cuando aplico el filtro Wifi deberia ver menor cantidad de propiedades")
    public void cuandoAplicoElFiltroDeberiaVerMenorCantidadDePropiedades() throws InterruptedException {
        alojamientosFiltradosPage.setCantTotalBusquedaUno();
        System.out.println("NUMERO PRIMERA BUSQUEDA: " + alojamientosFiltradosPage.getCantTotalBusquedaUno());
        alojamientosFiltradosPage.selectFiltros();
        alojamientosFiltradosPage.selectFiltroWiFi();
        alojamientosFiltradosPage.selectBuscarPorFiltro();
        alojamientosFiltradosPage.setCantTotalBusquedaDos();
        System.out.println("NUMERO SEGUNDA BUSQUEDA: " + alojamientosFiltradosPage.getCantTotalBusquedaDos());
        assertThat(alojamientosFiltradosPage.getCantTotalBusquedaUno())
                .overridingErrorMessage("ERROR: El numero encontrado es menor al valor aplicado con filtro!")
                .isGreaterThan(alojamientosFiltradosPage.getCantTotalBusquedaDos());
    }
}