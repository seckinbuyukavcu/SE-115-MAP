class WayFinder {
    private CountryMap map;

    public WayFinder(CountryMap map) {
        this.map = map;
    }

    public String findFastestWay() {
        String start = map.getRoute()[0];
        String end = map.getRoute()[1];
        String[] gidilmis = new String[map.getCityNumber()];
        String[] path = new String[map.getCityNumber()];
        int[] pathIndex = {0};
        int totalTime = explore(start, end, gidilmis, 0, path, pathIndex);

        if (totalTime == Integer.MAX_VALUE) {
            return "No path found.";
        } else {
        	String result = "Fastest Way: ";
        	for (int i = 0; i < pathIndex[0]; i++) {
        	    result += path[i];
        	    if (i < pathIndex[0] - 1) {
        	        result += " -> ";
        	    }
        	}
        	result += "\nTotal Time: " + totalTime + " min";
        	return result;
        }
    }

    private int explore(String current, String end, String[] visited, int visitedCount, String[] path, int[] pathIndex) {
        if (current.equals(end)) {
            path[pathIndex[0]++] = current;
            return 0;
        }

        visited[visitedCount++] = current;
        path[pathIndex[0]++] = current;
        int shortestTime = Integer.MAX_VALUE;

        for (String[] route : map.getCitiesAndTimes()) {
        	
            if (route[0].equals(current) && !isVisited(route[1], visited, visitedCount)) {
                int routeTime = Integer.parseInt(route[2]);
                String[] tempPath = new String[path.length];
                
                
                for (int i = 0; i < pathIndex[0]; i++) {
                    tempPath[i] = path[i];
                }

                int[] tempPathIndex = {pathIndex[0]};
                int totalTime = explore(route[1], end, visited.clone(), visitedCount, tempPath, tempPathIndex);
                
                if (totalTime != Integer.MAX_VALUE && totalTime + routeTime < shortestTime) {
                    shortestTime = totalTime + routeTime;
                    for (int i = 0; i < tempPathIndex[0]; i++) {
                        path[i] = tempPath[i];
                    }

                    pathIndex[0] = tempPathIndex[0];
                }
                
            }
        }

        pathIndex[0]--;
        return shortestTime;
    }

    private boolean isVisited(String city, String[] visited, int visitedCount) {
        for (int i = 0; i < visitedCount; i++) {
            if (visited[i].equals(city)) {
                return true;
            }
        }
        return false;
    }
}
