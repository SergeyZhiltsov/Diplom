package com.acurian.selenium.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
public @interface Locators {

    //Login Page
    String LOGIN_INPUT = "input[ng-model='user.Username']";

}
