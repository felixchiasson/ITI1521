/*************************************************************************************************
*     File Name           :     Combination.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-01-26 19:33]
*     Last Modified       :     [2016-01-26 20:42]
*     Description         :     Combination
**************************************************************************************************/

public class Combination {
    private int prem, deux, trois;

    public Combination(int first, int second, int third) {
        prem = first;
        deux = second;
        trois = third;
    }

    public boolean equals(Combination other) {
        return (prem == other.prem && deux == other.deux && trois == other.trois);
    }

    public String toString() {
        return (prem + " :" + deux + " :" + trois);
    }

}
