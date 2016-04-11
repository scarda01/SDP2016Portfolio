package sml;

/**
 * Created by Salvo on 05/03/2016.
 */
public class BnzInstruction extends Instruction {
    private int register;
    private String targetlabel;

    public BnzInstruction(String label, String op) {
        super(label, op);
    }

    public BnzInstruction(String label, int register, String targetlabel) {
        this(label, "bnz");
        this.register = register;
        this.targetlabel = targetlabel;
    }

    @Override
    public void execute(Machine m) {
        if(m.getRegisters().getRegister(register) != 0)
        {
            m.setPc(m.getLabels().indexOf(targetlabel));
        }
    }

    @Override
    public String toString() {
        return super.toString() + " If " + register + " not zero jump to " + targetlabel;
    }
}
