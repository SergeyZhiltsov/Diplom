package com.acurian.selenium.pages.blinx;

import com.acurian.selenium.utils.PassPID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class DebugPageBlinxOLS extends MainPageBlinx {

    public String pidNumber;

    @FindBy(xpath = "//*[@id='collapsedContent1']/div[1]")
   WebElement pid;

    @Step
    public DebugPageBlinxOLS getPID(){
        driverWait.waitforVisibility(pid);
        pidNumber = pid.getText().replace("pid: ", "");
        logTextToAllureAndConsole("PID from page = " + pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        return this;
    }

    public String getPidNumber() {
        return pidNumber;
    }
}
