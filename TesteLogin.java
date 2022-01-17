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
		driver.findElement(By.id("email")).sendKeys("henrique@email.com");
		driver.findElement(By.id("senha")).sendKeys("senhacorreta");
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"telaLogin\"]/div/form/div[3]/button")).click();
		
		WebElement mensagem = driver.findElement(By.xpath("/html/body/app-root/app-login/main/p"));
		
		System.out.println(mensagem.getText());
		
	}
	
}
