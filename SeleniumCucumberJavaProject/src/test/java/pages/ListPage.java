package pages;


import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListPage extends BasePage {
    private String searchField = "//body/div[1]/div[1]/div[1]/span[1]/input[2]";
    private String searchResults = "tt-suggestion";

    public ListPage() {
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://twitter.github.io/typeahead.js/examples/");
    }

    public void enterSearchCriteria(String state) throws InterruptedException {
        try{
            Thread.sleep(600); // Espera de 600 milisegundos
            write(searchField, state);
        } catch (NoSuchElementException e) {
            System.out.println("The WebElement Search Field couldn't be found.");
            // Imprimir la información detallada de la excepción
            e.printStackTrace();
        }

    }

    public List<String> getAllSearchResults(){
        // Lista de WebElements devuelta segun el name aplicado en el input
        List<WebElement> list = bringMeAllElements(searchResults);
        // Creo una lista vacia para despues pasar estos WebElements
        List<String> stringsFromList = new ArrayList<String>();
        // Recorro la lista de WebElements , obtengo el Texto y lo agrego a la
        // nueva lista de Strings
        for (WebElement element : list) {
            stringsFromList.add(element.getText());
        }
        // Necesito Strings para despues validar que los textos se encuentren en una lista
        return stringsFromList;
    }
}
