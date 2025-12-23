package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "newUserData")
    public Object[][] getUserData() {
    	String filePath = "E:\\ezhourweb\\src\\test\\resources\\TestData.xlsx";
        return ExcelUtils.getExcelData(filePath, "New Users");
    }
    
    @DataProvider(name = "newUserDataPasswordValidations")
    public Object[][] getNewUserData() {
    	String filePath = "E:\\ezhourweb\\src\\test\\resources\\TestData.xlsx";
        return ExcelUtils.getExcelData(filePath, "PassWordValidation-NewUsers");
    }
}
