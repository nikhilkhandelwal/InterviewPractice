package trees;

/**
 * Created by nikhandelwal on 1/23/2016.
 */
public class KthSmallestInBST {

    public static int count = 0;
    public static int finalNum = 0;

    public static int kthSmallest(TreeNode root, int k){

      kthSmallestUtil(root,k);

        return finalNum;

    }
    public static void kthSmallestUtil(TreeNode root, int k) {

        if (root != null){
            kthSmallestUtil(root.left, k);
            count++;
            if (k == count) {
                finalNum = root.data;
            }
            kthSmallestUtil(root.right, k);
        }
    }

    public static void main(String [] args){


        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = null;
        System.out.println(kthSmallest(root, 2));



    }
}
