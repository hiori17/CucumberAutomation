package utilities;

import java.util.Set;

public class Window {
    private static String mainHandle;
    public static void switchToSecondWindow() {
        //need to check for condition
        Set<String> windowHandles = Driver.getDriver().getWindowHandles(); //all windows from opened session
        mainHandle = Driver.getDriver().getWindowHandle(); //this is the main window handle
        if (windowHandles.size() < 2) { //check the condition
            System.out.println("No multiple windows found");
        } else { // meaning we have more windows, this is to switch to second one
            for (String windowID : windowHandles) {
                if (!windowID.equals(mainHandle)) {
                    Driver.getDriver().switchTo().window(mainHandle);
                }
            }
        }

    }
    public static void switchToMainWindow(){
        if(mainHandle != null){
            Driver.getDriver().switchTo().window(mainHandle);
        }
    }
    public static void switchToWindow(String title){
        mainHandle = Driver.getDriver().getWindowHandle();
        Set<String>windowHandles = Driver.getDriver().getWindowHandles();
        if(windowHandles.size() < 2){
            System.out.println("NO multiple windows found");
        }else{
            for(String window : windowHandles){
                Driver.getDriver().switchTo().window(window);
                if(title.equals(Driver.getDriver().getTitle())){
                    break;
                }
            }
        }
    }
}
