
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.sql.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.TimeZone;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author laptop
 */
public class CSVExporter {
    public static void rsExportResultSetWithDialog(JFrame parentFrame, ResultSet data, boolean excelCompatible) throws SQLException, IOException, IOException {
 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");   
 
        int userSelection = fileChooser.showSaveDialog(parentFrame);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            rsExportResultSet(fileToSave.getAbsolutePath(), data, excelCompatible);
        }
    }
    
    public static void jtExportResultSetWithDialog(JFrame parentFrame, JTable data, boolean excelCompatible) throws SQLException, IOException, IOException {
 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");   
 
        int userSelection = fileChooser.showSaveDialog(parentFrame);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            jtExportResultSet(fileToSave.getAbsolutePath(), data, excelCompatible);
        }
    }
    
    public static void rsExportResultSet(String fileName, ResultSet data, boolean excelCompatible) throws SQLException, FileNotFoundException, IOException {
        File targetFile = new File(fileName);
        
        try (OutputStreamWriter outStreamWrapped = new OutputStreamWriter(new FileOutputStream(targetFile), StandardCharsets.UTF_8); BufferedWriter outStream = new BufferedWriter(outStreamWrapped)) {
            ResultSetMetaData rsmd = data.getMetaData();
            int colCount = rsmd.getColumnCount();
         
            for(int i = 1; i <= colCount; i++) {
                String columnName = rsmd.getColumnName(i);
                outStream.write(columnName);
                if(i != colCount) {
                    outStream.write(',');
                }
            }
            outStream.write('\n');
            
            while(data.next()) {
                for(int i = 1; i <= colCount; i++) {
                    Object obj  = data.getObject(i);
                    if(obj != null) {
                        String str;
                        if(obj.toString().contains(",")) {
                            str = "\"" + obj.toString() + "\"";
                        }
                        else if(excelCompatible) {
                            str = ("=\"" + obj.toString() + "\"");
                        } else {
                            str = obj.toString();
                        }
                        outStream.write(str);
                    }  else {
                        outStream.write("null");
                    }
                    if(i != colCount) {
                        outStream.write(',');
                    }
                }
                
                outStream.write('\n');
            }
        }
        
    }
    
    
    
    public static void jtExportResultSet(String fileName, JTable data, boolean excelCompatible) throws SQLException, FileNotFoundException, IOException {
        File targetFile = new File(fileName);
        
        try (OutputStreamWriter outStreamWrapped = new OutputStreamWriter(new FileOutputStream(targetFile), StandardCharsets.UTF_8); BufferedWriter outStream = new BufferedWriter(outStreamWrapped)) {
            outStream.write('\ufeff');
            TableColumnModel tcm = data.getColumnModel();
            int colCount = tcm.getColumnCount();
            
            List<String> columnNames = new ArrayList<>();
            
            for(int i = 0; i < colCount; i++) {
                columnNames.add(data.getColumnName(i));
            }
            
            
            outStream.write(String.join(",", columnNames));
            
            outStream.write('\n');
            int rowCount = data.getRowCount();
            for(int i = 0; i < rowCount; i++) {
                for(int j = 0; j < colCount; j++) {
                    Object obj  = data.getValueAt(i, j);
                    if(obj != null) {
                        String str;
                        if(obj.toString().contains(",")) {
                            str = "\"" + obj.toString() + "\"";
                        } else if(excelCompatible) {
                            str = ("=\"" + obj.toString() + "\"");
                        } else {
                            str = obj.toString();
                        }
                        outStream.write(str);
                    }  else {
                        outStream.write("null");
                    }
                    if(j != colCount - 1) {
                        outStream.write(',');
                    }
                }
                
                outStream.write('\n');
            }
            
        }
        
    }
    public static <T> void exportIterable(String fileName, Iterable<Iterable<? extends CharSequence>> objList, ArrayList<String> headers) throws FileNotFoundException, IOException {
        File targetFile = new File(fileName);
        
        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            outStream.write(String.join(",", headers).getBytes());
            outStream.write('\n');
            
            for(Iterable<? extends CharSequence> obj: objList) {
                outStream.write(String.join(",", obj).getBytes());
                outStream.write('\n');
            }
        }
    }
}
