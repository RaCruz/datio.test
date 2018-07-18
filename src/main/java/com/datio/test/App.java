package com.datio.test;
import java.io.*;
import java.util.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static Logger logger = LogManager.getLogger(App.class);

    public BufferedReader loadFile(String path){
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            return new BufferedReader(fileReader);
        }

        catch(Exception e) {
            logger.error("This is error : " + e.getMessage());
            return null;
        }
    }

    public List<String> tokenizeLine(String Line, String separator) {
        try {
            String[] tokens = Line.split(separator);

            return Arrays.asList(tokens);
        }

        catch (Exception e) {
            logger.error("This is error : " + e.getMessage());
            return null;
        }
    }

    public static void main( String[] args )
    {
        String actual_line;
        int multi_family_counter = 0;
        App app = new App();
        BasicConfigurator.configure();

        long time_init = System.currentTimeMillis();

        if (args.length >= 1) {
            BufferedReader bufferedReader = app.loadFile(args[0]);

            try {
                while ((actual_line = bufferedReader.readLine()) != null) {
                    List<String> tokens = app.tokenizeLine(actual_line, ",");

                    if (tokens.contains("Multi-Family")) {
                        logger.info("Multi-Family filter: " + actual_line);

                        multi_family_counter = multi_family_counter + Collections.frequency(tokens, "Multi-Family");
                    }
                }

                logger.info("Multi-Family instances: " + multi_family_counter);
            } catch (Exception e) {
                logger.error("This is error : " + e.getMessage());
            }

            long time_end = System.currentTimeMillis();

            logger.info("Elapsed time: " + (time_end - time_init) + " ms.");
        }

        else
            logger.error("MISSING ARGUMENT");
    }
}
