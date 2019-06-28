package recursion;

public class StepsToDestination_FlipKart {
	
	static int steps(int source, int step, int destination){
		if (Math.abs(source)>destination){
			return Integer.MAX_VALUE;
		} else if(source==destination){
			return step;
		}
		
		int pos = steps(source+step+1, step+1, destination);
		//System.out.println(pos);
		int neg = steps(source-step-1, step+1, destination);
		//System.out.println(neg);
		return Math.min(pos, neg);
	}
	public static void main(String[] args) {

        int dest = 11; 
        System.out.println("No. of steps required"+ 
                                " to reach " + dest + 
                       " is " + steps(0, 0, dest)); 
	}
}
