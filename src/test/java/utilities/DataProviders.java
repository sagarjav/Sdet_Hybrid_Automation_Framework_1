package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

    @DataProvider(name = "CompoundIntCal")
    public Object[][] getData() throws IOException {
        
    	String filepath = "E:\\New Volume D\\Software Testing\\Project -Groww details\\Sdet_Hybrid_Automation_Framework\\testData\\Compound_testDDTFinal.xlsx";
        
        ExcelUtils xUtils = new ExcelUtils();
        int totalRow = xUtils.getRowCount(filepath, "sheet1"); // e.g., 4
        int totalCell = xUtils.getCellCount(filepath, "sheet1", 1); // e.g., 8
        
        System.out.println("Total Rows: " + totalRow + " Total Cells: " + totalCell);
        
        Object[][] compoundInterestCalculatorData = new Object[totalRow][totalCell];
        
        for (int i=1; i <= totalRow; i++) 
        {
            for (int j=0; j < totalCell; j++) 
            {
                compoundInterestCalculatorData[i-1][j] = xUtils.getCellData(filepath, "sheet1", i, j);
            }
        }
        
        // return the data to be used by the test method
        // compoundInterestCalculatorData;
        
        for(int m=0; m<compoundInterestCalculatorData.length; m++)
        {
        	for(int L=0; L<compoundInterestCalculatorData[m].length; L++)
        	{
        		System.out.print(compoundInterestCalculatorData[m][L]+" ");
        	}
        	System.out.println();
        }
        
       return compoundInterestCalculatorData;
    }

   
}
