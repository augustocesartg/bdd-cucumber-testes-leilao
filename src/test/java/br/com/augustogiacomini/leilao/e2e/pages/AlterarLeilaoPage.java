package br.com.augustogiacomini.leilao.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlterarLeilaoPage {

	private WebDriver driver;

	public AlterarLeilaoPage(WebDriver driver) {
		this.driver = driver;
	}

	public LeiloesPage preencheForm(String nome, String valor, String data) {

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dataAbertura")));

		WebElement txtNome = driver.findElement(By.id("nome"));
        WebElement txtValor = driver.findElement(By.id("valorInicial"));
        WebElement txtData = driver.findElement(By.id("dataAbertura"));

        txtNome.clear();
        txtNome.sendKeys(nome);
        txtValor.clear();
        txtValor.sendKeys(valor);
        txtData.clear();
        txtData.sendKeys(data);

        txtNome.submit();

        return new LeiloesPage(driver);
	}

}
