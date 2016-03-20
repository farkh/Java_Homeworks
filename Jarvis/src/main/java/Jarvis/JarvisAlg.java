package Jarvis;
import java.lang.Math;

/**
 * Created by farkh on 20/03/16.
 */
public class JarvisAlg {


    public int vect(Point inShell, Point next, Point other) {
        return (next.getX() - inShell.getX())*(other.getY() - inShell.getY())-(other.getX() - inShell.getX())*(next.getY() - inShell.getY());
    }

    public int distance(Point a, Point b) {
        return (int) Math.pow((b.getX() - a.getX()), 2) + (int) Math.pow((b.getY() - a.getY()), 2);
    }

    public Point[] findShell(Point[] array) {
        Point[] shell = new Point[array.length];
        int minIndex = 0;

        //searching for a starting point
        for (int i = 1; i < array.length; i++) {
            if ((array[i].getY() < array[minIndex].getY()) || (array[i].getY() < array[minIndex].getY() && (array[i].getX() > array[minIndex].getX()))) {
                minIndex = i;
            }
        }

        shell[0] = array[minIndex];
        int index = 0;
        int nextPoint = 1;

        do {
            for (int i = 1; i < array.length; i++) {
                if (vect(shell[index], array[nextPoint], array[i]) < 0 ||
                        (vect(shell[index], array[nextPoint], array[i]) == 0) &&
                                (distance(shell[index], array[nextPoint]) < distance(shell[index], array[i]))) {
                    nextPoint = i;
                }
            }

            index++;
            shell[index] = array[nextPoint];
            nextPoint = 0;

        } while ((shell[index].getX() != shell[0].getX()) && (shell[index].getY() != shell[0].getY()));

        return shell;
    }

}
