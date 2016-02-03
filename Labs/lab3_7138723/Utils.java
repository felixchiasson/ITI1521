/*************************************************************************************************
*     File Name           :     Utils.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-02-02 19:20]
*     Last Modified       :     [2016-02-02 19:49]
*     Description         :
**************************************************************************************************/

public class Utils {
    public static String[] findAndReplace(String[] in, String[] what, String[] with) {
        String[] out = new String[in.length];

        int i, j;
        if(in == null || what == null || with == null) {
            return null;
        } else if(what.length != with.length) {
            return null;
        } else {
            for(i = 0; i < in.length; i++) {
                for(j = 0; j < what.length; j++) {
                    if(in[i].equals(null) || what[j].equals(null) || with[j].equals(null)) {
                        return null;
                    } else if(in[i].equals(what[j])) {
                        out[i] = with[i];
                    } else {
                        out[i] = in[i];
                    }
                }
             }
        return out;
        }
    }
}

