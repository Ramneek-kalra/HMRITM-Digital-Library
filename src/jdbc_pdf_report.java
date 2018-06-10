

import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
public class jdbc_pdf_report {  
        public void report(int il) throws Exception{
                String filep = "C:\\Users\\Ramneek Kalra\\Desktop\\Fine Receipt.pdf";
                /* Create Connection objects */
                Class.forName ("com.mysql.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "HMRITM");
                Statement stmt = conn.createStatement();
                /* Define the SQL query */
                ResultSet query_set = stmt.executeQuery("SELECT * from fine_Details where Issue_Id = "+il);
                /* Step-2: Initialize PDF documents - logical objects */
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream(filep));
                my_pdf_report.addAuthor("HMRITM Digital Library");
                my_pdf_report.addTitle("HMRITM Library Fine Receipt");
                my_pdf_report.open();
                
                
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(4);
                //create a cell object
                PdfPCell table_cell;
               
                while (query_set.next()) {
                                String dept_id = query_set.getString("Fine_id");
                                table_cell=new PdfPCell(new Phrase(dept_id));
                                my_report_table.addCell(table_cell);
                                String dept_name=query_set.getString("Issue_Id");
                                table_cell=new PdfPCell(new Phrase(dept_name));
                                my_report_table.addCell(table_cell);
                                String manager_id=query_set.getString("Days");
                                table_cell=new PdfPCell(new Phrase(manager_id));
                                my_report_table.addCell(table_cell);
                                String manager_i=query_set.getString("Amount");
                                table_cell=new PdfPCell(new Phrase(manager_i));
                                my_report_table.addCell(table_cell);
                                }
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File(filep));
                my_pdf_report.close();
                
                /* Close all DB related objects */
                query_set.close();
                stmt.close(); 
                conn.close();               
                
        }
}