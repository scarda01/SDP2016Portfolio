package sml;

/**
 * Created by Salvo on 14/02/2016.
 */
public class OutInstruction extends Instruction {

    private int register;

    public OutInstruction(String label, String op) {
        super(label, op);
    }

    public OutInstruction(String label, int register) {
        this(label, "div");
        this.register = register;
    }

    @Override
    public String toString() {
        return super.toString() + " out from " + register;
    }

    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(register);
        System.out.println(value1);
    }
}
