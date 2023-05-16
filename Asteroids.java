/* You are given an integer mass, which represents the original mass of a planet. You are further given an integer 
array asteroids, where asteroids[i] is the mass of the ith asteroid. You can arrange for the planet to collide with 
the asteroids in any arbitrary order. If the mass of the planet is greater than or equal to the mass of the 
asteroid, the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is 
destroyed. Return true if all asteroids can be destroyed. Otherwise, return false.
* Eg 1 : mass = 10          asteroids = [3,9,19,5,21]           Output = true
* Eg 2 : mass = 5           asteriods = [4,9,26,4]              Output = false
*/
import java.util.*;
public class Asteroids
{
      public boolean PlanetSurvival(int mass, int asteriods[])
      {
            PriorityQueue<Integer> MinHeap = new PriorityQueue<Integer>();    //*  Min Heap -> O(N)
            for(int i = 0; i < asteriods.length; i++)    //! Storing -> O(N)
                  MinHeap.add(asteriods[i]);    // Storing data in Min Heap
            while(!MinHeap.isEmpty())     //! Comparison -> O(N)
            {
                  if(mass < MinHeap.peek())     // if asteriod mass is more than planet...
                        return false;
                  else
                        mass = mass + MinHeap.poll();    // Otherwise add the asteroid mass to the planet...
            }
            return true;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of Asteroids : ");
            x = sc.nextInt();
            int aster[] = new int[x];
            for(int i = 0; i < aster.length; i++)
            {
                  System.out.print("Enter mass of asteroid : ");
                  aster[i] = sc.nextInt();
            }
            System.out.print("Enter mass of the planet : ");
            x = sc.nextInt();
            Asteroids asteroids = new Asteroids();      // Object creation...
            boolean possibility = asteroids.PlanetSurvival(x, aster);         // Function calling...
            System.out.println("Any chances of Planet Surviving the Asteriods Collision : "+possibility);
            sc.close();
      }
}


//! Time Complexity -> O(N)
//* Space Complexity -> O(N)

/** //? DEDUCTIONS -
 * ? Use Priority Queue as Min Heap to check if planet can gain weight or not...
 */