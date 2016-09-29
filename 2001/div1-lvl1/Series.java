
import java.util.*;public class Series
{
	int increasingLength(int[] param0){
		int lengthOfLongestSequence = 1;
		ArrayList<Integer> currentSublist = new ArrayList<Integer>();
		for (int i = 0; i < param0.length; i++) {
			for (int j = i; j < param0.length; j++) {
				for (int k = i; k <= j; k++){
					currentSublist.add(param0[k]);
				}
				int maxLen = 0;
				int lastElem = -10000;
				for(int l = 0; l < currentSublist.size(); l++){
					int currentElem = currentSublist.get(l);
					if(currentElem > lastElem){
						maxLen = maxLen + 1;
						lastElem = currentElem;
					}
				}
				if(maxLen > lengthOfLongestSequence){
					lengthOfLongestSequence = maxLen;
				}
				currentSublist.clear();
			}
		}
		return lengthOfLongestSequence;
	}
}
