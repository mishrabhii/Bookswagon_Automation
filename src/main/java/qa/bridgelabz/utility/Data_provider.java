package qa.bridgelabz.utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Data_provider {
	@DataProvider(name = "testData")
	public Object[][] getData() throws IOException{
		Data_Driven confi = new Data_Driven ("/Users/atulnigam/Documents/AbhiEclipseWorkshop/BookStore_Framework/Resources/Login_Data.xlsx");
		int rows = confi.getRowCount(0);
		Object [][] credentials = new Object[rows][2];
		for (int i=0;i<rows;i++) {

			credentials [i][0] = confi.getData(0, i, 0);
			credentials [i][1] = confi.getData(0, i, 1);
		}
		return credentials;
	}

}


