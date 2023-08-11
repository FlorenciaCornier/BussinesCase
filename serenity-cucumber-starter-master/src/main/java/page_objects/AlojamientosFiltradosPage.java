package page_objects;

import config.Utils;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AlojamientosFiltradosPage extends PageObject {

    //Filtrado de lista de elementos
    private By alojamientos = By.xpath("//div[@class='col-md-3 col-sm-6 col-xs-12 AnuncioCardListado']");

    @FindBy(xpath = "(//button[@class=\"btn-noButton MainListado__boton-filtro\"])[1]" )
    private WebElement btnFiltro;

    @FindBy (xpath = "//span[contains(text(),'WI-FI')]" )
    private WebElement checkWifi;

    @FindBy (xpath = "//button[@class=\"FiltrosDesktop__buscar-desktop-boton\"]" )
    private WebElement btnBuscar;

    @FindBy (xpath = "(//b)[1]" )
    private WebElement txtResultadoTotalAlojamientos;

    private int cantTotalBusquedaUno = 0;
    private int cantTotalBusquedaDos = 0;

    public void setCantTotalBusquedaUno(){
        waitFor(ExpectedConditions.visibilityOf(txtResultadoTotalAlojamientos));
        this.cantTotalBusquedaUno = Integer.parseInt(txtResultadoTotalAlojamientos.getText());
    }
    public int getCantTotalBusquedaUno(){
        return this.cantTotalBusquedaUno;
    }

    public void setCantTotalBusquedaDos(){
        waitFor(ExpectedConditions.visibilityOf(txtResultadoTotalAlojamientos));
        this.cantTotalBusquedaDos = Integer.parseInt(txtResultadoTotalAlojamientos.getText());
    }

    public int getCantTotalBusquedaDos(){
        return this.cantTotalBusquedaDos;
    }

    public int getTolalAlojamientosEnPaginaActual() {
        List<WebElement> alojamientosList = getDriver().findElements(alojamientos); //lista los elementos
        waitFor(ExpectedConditions.visibilityOfAllElements(alojamientosList)); //recibe algo tipo webElement
        return alojamientosList.size(); //retorna el tamaño de la lista
    }
    public void selectFiltros() {
        waitFor(ExpectedConditions.visibilityOf(btnFiltro));
        btnFiltro.click();
    }
    public void selectFiltroWiFi() {
        Utils.scrollToElement(checkWifi);
        waitFor(ExpectedConditions.elementToBeClickable(checkWifi));
        checkWifi.click();
    }

    public void selectBuscarPorFiltro() throws InterruptedException {
        waitFor(ExpectedConditions.visibilityOf(btnBuscar));
        btnBuscar.click();
        Thread.sleep(5000);
    }
}
