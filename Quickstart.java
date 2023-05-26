import java.math.BigInteger;
class QuickStart {
    public static void main(String[] args) {

        QuickStart recursion = new QuickStart();
        Boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println("Enter which algorithm you want to run? ");
            String[] functions = new String[] { "fibonacci", "sumOfDigits", "power", "productOfArray", "someRecursive",
                    "isPalindrome", "arrayManipulation", "basicTree" };
            System.out.printf("- %s\nChoose type:", String.join("\n- ", functions));
            String name = System.console().readLine();
            for (String s : functions) {
                if (s.equals(name)) {
                    isValidInput = true;
                }
            }
            switch (name) {
                case "fibonacci":
                    System.out.printf("How many nums from fibonacci sequence:");
                    Integer fibonacciArg = Integer.parseInt(System.console().readLine());
                    System.out.printf("Ans: %d", recursion.fibonacci(fibonacciArg));
                    break;
                case "sumOfDigits":
                    System.out.println("Enter string of nums you want summed:");
                    String sumOfDigitsArg = System.console().readLine();
                    System.out.printf("Ans: %d", recursion.sumOfDigits(new BigInteger(sumOfDigitsArg)));
                    break;
                case "power":
                    System.out.println("Base:");
                    Integer productOfArrayBaseArg = Integer.parseInt(System.console().readLine());
                    System.out.println("Exponent:");
                    Integer productOfArrayExpArg = Integer.parseInt(System.console().readLine());
                    System.out.printf("Ans: %d", recursion.power(productOfArrayBaseArg, productOfArrayExpArg));
                    break;
                case "productOfArray":
                    int productOfArrayN;
                    Scanner productOfArraySc = new Scanner(System.in);
                    System.out.print("Enter Array Size:");
                    productOfArrayN = productOfArraySc.nextInt();
                    int[] productOfArrayArray = new int[productOfArrayN];
                    System.out.println("Enter Array elements: ");
                    for (int i = 0; i < productOfArrayN; i++) {
                        productOfArrayArray[i] = productOfArraySc.nextInt();
                    }
                    System.out.printf("Ans: %d", recursion.productofArray(productOfArrayArray, productOfArrayN));
                    break;
                case "someRecursive":
                    int someRecursiveN;
                    System.out.print("Checks for any odd numbers in array");
                    Scanner someRecursiveSc = new Scanner(System.in);
                    System.out.print("Enter Array Size:");
                    someRecursiveN = someRecursiveSc.nextInt();
                    int[] someRecursiveArray = new int[someRecursiveN];
                    System.out.println("Enter Array elements: ");
                    for (int i = 0; i < someRecursiveN; i++) {
                        someRecursiveArray[i] = someRecursiveSc.nextInt();
                    }
                    System.out.printf("Ans: %s",
                            recursion.someRecursive(someRecursiveArray, new OddFunction() {
                                public boolean run(int num) {
                                    return num % 2 != 0;
                                }
                            }));
                    break;
                case "isPalindrome":
                    System.out.println("Enter string to check for palindrome:");
                    String palindrome = System.console().readLine();
                    System.out.printf("Ans: %s", recursion.isPalindrome(palindrome));
                    break;
                case "arrayManipulation":
                    int arrayManipulationN = 10;
                    List<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
                    arr.add(new ArrayList<Integer>(Arrays.asList(1, 5, 3)));
                    arr.add(new ArrayList<Integer>(Arrays.asList(4, 8, 7)));
                    arr.add(new ArrayList<Integer>(Arrays.asList(6, 9, 1)));
                    long returned = recursion.arrayManipulation(arrayManipulationN, arr);
                    System.out.println("max");
                    System.out.println(returned);
                    break;
                case "basicTree":
                    Tree tree = new Tree();
                    TreeNode root = new TreeNode("root");
                    System.out.println("Enter count of children of root");
                    Integer countChildrenOfRoot = Integer.parseInt(System.console().readLine());
                    for (int i = 0; i < countChildrenOfRoot; i++) {
                        root.addChild(new TreeNode(String.format("Name: %s", i)));
                    }
                    System.out.println("What level?");
                    Integer level = Integer.parseInt(System.console().readLine());
                    System.out.printf("Root tree %s", root.print(level));
                    break;
                default:
                    System.out.printf("Command %s not found", name);
            }
        }

    }

    public interface OddFunction {
        public boolean run(int num);
    }

    // e.g.
    // var rec = recursion.someRecursive(new int[] { 2, 4 }, new OddFunction() {
    // public boolean run(int num) {
    // return num % 2 != 0;
    // }
    // Key concept: chopping down an array
    public boolean someRecursive(int[] arr, OddFunction odd) {
        if (arr.length == 0) {
            return false;
        }
        if (odd.run(arr[0]) == false) {
            return someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
        } else {
            return true;
        }
    }

    // e.g. "omo"
    // Key concept: chopping down an array
    public boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        } else {
            return false;
        }
    }

    public int recursiveRange(int num) {
        if (num == 1) {
            return 1;
        }
        return num + recursiveRange(num - 1);
    }

    public int productofArray(int A[], int N) {
        if (N == 1) {
            return 1;
        }
        return A[N - 1] * productofArray(A, N - 1);
    }

    public int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }

    public BigInteger sumOfDigits(BigInteger n) {
        if (n.equals(new BigInteger("0"))) {
            return new BigInteger("0");
        } else if (n.compareTo(new BigInteger("0")) == -1) {
            return new BigInteger("-1");
        }
        var remainder = n.remainder(new BigInteger("10"));
        return remainder.add((sumOfDigits(n.divide(new BigInteger("10")))));
    }

    // 1 1 | 1+1 =2 | 1 + 2=3 | 2 + 3 = 5
    public int fibonacci(int n) {
        // arr=[1]
        // while (arr.length > 0 and arr.length < n):
        // if arr.length == 1:
        // arr.push(1)
        // else:
        // arr.push(arr[-1] + arr[-2])
        if (n == 0 || n == 1) {
            return n;
        } else {
            // return fibonacci (2 - 1) + fibonacci (2 - 2)
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. 2D_INTEGER_ARRAY queries
     */
    public long arrayManipulation(int n, List<ArrayList<Integer>> queries) {
        long[] matrix = new long[n];
        for (List<Integer> query : queries) {
            matrix[query.get(0) - 1] += query.get(2);
            if (query.get(1) < matrix.length) {
                matrix[query.get(1)] -= query.get(2);
            }
        }
        long max = 0;
        long current = 0;
        for (long value : matrix) {
            current += value;
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

}