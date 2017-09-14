package com.acurian.selenium.pages.OLS.debug;

	import com.acurian.selenium.pages.BasePage;
    import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import ru.yandex.qatools.allure.annotations.Step;

	import java.util.List;

	public class DebugPageOLS extends BasePage {

	    @FindBy(id = "debug_toolbar_questions_lnk")
	    WebElement questionLink;

	    @FindBy(xpath = "//div[contains(@class,'ui-dialog-titlebar')]//span[text()='Question Information']/following-sibling::*[5]")
	    WebElement closeButton;

	    @FindBy(xpath = "//div[@class='debug_toolbar_content']//tbody//tr/td[@class='question_txt']")
	    List<WebElement> questionList;
	    
	    @FindBy(xpath = "//div[contains(@class,'question-holder-two')]/div[contains(@class,'question')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
	    WebElement titletext;

	    public DebugPageOLS() {
	        PageFactory.initElements(getDriver(), this);
	    }
	    
	    public DebugPageOLS openDebugWindow(){
	        questionLink.click();
	        return this;
	    }

	    public DebugPageOLS closeDebugWindow(){
	        closeButton.click();
	        return this;
	    }

	    @Step
	    public String getProtocolForQuestion(String questionText){
	        openDebugWindow();
	        waitForAnimation();
	        String temp = questionList.stream().filter(el -> el.getText().contains(questionText))
	                .findFirst()
	                .get()
	                .findElement(By.xpath("following-sibling::*[3]"))
	                .getText();
	        closeDebugWindow();
	        return temp;
	    }
	    
	    @Step
	    public DebugPageOLS waitForPageLoad() {
	        waitForAnimation();
	        driverWait.waitforVisibility(titletext);
	        return this;
	    }
	    
	    @Step
	    public String getTitleText() {
	        return getText(titletext);
	    }


	}