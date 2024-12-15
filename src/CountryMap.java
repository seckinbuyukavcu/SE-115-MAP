
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountryMap {

    private City[] cities;
    private int cityNumber;
    private String[][] citiesAndTimes;
    private int routeNumber;
    private String[] route;

    public CountryMap() {
        ayikla();
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public int getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(int cityNumber) {
        this.cityNumber = cityNumber;
    }

    public String[][] getCitiesAndTimes() {
        return citiesAndTimes;
    }

    public void setCitiesAndTimes(String[][] citiesAndTimes) {
        this.citiesAndTimes = citiesAndTimes;
    }

    public String[] getRoute() {
        return route;
    }

    public void setRoute(String[] route) {
        this.route = route;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }
    

    public void ayikla(){
    	Scanner sc = null;
        try{
            sc = new Scanner(Paths.get("dosya.txt"));
            this.cityNumber = Integer.parseInt(sc.nextLine()); 
            String[] aray = sc.nextLine().split(" ");
            
            this.cities = new City[cityNumber];
            for(int i = 0;i < cityNumber;i++){
                this.cities[i].setCity(aray[i]);
            }
            this.routeNumber = Integer.parseInt(sc.nextLine());
            this.citiesAndTimes = new String[routeNumber][3];
            for(int i = 0;i<routeNumber;i++){
                this.citiesAndTimes[i] = sc.nextLine().split(" ");
            }
            this.route = new String[2];
            this.route = sc.nextLine().split(" ");
           
        } catch (IOException e) {
			System.out.println("Dosya bulunamadi!");
		} finally {
			sc.close();
		}
       
    }

    

}
