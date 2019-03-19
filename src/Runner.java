public class Runner {
    public static void main(String[] args) {
        Engine e= new Engine();
        e.start();
        System.out.print("HELLO");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        e.setCont(false);

        System.out.println("MAIN");
    }
}
