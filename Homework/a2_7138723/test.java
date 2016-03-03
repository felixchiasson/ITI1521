import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.*;
public class test {
    private static void generatePath() {
        LinkedList<String> queue;
        queue = new LinkedList<String>();
        queue.addLast("");

        while (true) {
            String path;
            path = queue.removeFirst();

            queue.addLast(path + "X"); // This is Up Right
            queue.addLast(path + "Y"); // This is Up Left
            queue.addLast(path + "R");
            queue.addLast(path + "L");
            queue.addLast(path + "V"); // This is Down Right
            queue.addLast(path + "W"); // This is Down Left

        }
    }
    public static void main(String[] args) {
        generatePath();
    }

}


