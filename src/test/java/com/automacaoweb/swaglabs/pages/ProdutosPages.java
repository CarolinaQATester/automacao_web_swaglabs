package com.automacaoweb.swaglabs.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProdutosPages {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement tituloProduto;
    @FindBy(how = How.XPATH, using = "//div[@class='inventory_item']")
    private List<WebElement> listaProdutos;
    @FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement btnproduto;
    @FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
    private WebElement btnproduto1;
    @FindBy(how = How.XPATH, using = "//button[@id='checkout']")
    private WebElement btnCheckout;

    // informação do checkout
    @FindBy(how = How.XPATH, using = "//input[@type='text'][@id='first-name']")
    private WebElement firstname;
    @FindBy(how = How.XPATH, using = "//input[@type='text'][@id='last-name']")
    private WebElement lastname;
    @FindBy(how = How.XPATH, using = "//input[@type='text'][@id='postal-code']")
    private WebElement postalcode;
    @FindBy(how = How.XPATH, using = "//input[@type='submit'][@id='continue']")
    private WebElement btnContinue;

    //validação
    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement titulo1;
    @FindBy(how = How.XPATH, using ="//div[@class='inventory_item_name']")
    private WebElement nomeProduto;
    @FindBy(how = How.XPATH, using ="//div[@class='inventory_item_price']")
    private WebElement valorProduto;




    public ProdutosPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void validarTituloPaginaProduto() {
        tituloProduto.getText();
    }

    public void listaTodosProdutos() {
        listaProdutos.size();
    }

    public void listaUmProdutos() {
        listaProdutos.get(0);
    }

    public void clicarBotao() {
        btnproduto.click();
    }

    public void clicarBotao1() {
        btnproduto1.click();
    }

    public void clicarBotaoCheckout() {
        btnCheckout.click();
    }
    public void inputFirstName(){
        firstname.sendKeys("Carolina");
    }
    public void inputLastName(){
        firstname.sendKeys("Mesquita");
    }
    public void inputPostalCode(){
        postalcode.sendKeys("72875155");
    }
    public void clicarBotaoContinue(){
        btnContinue.click();
    }
    public void validarTitulo1(String titulo){
    
        titulo1.getText();
    }
    public void validaNomeProduto(String nome){
        nomeProduto.getText();
    }
    public void validaValorProduto(String valor){
        valorProduto.getText();
    }

}
