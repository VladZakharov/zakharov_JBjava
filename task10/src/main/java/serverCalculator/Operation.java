package serverCalculator;

/**
 * Created by vlad on 08.10.15.
 */
class Operation {

    public Operation(String type) {
        this.type = type;
    }

    Contaner prev = null;
    Contaner next = null;

    Operation prevO = null;
    Operation nextO = null;

    String type = null;
    Double result = null;

}