package pk_Advance_Topics;

import org.testng.annotations.DataProvider;

public class OrangeHRMLoginTestData {

	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {
				{ "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "Kuntal00", "Kuntal@123" },
				{ "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "Kuntal01", "Kuntal@321" },
				{ "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "Kuntal02", "Kuntal@456" } };
	}

	@DataProvider(name = "Login Different Case")
	public Object[][] getDataforLoginDifferentScenarios() {
		return new Object[][] { { "admin", "", "Password cannot be empty" },
				{ "", "admin123", "Username cannot be empty" }, { "AdminWrong", "admin123", "Invalid credentials" },
				{ "admin", "admin", "Invalid credentials" }, { "admin", "admin123", "Successful Login" } };

	}

	@DataProvider(name = "Add Users")
	public Object[][] getDataforAddingUsers() {
		return new Object[][] { { 1, "Admin", "Fiona Grace", "Kuntal00", "Enabled", "Kuntal@123", "Kuntal@123" },
				{ 2, "ESS", "Paul Collings", "Kuntal01", "Enabled", "Kuntal@321", "Kuntal@321" },
				{ 3, "Admin", "Anthony Nolan", "Kuntal02", "Disabled", "Kuntal@456", "Kuntal@456" },
				{ 4, "ESS", "Cassidy Hope", "Kuntal03", "Enabled", "Kuntal@720", "Kuntal@720" },
				{ 5, "Admin", "David Morris", "Kuntal04", "Disabled", "Kuntal@840", "Kuntal@840" }, };

	}

	// -------------------------------------------- This is to read Excel
	// Data------------
	@DataProvider(name = "Read From Excel")
	public Object[][] Authentication() throws Exception {
		Read_Excel_File excel = new Read_Excel_File();
		String Current_Path = System.getProperty("user.dir");
		String file = Current_Path + "\\Orange_HRM_Data.xls";
		Object[][] testObjArray = excel.getExcelData(file, "SignIn");
		System.out.println(testObjArray);
		return testObjArray;
	}

	// This is to Read XLSX Data
	@DataProvider(name = "Read From Excel XLSX")
	public Object[][] Auth() throws Exception {
		Read_Excel_XLSX_File exlsx = new Read_Excel_XLSX_File();
		String CurrentPath = System.getProperty("user.dir");
		String FilePath = CurrentPath + "\\OrangeHRM_Login_All_Scenario.xlsx";
		Object[][] UserPass = exlsx.Read_XLSX_File(FilePath, "SignIn");
		return UserPass;

	}

}
