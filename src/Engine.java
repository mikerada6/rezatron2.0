public class Engine extends Thread {

    private boolean cont;
    private int count;

    public Engine()
    {
            count=0;
            cont=true;
    }

    public void run()
    {
        boolean cont2 = true;
        while(cont2) {
            count++;
            System.out.print(".");
            if(count%100==0)
            {
                System.out.println("");
            }
            if(!this.isCont())
            {
                cont2=false;
            }

        }
        System.out.println("DONE");
    }


    public synchronized  boolean isCont() {
        return cont;
    }

    public synchronized void setCont(boolean cont) {
        this.cont = cont;
    }
}
