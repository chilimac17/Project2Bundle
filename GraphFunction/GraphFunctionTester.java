package GraphFunction;

import java.io.IOException;

public class GraphFunctionTester {
    public static void main(String[] args){
        plotter p1 = new plotter();
        salter s1 = new salter();
        //p1.createData();
        try {
            s1.test();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
