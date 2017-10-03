package msft;

public class TriangleArea {
	
	public static void main(String[] args) {
		
		printSummary(0,0,0,0,0,0); // 0
 		printSummary(0,0,1,1,2,2); // 0
 		printSummary(0,0,1,1,0,1); // 
 		printSummary(Double.MAX_VALUE, Double.MAX_VALUE,
 					Double.MAX_VALUE, Double.MIN_VALUE,
 					Double.MIN_VALUE, Double.MIN_VALUE);
	}
	    
	//Write a method that takes as an argument the coordinates of three points that represent a triangle and calculates its area.
    public static double triArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Heron's formula: Area = sqrt ( p * (p-a)  * (p -b) * (p -c)) , where a, b, c are the edges and p = (a+b+c)/2
    	
    	// check to see if we have 2 lines with vertical slope -> if so, area == 0
        if (x1 == x2 && x1 == x3) {
        	return 0;
        }
    	
        // check to make sure that edges do not share a slope -> if they do, we have a line, and area == 0
    	if(x1 != x2 && x1 != x3 
    		&& (y2 - y1)/(x2 - x1) == (y2 - y3)/(x2 - x3)) {
    		return 0;
    	}
        
    	// calculate each subvalue and check if it's valid or if we have a  triangle that breaks the
    	// limitations of our function(s)
        double a = edgeLength(x1,y1,x2,y2);
        if (validateResult(a)) {
        	return -1;
        }
        double b = edgeLength(x1,y1,x3,y3);
        if (validateResult(b)) {
        	return -1;
        }
        double c = edgeLength(x2,y2,x3,y3);
        if (validateResult(c)) {
        	return -1;
        }
        
        double p = calcP(a, b, c);
        if (validateResult(b)) {
        	return -1;
        }
        
        double area = internalArea(p, a, b, c);
        if (validateResult(area)) {
        	return -1;
        }
        
        return area;
    }

    private static double edgeLength(double x1, double y1, double x2, double y2) {
    	double xSquared = Math.pow(x2 - x1, 2);
    	double ySquared = Math.pow(y2 - y1, 2);
        return Math.sqrt(xSquared + ySquared);
    }
    
    private static double calcP(double a, double b, double c) {
        return (a + b + c)/2;
    }
    
    private static double internalArea(double p, double a, double b, double c) {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    
    private static boolean validateResult(double val) {
    	return Double.isNaN(val) || Double.isInfinite(val);
    }
    
    private static void printSummary(double x1, double y1, double x2, double y2, double x3, double y3) {
    	System.out.println("<(" + x1 + ", " + y1 + ")," + "(" + x2 + ", " + y2 + ")," + "(" + x3 + ", " + y3 + ")> == " 
    						+ triArea(x1,y1,x2,y2,x3,y3));
    }
}