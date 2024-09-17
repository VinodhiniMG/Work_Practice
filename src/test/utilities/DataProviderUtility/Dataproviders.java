package DataProviderUtility;

import ExcelUtility.Excelutils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class Dataproviders {
    @DataProvider(name="logindata")
    public String [][] getData() throws IOException {
        String path=".\\testData\\Logindata.xlsx";
        Excelutils xlutils= new Excelutils(path);
        int totalrows=xlutils.getRowCount("Sheet1");
        int totalcols=xlutils.getCellCount("Sheet1",1);
        String [][]logindata= new String [totalrows][totalcols];
        for(int i=1;i<=totalrows;i++){
            for(int j=0;j<totalcols;j++){
                logindata[i-1][j]=xlutils.getCellData("Sheet1",i,j);
            }
        }
        return logindata;
    }
}
