package projectbundle2.GraphFunction;

public class Results {
    /**
     * Creating a method that will print all csv files needed. 3 second delay in between
     */
   public void results(){
        try {
            plotter p1 = new plotter();
            p1.createData();
            Thread.sleep(3000);
            salter s1 = new salter();
            s1.createSaltData();
            Thread.sleep(3000);
            smoother sm1 = new smoother();
            sm1.createSmoothData(2);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }   
   } 
}
