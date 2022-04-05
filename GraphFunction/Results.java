package GraphFunction;

public class Results {
    /**
     * Creating a method that will print all csv files needed. 3 second delay in between
     */
   public void results(){
        try {
            Plotter p1 = new Plotter();
            p1.createData();
            Thread.sleep(3000);
            Salter s1 = new Salter();
            s1.createSaltData();
            Thread.sleep(3000);
            Smoother sm1 = new Smoother();
            sm1.createSmoothData(2);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }   
   } 
}
