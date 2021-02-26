package com.company;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class WriteExcelBatch   {
    private static String[] columns = {"Batch #", "ID #", "Processes"};
    private static List<Batch> batchList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Process Autofiller 2000! A modern solution for redundantly typing the same processes! \n" +
                "Type \"done\" when you are finished and an Excel file with all of the neatly formatted information will appear on your desktop ;)!");
        System.out.println();
        System.out.println("What do you want this .xlsx to be called?");
        String batchName = sc.nextLine();


        boolean flag = false;
        while(!flag){
        System.out.print("Batch #: ");
        String batchNumber = sc.nextLine();
        System.out.print("ID #: ");
        String idNum = sc.nextLine();

        //calculate process
            String process = "";
            switch (idNum){
                case "123456":
                    process = "apple,orange,raspberry,peach";
                  break;
                case "654321":
                    process = "ham,pork,hotdog,steak,beef";
                    break;
                case "24680":
                    process = "chocolate,candy,sucker,sugar";
                    break;
            }

        Batch batchEntry = new Batch(batchNumber, idNum, process);
        batchList.add(batchEntry);

            String response = sc.nextLine();
            if(response.equals("done")) {
                flag = true;
            }
           else{
               flag = false;
            }
        }//end while loop

        //create a .xlsx file
        Workbook workbook = new XSSFWorkbook();
         /* CreationHelper helps us create instances for various things like DataFormat,
           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        //create a sheet in the .xlsx file
        Sheet sheet = workbook.createSheet("WriteExcelBatch");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        ((XSSFFont) headerFont).setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Creating cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        //create other rows and cells


        int rowNum = 1;
        for(Batch batch : batchList){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(batch.getBatchNumber());
            row.createCell(1).setCellValue(batch.getIdNum());
            formatProcesses(batch.getProcess(), sheet, rowNum);
            int newStart =  formatProcesses(batch.getProcess(), sheet, rowNum); //pull the returned newStart value out of the formatProcesses method
            rowNum = newStart;
        }

        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file on Desktop
        FileOutputStream fileOut = new FileOutputStream(batchName +".xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();

    }


    public static int formatProcesses(String process, Sheet sheet, int rowNum){
        String[] processArray = process.split(",");
        Batch batch = new Batch();
        int rowCounter = rowNum + 1; //initialize rowCounter
        for(int i = 0; i < processArray.length; i++){//takes us through each substring, printing each on out on a different row
            Row row = sheet.createRow(rowNum++);
            row.createCell(2).setCellValue(processArray[i]);
            rowCounter++;
        }
        int newStart = rowCounter + 1; //declare newStart
        batch.setNewStart(newStart);
        return newStart;
    }
}


class Process{
    private String process;
    private int newStart;

    public Process(String process){
        this.process = process;
    }

    public Process() {

    }

    //setters and getters
    public String getProcess(){
        return process;
    }
    public void setProcess(){
        this.process = process;
    }
    public String toString(){
        return this.process + " " + newStart;
    }

    public int getNewStart() {
        return newStart;
    }

    public void setNewStart(int newStart) {
        this.newStart = newStart;
    }
}

class Batch extends Process{
    private String batchNumber;
    private String idNum;

    public Batch(){ // default constructor
        super();
    } //set a default constructor


    public Batch(String batchNumber, String idNum, String process){
        super(process);
        this.batchNumber = batchNumber;
        this.idNum = idNum;

    }

    //setter and getter
    public String getBatchNumber(){
        return batchNumber;
    }
    public void setBatchNumber(String batchNumber){
        this.batchNumber = batchNumber;
    }

    public String getIdNum(){
        return idNum;
    }
    public void setIdNum(){
        this.idNum = idNum;
    }
    public String toString(){
        return this.batchNumber + " " + this.idNum;
    }


}






