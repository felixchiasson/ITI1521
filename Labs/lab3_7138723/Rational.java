/*************************************************************************************************
*     File Name           :     Rational.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-02-02 20:57]
*     Last Modified       :     [2016-02-04 22:22]
*     Description         :     no time to finish this
**************************************************************************************************/
public class Rational {

    private int x, y;
    private int[] values = new int[2];
    public Rational(int numerateur, int denominateur) {
        x = numerateur;
        y = denominateur;
    }

    public Rational(int bas) {
        x = 1;
        y = bas;
    }

    public void setValues(int nume, int denom) {
        values = new int[]{nume, denom};
    }

    public int[] getValues() {
        return values;
    }

    public Rational plus(Rational other) {
        Rational sum = this;
        sum = sum + other;
        return sum;
    }
}




