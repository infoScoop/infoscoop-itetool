package org.infoscoop.itetool;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

/**
 * @author ishizuka
 * @version 2014-09-09
 */
public class Main {

    public static void main(String[] args) {
        InputStream in = null;
        try {
            String propFile = System.getProperty("user.dir") + File.separator + "makecsv.properties";

            if(args.length > 0) {
                propFile = System.getProperty("user.dir") + File.separator + args[0];
            }
            System.out.println("Properties: " + propFile);

            in = new BufferedInputStream(new FileInputStream(propFile));
            Properties prop = new Properties();
            prop.load(in);
            
            String dirPath =  System.getProperty("user.dir") + File.separator + prop.getProperty("directory_path");
            System.out.println("Target Directory: " + dirPath);
            String oldCSVName = prop.getProperty("old_csv_name");
            String newCSVName = prop.getProperty("new_csv_name");
            String orderPatterns[] = prop.getProperty("order_patterns").split(",");
            boolean isUseCSVHeader = "true".equals(prop.getProperty("use_csv_header"));
            
            FileInfoCSVMaker ficm = new FileInfoCSVMaker(dirPath, oldCSVName, newCSVName, orderPatterns, isUseCSVHeader);
            
            System.out.println("start");
            ficm.exec();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch(SecurityException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("end");  
        }
    }
}
