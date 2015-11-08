//-1*(123+456)*((78-9)^(11+6)-7)*(5^0.5-12)/9-2*7 = 1.1441826130889969E34
//-7+56-8*34-7^5 = -17030
//74-(67-4*(6^3-1)*5^2-11*(3-8)+2+3^2*1) = 21441
//3467-784+98*(67-489/87489*4678)/3784-347+46
package serverCalculator;

import java.util.Objects;

class CalculatorCore {

    private static Contaner expression = null;

    private static String alg = null;

    private static int actionN;

    private CalculatorCore() {
    }

    static Double Solve(String exp) {
        reset();
        expression = new Contaner(exp);
        if (!structureExpression(expression)) return null;
        if (!linkOperations(expression)) return null;
        if (expression.hasBreakets())
            for (int i = 0; i < expression.contaners.size(); i++)
                Solve(expression.contaners.get(i));

        Double result = SolveSimpleExspression(expression);
        System.out.println(alg);
        return result;
    }

    private static void reset() {
        expression = null;
        alg = new String("\nCalculations algorthm:\n");
        actionN = 0;
    }

    private static boolean structureExpression(Contaner contaner) {
        String contanerString = "";
        Contaner newContaner;
        int o = 0;//opened brackets

        try {
            for (int i = 0; i < contaner.content.length(); i++) {

                if (contaner.content.charAt(i) == '(') {
                    if (o == 0) {
                        if (!Objects.equals(contanerString, "")) {
                            newContaner = new Contaner(contanerString);
                            contaner.contaners.add(newContaner);
                            contanerString = "";
                        }
                    } else {
                        contanerString += contaner.content.charAt(i);
                    }
                    o++;
                    continue;
                }

                if (contaner.content.charAt(i) == ')') {
                    o--;
                    if (o == 0) {
                        if (!Objects.equals(contanerString, "")) {
                            newContaner = new Contaner(contanerString);
                            contaner.contaners.add(newContaner);
                            contanerString = "";
                        }
                    } else {
                        contanerString += contaner.content.charAt(i);
                    }
                    continue;
                }

                if (i == 0) {
                    contanerString += contaner.content.charAt(i);
                    continue;
                }

                if (Character.isDigit(contaner.content.charAt(i)) || contaner.content.charAt(i) == '.')
                    contanerString += contaner.content.charAt(i);
                else {
                    if (o != 0) {
                        contanerString += contaner.content.charAt(i);
                    } else {

                        if (!Objects.equals(contanerString, "")) {
                            newContaner = new Contaner(contanerString);
                            contaner.contaners.add(newContaner);
                            contanerString = "";
                        }

                        Operation operation = new Operation("" + contaner.content.charAt(i));
                        contaner.operations.add(operation);
                    }
                }

            }

            if (!Objects.equals(contanerString, "")) {
                newContaner = new Contaner(contanerString);
                contaner.contaners.add(newContaner);
            }
        } catch (Exception e) {
            System.out.println("Exception while parsing!");
            return false;
        }
        return true;
    }

    private static boolean linkOperations(Contaner contaner) {
        try {
            for (int i = 0; i < contaner.operations.size(); i++) {
                contaner.operations.get(i).prev = contaner.contaners.get(i);
                contaner.operations.get(i).next = contaner.contaners.get(i + 1);

                if (i > 0)
                    contaner.operations.get(i).prevO = contaner.operations.get(i - 1);
                if (i < contaner.operations.size() - 1)
                    contaner.operations.get(i).nextO = contaner.operations.get(i + 1);
            }
        } catch (Exception e) {
            System.out.println("Exception while link operations!");
            return false;
        }
        return true;
    }

    private static Double Solve(Contaner contaner) {
        structureExpression(contaner);
        linkOperations(contaner);
        if (contaner.hasBreakets())
            for (int i = 0; i < contaner.contaners.size(); i++)
                Solve(contaner.contaners.get(i));
        return SolveSimpleExspression(contaner);
    }

