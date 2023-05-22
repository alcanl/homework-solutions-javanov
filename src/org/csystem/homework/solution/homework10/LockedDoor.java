package org.csystem.homework.solution.homework10;

public class LockedDoor {
    public boolean [] doors;
    public int [] keys;

    public LockedDoor()
    {
        doors = new boolean[101];
        keys = new int [20];
        for (int i = 0; i < keys.length; ++i)
            keys[i] = i + 1;
    }
    public void run()
    {
        openOrLockDoors();
        printDoors();
    }
    public void openOrLockDoors()
    {
        for (int i = 0; i < keys.length; ++i)
            for (int k = 1; k < doors.length; ++k)
                if (k % keys[i] == 0)
                    doors[k] = !doors[k];
    }

    public void printDoors()
    {
        for (int i = 1; i < doors.length; ++i)
            if (doors[i])
                System.out.printf("%d ", i);
    }
}