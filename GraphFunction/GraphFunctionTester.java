package GraphFunction;

import java.io.IOException;

public class GraphFunctionTester {
    public static void main(String[] args){
        //plotter p1 = new plotter();
        //salter s1 = new salter();
        smoother sm1 = new smoother();
        //p1.createData();
        //s1.createSaltData();
        sm1.createSmoothData(2);
    }
}
