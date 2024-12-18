
public class Main {
    public static void main(String[] args) {
        CountryMap map = new CountryMap();
        WayFinder finder = new WayFinder(map);
        String result = finder.findFastestWay();
        System.out.println(result);
    }
}