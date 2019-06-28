package recursion;

public class DestinationReachable {

	public static void main(String[] args) {

        int source_x = 2, source_y = 10; 
        int dest_x = 3, dest_y = 12; 
        if (isReachable(source_x, source_y, dest_x, dest_y)){
        	System.out.println("True");
        } else {
        	System.out.println("False");
        }
	}
	
	private static boolean isReachable(int sx, int sy, int dx, int dy){
		if (sx>dx||sy>dy){
			return false;
		} else if (sx==dx && sy==dy){
			return true;
		}
		
		return isReachable(sx+sy, sy, dx, dy)|| isReachable(sx, sy+sx, dx, dy);
	}
}
