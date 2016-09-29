
import java.util.*;

public class Race
 {
	public int closestCheckPoint(int[] runner1, 
								 int[] runner2, 
								 int[] runner3) {
		int numOfCheckpoints = runner1.length;
	    ArrayList<Integer> differenceList = new ArrayList<Integer>();
		for(int i = 0; i < numOfCheckpoints; i++){
			int currentRunner1Time = runner1[i];
			int currentRunner2Time = runner2[i];
			int currentRunner3Time = runner3[i];
			ArrayList<Integer> timesList = new ArrayList<Integer>();
			timesList.add(currentRunner1Time);
			timesList.add(currentRunner2Time);
			timesList.add(currentRunner3Time);
			int smallest = Collections.min(timesList);
			int biggest = Collections.max(timesList);
			int difference = Math.abs(biggest-smallest);
			differenceList.add(difference);
		}
		
		return differenceList.lastIndexOf(Collections.min( differenceList));
	}
}
