package allocationAlgorithm;

import java.util.Arrays;

import calculationUtil.CUtil;

public class SafetyAlgo {
	public static class NoResourceTypesException extends Exception{
		public NoResourceTypesException(){super("There must be at least one resource type!");}
	}
	
	public static class NonMatchingDimensionsException extends Exception{
		public NonMatchingDimensionsException(){super("The dimensions of the arrays do not match!");}
	}
	
	public static boolean checkIfSafeState(int[] freeResIni, int[][] acquiredResIni, int[][] pendingResIni) throws NoResourceTypesException, NonMatchingDimensionsException {
		if(acquiredResIni.length == 0 || pendingResIni.length == 0) throw new NoResourceTypesException();
		if(acquiredResIni.length != pendingResIni.length || freeResIni.length != acquiredResIni[0].length || freeResIni.length != pendingResIni[0].length) throw new NonMatchingDimensionsException();
		
		int[] freeRes = freeResIni.clone();
		int[][] acquiredRes = acquiredResIni.clone();
		int[][] pendingRes = pendingResIni.clone();
		int resourceTypeNum = freeRes.length;
		int processNum = acquiredRes.length;
		boolean existsSatisfiable = false;
		boolean allZero = true;
		do {
			existsSatisfiable = false;
			allZero = true;
			for (int i=0; i<processNum; i++){
				//Ist der Prozess noch nicht befriedigt?
				if(!(CUtil.allZero(pendingRes[i]) && CUtil.allZero(acquiredRes[i]))) {
					allZero = false;
					//Gibt es genug freie Ressourcen, um den Prozess zu befriedigen?
					if(CUtil.greaterEqual(freeRes, pendingRes[i])){
						freeRes = CUtil.add(freeRes, acquiredRes[i]);
						acquiredRes[i] = new int[resourceTypeNum];
						pendingRes[i] = new int[resourceTypeNum];
						System.out.println("P " + i + ": " + Arrays.toString(freeRes));
						existsSatisfiable = true;
						break;
					}
				}
			}
		} while (existsSatisfiable);
		//Alle Prozesse sind befriedigt gdw. kein Thread noch pending Ressourcen hat.
		return allZero;
	}
	
}