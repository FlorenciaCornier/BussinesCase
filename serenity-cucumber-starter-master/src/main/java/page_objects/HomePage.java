package page_objects;

import config.GlobalConfig;
import config.Utils;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {
    @FindBy(xpath = "//input[@class='react-autosuggest__input']" )
    private WebElement localidad;

    @FindBy(xpath = "(//button[@class=\"btn btn-default\"])[1]" )
    private WebElement btnCalendario ;

    //Aca se utilizo Contains para filtrar por texto por la cantidad de xpath que figuran
    @FindBy(xpath = "(//button[contains(text(),'21')])[2]" )
    private WebElement btnLlegada;
    @FindBy(xpath = "(//button[contains(text(),'30')])[2]" )
    private WebElement btnSalida ;

    @FindBy(xpath = "(//button[@data-name=\"adultos\"])[2]" )
    private WebElement btnAdultos ;
    @FindBy(xpath = "(//button[@data-name=\"niños\"])[2]" )
    private WebElement btnKids;
    @FindBy(xpath = "//span[@class='rc-checkbox']" )
    private WebElement checkBoxMascotas ;
    @FindBy(xpath = "//button[contains(text(),'Listo')]" )
    private WebElement btnListo ;
    @FindBy(xpath = "//button[contains(text(),'Buscar')]" )
    private WebElement btnBuscar ;

    /**
     * Este metodo nos ayuda a abrir la pagina de Alquiler Argentina.
     */
    public void openAlquilerArgentina(){
        getDriver().get(GlobalConfig.HOME_PAGE_URL);
    }
    public void imputLocalidad(String location){
        localidad.sendKeys(location);
    }
    public void selectCalendario() {
        btnCalendario.click();
    }
    public void selectLlegada() {
        waitFor(ExpectedConditions.visibilityOf(btnLlegada));
        Utils.scrollToElement(btnLlegada);
        btnLlegada.click();
    }
    public void selectSalida() {
        waitFor(ExpectedConditions.visibilityOf(btnSalida));
        btnSalida.click();
    }
    public void selectAdultos() {
        waitFor(ExpectedConditions.visibilityOf(btnAdultos));
        btnAdultos.click();
        btnAdultos.click();
    }
    public void selectKids() {
        //Utils.scrollToElement(btnKids);
        waitFor(ExpectedConditions.visibilityOf(btnKids));
        btnKids.click();
    }
    public void selectMascota()  {
        Utils.scrollToElement(checkBoxMascotas);
        waitFor(ExpectedConditions.visibilityOf(checkBoxMascotas));
        checkBoxMascotas.click();
    }
    public void selectListo() {
        waitFor(ExpectedConditions.visibilityOf(btnListo));
        btnListo.click();
    }
    public void selectBuscar() {
        Utils.scrollToTopPage();
        waitFor(ExpectedConditions.visibilityOf(btnBuscar));
        btnBuscar.click();
    }
}
