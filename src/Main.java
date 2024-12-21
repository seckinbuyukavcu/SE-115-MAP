import java.io.FileNotFoundException;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
    	
    	if(args.length < 1) {
    		System.out.println("enter the file name correctly");
    		return;
    	}
    	
    	String source = args[0];
    	
        CountryMap map = new CountryMap(source);
        WayFinder finder = new WayFinder(map);
        String result = finder.findFastestWay();
        Formatter formatter = null;
        try {
        	 formatter = new Formatter("output.txt");
        	 formatter.format("%s", result);
        	 System.out.println("file created successfully");
        } catch (FileNotFoundException e) {
            System.err.println("file couldnt created");
        } finally {
        	if(formatter != null) {
        		formatter.close();
        	}
        }
        System.out.println(result);
    }
}