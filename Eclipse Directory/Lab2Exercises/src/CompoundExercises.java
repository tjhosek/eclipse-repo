////////////////////////////////////////////////////////////////////////////////////
//  C212
//   
//  Released:  1/20/20
//
//  Lab 2
//  @Author  Your Name and username
//  Last Edited:  
//
//
//  Directions: See Below 
//               
//////////////////////////////////////////////////////////////////////////////////

// 1. Change the following program to use compound assignments, pre- or post- increment/decrement statements ONLY as appropriate.
class CompoundExercises {

     public static void compoundOperators(){
          
          int result = -1; // result is -1
          System.out.println(result);

          result -= 1; // result is now -2
          System.out.println(result);

          result *= -2; // result is now 4
          System.out.println(result);

          result /= 2; // result is now 2
          System.out.println(result);

          result += 3; // result is now 5
          System.out.println(result);

          result %= 3; // result is now 2
          System.out.println(result);
     }
     
// 2. In the following program, explain why the value "-4" is printed thrice in a row:
     public static void question1() {
        int i = -5;
        i++;
        System.out.println(i);    // "-4"
        ++i;                     
        System.out.println(i);    // "-3"
        System.out.println(--i);  // "-4"
        System.out.println(i--);  // "-4"
        System.out.println(++i);  // "-4"
        
        //On the first line, i is initialized to -5
        //On the second line, i is incremented by 1, which is why the third line prints "-4"
        //On the fourth line, i is incremented by 1 again, which is why the fifth line prints "-3"
        //On the sixth line, i is decremented by 1, and because the -- is before the i it is decremented before it's printed on the same line, hence why it prints "-4"
        //On the seventh line, i is decremented by 1, however, because the -- is after the i, it is decremented after it's printed on the same line, resulting in it printing a "-4" instead
        //On the eight line, i is incremented by 1, and because the ++ is before the i it is incremented before it is printed on the same line, so it prints "-4"
     }
}