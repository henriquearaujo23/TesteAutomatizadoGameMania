package br.senai.sp.testegamemania;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	private WebDriver driver;

	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	@Test
	public void TestarLogin() {
		driver.get("http://localhost:4200/");

		driver.findElement(By.xpath("/html/body/app-root/app-header/header/div/div[2]/a[2]")).click();
		
		// Primeiro Teste
		WebElement inputEmail = driver.findElement(By.id("email"));		
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement botão = driver.findElement(By.xpath("//*[@id=\"telaLogin\"]/div/form/div[3]/button"));
		
		String[] listaSenhas = {"senhaincorreta", "senhaincorreta", "senhacorreta"};	
		
		for (int tentativas = 0; tentativas < 3; tentativas++) {
			try {
				
				inputEmail.clear();
				inputSenha.clear();
				
				inputEmail.sendKeys("henrique@email.com");
				inputSenha.sendKeys(listaSenhas[tentativas]);
				botão.click();
				
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}		
		
		WebElement mensagem = driver.findElement(By.xpath("/html/body/app-root/app-login/main/p"));
		
		System.out.println(mensagem.getText());
		
	}
	
}