    private static Double SolveSimpleExspression(Contaner contaner) {

        boolean t = false;

        try {
            contaner.result = Double.parseDouble(contaner.content);
        } catch (Exception e) {
            t = true;
        }

        if (t) {
            actionN += 1;
            alg += actionN + ") " + contaner.content;
        }

        for (int i = 0; i < contaner.operations.size(); i++) {
            if (contaner.operations.get(i).type.equals("^")) {

                double a, b;
                boolean at = false, bt = false;

                try {
                    a = Double.parseDouble(contaner.operations.get(i).prev.content);
                    b = Double.parseDouble(contaner.operations.get(i).next.content);
                } catch (Exception e) {
                    a = contaner.operations.get(i).prev.result;
                    b = contaner.operations.get(i).next.result;
                }

                if (contaner.operations.get(i).prevO != null) {
                    if (contaner.operations.get(i).prevO.result != null) {
                        a = contaner.operations.get(i).prevO.result;
                        at = true;
                    }
                }
                if (contaner.operations.get(i).nextO != null) {
                    if (contaner.operations.get(i).nextO.result != null) {
                        b = contaner.operations.get(i).nextO.result;
                        bt = true;
                    }
                }

                contaner.operations.get(i).result = Math.pow(a, b);
                contaner.result = contaner.operations.get(i).result;

                if (at) {
                    relinkOperations(contaner, contaner.operations.get(i).prevO, contaner.operations.get(i));
                }
                if (bt) {
                    relinkOperations(contaner, contaner.operations.get(i).nextO, contaner.operations.get(i));
                }

                // System.out.println(a+" ^ "+b+" = "+contaner.operations.get(i).result);
            }
        }

        for (int i = 0; i < contaner.operations.size(); i++) {
            if (contaner.operations.get(i).type.equals("*")) {

                double a, b;
                boolean at = false, bt = false;

                try {
                    a = Double.parseDouble(contaner.operations.get(i).prev.content);
                    b = Double.parseDouble(contaner.operations.get(i).next.content);
                } catch (Exception e) {
                    a = contaner.operations.get(i).prev.result;
                    b = contaner.operations.get(i).next.result;
                }

                if (contaner.operations.get(i).prevO != null) {
                    if (contaner.operations.get(i).prevO.result != null) {
                        a = contaner.operations.get(i).prevO.result;
                        at = true;
                    }
                }
                if (contaner.operations.get(i).nextO != null) {
                    if (contaner.operations.get(i).nextO.result != null) {
                        b = contaner.operations.get(i).nextO.result;
                        bt = true;
                    }
                }

                contaner.operations.get(i).result = a * b;
                contaner.result = contaner.operations.get(i).result;

                if (at) {
                    relinkOperations(contaner, contaner.operations.get(i).prevO, contaner.operations.get(i));
                }
                if (bt) {
                    relinkOperations(contaner, contaner.operations.get(i).nextO, contaner.operations.get(i));
                }

                // System.out.println(a+" * "+b+" = "+contaner.operations.get(i).result);
            }

            if (contaner.operations.get(i).type.equals("/")) {

                double a, b;
                boolean at = false, bt = false;

                try {
                    a = Double.parseDouble(contaner.operations.get(i).prev.content);
                    b = Double.parseDouble(contaner.operations.get(i).next.content);
                } catch (Exception e) {
                    a = contaner.operations.get(i).prev.result;
                    b = contaner.operations.get(i).next.result;
                }

                if (contaner.operations.get(i).prevO != null) {
                    if (contaner.operations.get(i).prevO.result != null) {
                        a = contaner.operations.get(i).prevO.result;
                        at = true;
                    }
                }
                if (contaner.operations.get(i).nextO != null) {
                    if (contaner.operations.get(i).nextO.result != null) {
                        b = contaner.operations.get(i).nextO.result;
                        bt = true;
                    }
                }

                contaner.operations.get(i).result = a / b;
                contaner.result = contaner.operations.get(i).result;

                if (at) {
                    relinkOperations(contaner, contaner.operations.get(i).prevO, contaner.operations.get(i));
                }
                if (bt) {
                    relinkOperations(contaner, contaner.operations.get(i).nextO, contaner.operations.get(i));
                }

                // System.out.println(a+" / "+b+" = "+contaner.operations.get(i).result);
            }
        }

        for (int i = 0; i < contaner.operations.size(); i++) {
            if (contaner.operations.get(i).type.equals("+")) {

                double a, b;
                boolean at = false, bt = false;

                try {
                    a = Double.parseDouble(contaner.operations.get(i).prev.content);
                    b = Double.parseDouble(contaner.operations.get(i).next.content);
                } catch (Exception e) {
                    a = contaner.operations.get(i).prev.result;
                    b = contaner.operations.get(i).next.result;
                }

                if (contaner.operations.get(i).prevO != null) {
                    if (contaner.operations.get(i).prevO.result != null) {
                        a = contaner.operations.get(i).prevO.result;
                        at = true;
                    }
                }
                if (contaner.operations.get(i).nextO != null) {
                    if (contaner.operations.get(i).nextO.result != null) {
                        b = contaner.operations.get(i).nextO.result;
                        bt = true;
                    }
                }

                contaner.operations.get(i).result = a + b;
                contaner.result = contaner.operations.get(i).result;

                if (at) {
                    relinkOperations(contaner, contaner.operations.get(i).prevO, contaner.operations.get(i));
                }
                if (bt) {
                    relinkOperations(contaner, contaner.operations.get(i).nextO, contaner.operations.get(i));
                }

                // System.out.println(a+" + "+b+" = "+contaner.operations.get(i).result);
            }

            if (contaner.operations.get(i).type.equals("-")) {

                double a, b;
                boolean at = false, bt = false;

                try {
                    a = Double.parseDouble(contaner.operations.get(i).prev.content);
                    b = Double.parseDouble(contaner.operations.get(i).next.content);
                } catch (Exception e) {
                    a = contaner.operations.get(i).prev.result;
                    b = contaner.operations.get(i).next.result;
                }

                if (contaner.operations.get(i).prevO != null) {
                    if (contaner.operations.get(i).prevO.result != null) {
                        a = contaner.operations.get(i).prevO.result;
                        at = true;
                    }
                }
                if (contaner.operations.get(i).nextO != null) {
                    if (contaner.operations.get(i).nextO.result != null) {
                        b = contaner.operations.get(i).nextO.result;
                        bt = true;
                    }
                }

                contaner.operations.get(i).result = a - b;
                contaner.result = contaner.operations.get(i).result;

                if (at) {
                    relinkOperations(contaner, contaner.operations.get(i).prevO, contaner.operations.get(i));
                }
                if (bt) {
                    relinkOperations(contaner, contaner.operations.get(i).nextO, contaner.operations.get(i));
                }

                // System.out.println(a+" - "+b+" = "+contaner.operations.get(i).result);
            }
        }

        if (t) {
            alg += " = " + contaner.result + "\n";
        }

        if (contaner.result != null) {
//			System.out.println(contaner.content + " = " + contaner.result);
        } else {
            System.out.println("Wrong expression!");
        }
        return contaner.result;
    }

    private static void relinkOperations(Contaner contaner, Operation a, Operation b) {
        //все что указывало на a теперь указывает на b
        for (int i = 0; i < contaner.operations.size(); i++) {
            if (contaner.operations.get(i).prevO == a)
                contaner.operations.get(i).prevO = b;
            if (contaner.operations.get(i).nextO == a)
                contaner.operations.get(i).nextO = b;
        }
    }

}