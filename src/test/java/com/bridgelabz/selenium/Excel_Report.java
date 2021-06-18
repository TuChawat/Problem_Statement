/**
 * Description : Extent_Report.java is the test file having test case for generating Excel Report.
 * Author      : Tushar Chawat
 * Date        : 03/06/2021
 */

package com.bridgelabz.selenium;

import org.automationtesting.excelreport.Xl;

public class Excel_Report {
    public static void main (String [] args) throws Exception {
        Xl.generateReport("ExcelReportFile.xlsx");
        Xl.generateReport("D:\\Excel","ExcelReportFile.xlsx");
    }
}
