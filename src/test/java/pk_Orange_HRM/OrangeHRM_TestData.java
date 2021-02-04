package pk_Orange_HRM;

import org.testng.annotations.DataProvider;


public class OrangeHRM_TestData {

	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{ "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "Admin", "admin123" },
				{ "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "dixit5", "admin123" },
				{ "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "kumar", "admin123" }
				};

	}

	@DataProvider(name = "LoginScenario")
	public Object[][] getDataforLoginDifferentScenarios() {
		return new Object[][] { 
				{ "admin", "", "Password cannot be empty"},
				{ "", "admin123", "Username cannot be empty" }, 
				{ "AdminWrong", "admin123", "Invalid credentials" },
				{ "admin", "admin", "Invalid credentials" }, 
				{ "admin", "admin123", "Dashboard" } };

	}

    @DataProvider(name = "AddUsers")
    public Object[][] getDataforAddingUsers(){
		return new Object[][]{
			{"Admin","Fiona Grace","Andrey","Enabled","Kuntal@123","Kuntal@123"},
			{"ESS","Paul Collings","Harshitha","Enabled","Kuntal@321","Kuntal@321"},
			{"Admin","Anthony Nolan","Narendra","Disabled","Kuntal@456","Kuntal@456"},
			{"ESS","Cassidy Hope","Harsha","Enabled","Kuntal@720","Kuntal@720"},
			{"Admin","David Morris","Kuntal04","Disabled","Kuntal@840","Kuntal@840"},
		};
    	
    }
	//-------------------------------------------- This is to read Excel Data------------

	@DataProvider(name = "LoginData")
	public Object[][] Authentication() throws Exception{
		ReadExcel excel = new ReadExcel();
		Object[][] testObjArray = excel.getExcelData("D:\\F Drive\\Selenium Training Data\\workspace\\Maven_Selenium_WebDriver_4\\OrangeHRM_TestData.xlsx","SignIn");
		System.out.println(testObjArray);
		return testObjArray;

	}

}
