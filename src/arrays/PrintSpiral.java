package arrays;

/**
 * Created by nikhandelwal on 12/14/2015.
 */
public class PrintSpiral {


    // left = 0,rigth =2, top =0 ,bottom =5
//    public static void printSpirally(int left,int right,int top,int bottom)
//    {
//        if(left>right)
//            return;
//        if(top>bottom)
//            return;
//
//        for(int i=left;i<=right;i++)
//        {
//            System.out.println("%c ",a[top][i]);
//        }
//
//        for(int i=top+1;i<=bottom;i++)
//        {
//            System.out.println("%c ", a[i][right]);
//        }
//        if(top!=bottom)	// This is done to avoid the case when there is only one col left in the middle.
//            for(int i=right-1;i>=left;i--)
//            {
//                System.out.println("%c ", a[bottom][i]);
//            }
//        if(left!=right) // This is done to avoid the case when there is only one row left in the middle.
//            for(int i=bottom-1;i>top;i--)
//            {
//                System.out.println("%c ", a[i][left]);
//            }
//        printSpirally(left+1,right-1,top+1,bottom-1);
//    }
//
//    public static void  main(String [] args)
//    {
//        printSpirally(0,5,0,5);
//
//    }
}
