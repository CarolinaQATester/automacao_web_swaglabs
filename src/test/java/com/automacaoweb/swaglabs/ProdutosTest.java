package com.automacaoweb.swaglabs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automacaoweb.swaglabs.pages.LoginPage;
import com.automacaoweb.swaglabs.pages.ProdutosPages;

public class ProdutosTest {

  
    private WebDriver driver;

    @Before
    public void iniciar() {
        Driver wdriver = new Driver();
        driver = wdriver.webDriver();
    }

    @After
    public void finalizar() {
         driver.close();
         driver.quit();
    }

  
    @Test
    public void devoRealizarLogin() {
        LoginPage loginPage = new LoginPage(driver);
        // Login
        loginPage.preencherUser("standard_user");
        loginPage.preenhcerPassword("secret_sauce");
        loginPage.clicarLogin();
        
    }

    @Test
    public void devoValidarPaginaProdutos() {
        ProdutosPages produtosPages = new ProdutosPages(driver);
        devoRealizarLogin();
        String titulo = "PRODUCTS";
        Assert.assertEquals(titulo, driver.findElement(By.xpath("//span[@class='title']")).getText());

    }

    @Test
    public void devoListarTodosProdutos() {
        ProdutosPages produtosPages = new ProdutosPages(driver);

        devoRealizarLogin();
        // listar todos os produtos
         produtosPages.listaTodosProdutos();
               
    }

    @Test
    public void devoListaUmProduto() {
        ProdutosPages produtosPages = new ProdutosPages(driver);


        devoRealizarLogin();
        
        produtosPages.listaTodosProdutos();
        produtosPages.listaUmProdutos();
        produtosPages.clicarBotao();
        produtosPages.clicarBotao1();

    }
    @Test
    public void devoValidarPaginaCompra(){
        devoListaUmProduto();
        ProdutosPages produtosPages = new ProdutosPages(driver);


        produtosPages.validarTitulo1("YOUR CART");
        produtosPages.validaNomeProduto("Sauce Labs Backpack");
        produtosPages.validaValorProduto("$29.99");

        
    }
    @Test
    public void devoFinalizarCompra(){
        devoListaUmProduto();
        ProdutosPages produtosPages = new ProdutosPages(driver);

        produtosPages.clicarBotaoCheckout();

    }

    @Test
    public void devoPreencherInformacaoCheckout(){
        devoFinalizarCompra();
        ProdutosPages produtosPages = new ProdutosPages(driver);

        produtosPages.inputFirstName();
        produtosPages.inputLastName();;
        produtosPages.inputPostalCode();
        produtosPages.clicarBotaoContinue();
    }
    @Test
    public void devoValidarDadosFinaisCompra(){
        devoPreencherInformacaoCheckout();
        String titulo = "CHECKOUT: OVERVIEW";
        String nomeProduto = "Sauce Labs Backpack";
        String valorProduto = "$29.99";

        String infoPagamento = "Payment Information:";
        String pedido = "SauceCard #31337";
        String infoEnvio = "Shipping Information:";
        String entraga = "FREE PONY EXPRESS DELIVERY!";
        String itemTotal = "Item total: $29.99";
        String taxa = "Tax: $2.40";
        String total = "Total: $32.39";
        String checkoutCompleto = "CHECKOUT: COMPLETE!";
        

        Assert.assertEquals(titulo, driver.findElement(By.xpath("//span[@class='title']")).getText());
        Assert.assertEquals(nomeProduto, driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        Assert.assertEquals(valorProduto, driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText());
        Assert.assertEquals(infoPagamento, driver.findElement(By.xpath("//div[@class='summary_info_label']")).getText());
        Assert.assertEquals(pedido, driver.findElement(By.xpath("//div[@class='summary_value_label']")).getText());
        Assert.assertEquals(infoEnvio, driver.findElement(By.xpath("//div[@class='summary_info_label'][2]")).getText());
        Assert.assertEquals(entraga, driver.findElement(By.xpath("//div[@class='summary_value_label'][2]")).getText());
        Assert.assertEquals(itemTotal, driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText());
        Assert.assertEquals(taxa, driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText());
        Assert.assertEquals(total, driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText());

        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium cart_button'][@id='finish']")).click();

        Assert.assertEquals(checkoutCompleto, driver.findElement(By.xpath("//span[@class='title']")).getText());

        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small'][@id='back-to-products']")).click();




    }

    

}
