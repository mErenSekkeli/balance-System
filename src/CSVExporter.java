
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.sql.*;
import java.text.DecimalFormatSymbols;
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

    private static char getSeperator() {
        return ((new DecimalFormatSymbols().getDecimalSeparator()) == ',') ? ';' : ',';
    }

    private static String encodeString(String str, char seperator) {
        return str.replaceAll("" + seperator, ((seperator == ',') ? "\\," : "\\;)"));
    }

    private static void writeToCSV(String fileName, String data) throws IOException {
        File targetFile = new File(fileName);
        final byte[] bom = new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        try ( OutputStream os = new FileOutputStream(targetFile)) {
            os.write(bom);

            try ( PrintWriter w = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8))) {
                w.print(data);

                w.flush();
            }
        }
    }

    public static void rsExportResultSet(String fileName, ResultSet data, boolean excelCompatible) throws SQLException, FileNotFoundException, IOException {
        char seperator = getSeperator();
        String out = "";
        ResultSetMetaData rsmd = data.getMetaData();
        int colCount = rsmd.getColumnCount();

        for (int i = 1; i <= colCount; i++) {
            String columnName = rsmd.getColumnName(i);
            out += columnName;
            if (i != colCount) {
                out += seperator;
            }
        }
        if (excelCompatible) {
            out += "\r\n";
        } else {
            out += '\n';
        }

        while (data.next()) {
            for (int i = 1; i <= colCount; i++) {
                Object obj = data.getObject(i);
                if (obj != null) {
                    String str;
                    if (excelCompatible && obj instanceof Timestamp) {
                        str = ("=\"" + obj.toString() + "\"");
                    } else {
                        str = "\"" + encodeString(obj.toString(), seperator) + "\"";
                    }
                    out += str;
                } else {
                    out += "null";
                }
                if (i != colCount) {
                    out += seperator;
                }
            }

            if (excelCompatible) {
                out += "\r\n";
            } else {
                out += '\n';
            }
        }

        writeToCSV(fileName, out);
    }

    public static void jtExportResultSet(String fileName, JTable data, boolean excelCompatible) throws SQLException, FileNotFoundException, IOException {
        char seperator = getSeperator();
        String out = "";
        TableColumnModel tcm = data.getColumnModel();
        int colCount = tcm.getColumnCount();
        List<String> columnNames = new ArrayList<>();

        for (int i = 0; i < colCount; i++) {
            columnNames.add(data.getColumnName(i));
        }

        out += String.join(Character.toString(seperator), columnNames);

        if (excelCompatible) {
            out += "\r\n";
        } else {
            out += '\n';
        }
        int rowCount = data.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                Object obj = data.getValueAt(i, j);
                if (obj != null) {
                    String str;

                    if (excelCompatible && obj instanceof Timestamp) {
                        str = ("=\"" + obj.toString() + "\"");
                    } else {
                        str = "\"" + encodeString(obj.toString(), seperator) + "\"";
                    }
                    out += str;
                } else {
                    out += "null";
                }
                if (j != colCount - 1) {
                    out += seperator;
                }
            }

            if (excelCompatible) {
                out += "\r\n";
            } else {
                out += '\n';
            }
        }

        writeToCSV(fileName, out);
    }

    public static <T> void exportIterable(String fileName, Iterable<Iterable<? extends CharSequence>> objList, ArrayList<String> headers) throws FileNotFoundException, IOException {
        File targetFile = new File(fileName);

        try ( OutputStream outStream = new FileOutputStream(targetFile)) {
            outStream.write(String.join(",", headers).getBytes());
            outStream.write('\n');

            for (Iterable<? extends CharSequence> obj : objList) {
                outStream.write(String.join(",", obj).getBytes());
                outStream.write('\n');
            }
        }
    }
}
