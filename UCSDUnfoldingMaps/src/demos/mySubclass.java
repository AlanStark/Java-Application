package demos;

/**
 * Created by alan_stark_z on 5/1/17.
 */
public class mySubclass extends mySuperclass {

    public void printMethod() // override
    {
        super.printMethod(); // Call printMethod in mySuperclass
        System.out.println("Printed in Subclass.");
    }

    public static void main(String[] args)
    {
        mySubclass S = new mySubclass();
        S.printMethod();
    }
}
