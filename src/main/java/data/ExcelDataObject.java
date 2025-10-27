package data;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

public class ExcelDataObject {

    @ExcelRow
    public int index;

    @ExcelCellName("UserName")
    public String UserName;

    @ExcelCellName("Password")
    public String Password;

    @ExcelCellName("MultiTestData")
    public String MultiTestData;

    public String getMultiTestData(){
        return MultiTestData;
    }

    @Override
    public String toString(){
        return (this.MultiTestData !=null && !this.MultiTestData.isEmpty())
                ? this.MultiTestData
                : "";
    }

}
