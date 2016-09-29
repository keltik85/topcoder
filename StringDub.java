import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;

public class StringDub
{
	public char getMax(String input){
		char mostOccuringChar = '!';
		final ConcurrentHashMap<Character, Integer> currentConcurrentHashmap = 
			new ConcurrentHashMap<Character, Integer>();
		int numOfCores = Runtime.getRuntime().availableProcessors();
		System.out.println("numOfCores ---> " + numOfCores);
		String[] inputSplitted = split(input, numOfCores);
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i < inputSplitted.length; i++){
			final String currentInputSplitted = inputSplitted[i];
			Thread thread = new Thread(new Runnable() {
					public void run() {
						for(int ii = 0; ii < currentInputSplitted.length(); ii++){
							char currentCharacter = currentInputSplitted.charAt(ii);
							if(currentConcurrentHashmap.containsKey(currentCharacter)){
								int currentValue = currentConcurrentHashmap.get(currentCharacter);
								currentValue = currentValue + 1;
								currentConcurrentHashmap.put(currentCharacter,currentValue);
							}else{
								currentConcurrentHashmap.put(currentCharacter,1);
							}	
						}
					}
			});
			threads.add(thread);
		}
		startThreads(threads);
		joinThreads(threads);
		System.out.println("input = " + input + "\ncurrentConcurrentHashmap ---> " + currentConcurrentHashmap);	
		return findMaxFromMap(input, currentConcurrentHashmap, mostOccuringChar);
	}

	private char findMaxFromMap(String input, ConcurrentHashMap<Character, Integer> currentConcurrentHashmap, char mostOccuringChar)
	{
		int maxValue = 0;

		for (int i = 0; i < input.length(); i++)
		{
			int currentValue = currentConcurrentHashmap.get(input.charAt(i));
			if (currentValue > maxValue)
			{
				mostOccuringChar = input.charAt(i);
				maxValue = currentValue;
			}
		}
		return mostOccuringChar;
	}

	private void joinThreads(ArrayList<Thread> threads)
	{
		for (Thread thread: threads)
		{
			try
			{
				thread.join();
			}
			catch (InterruptedException e)
			{
				System.out.println("Exception occured = " + e);
			}
		}
	}

	private void startThreads(ArrayList<Thread> threads)
	{
		for (Thread thread: threads)
		{
			thread.start();
		}
	}

	private String[] split(String input, int numOfCores)
	{
		int splitLength = (int) Math.ceil(Double.valueOf(input.length()) / Double.valueOf(numOfCores));
		String[] inputSplitted = Iterables.toArray(
			Splitter
            .fixedLength(splitLength)
            .split(input),
			String.class
		);

		System.out.println(
			"inputSplitted = " + Arrays.toString(inputSplitted));
		return inputSplitted;
	}
}
