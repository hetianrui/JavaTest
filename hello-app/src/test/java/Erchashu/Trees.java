package Erchashu;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int val;
    Node left;
    Node right;
    Node(int x){
        val=x;
    }
}
public class Trees {
   public Trees lowestCom(Trees root,Trees p,Trees q){
     return null;
   }
   public boolean search(Node root,Node rv){
       if(root==rv){
           return true;
       }
       if(search(root.left,rv)){
           return true;
       }else
           return search(root.right,rv);
   }
    public static void level(Node root){
         if(root==null){
           return ;
         }
        Queue q=new LinkedList();
              q.add(root);
              while(!q.isEmpty()){
                  Queue<> oop= q.poll();

              }
        List<List<Integer>> retList=new ArrayList<>();
              Element e=new Element();

    }
    static class Element{
    }

    public List<Trees> getInOrderList(boolean flag) {
        
                List<Trees> nodelist = new ArrayList<Trees>();
                if (flag == true) {
                        nodelist = inOrderTraverse(getRoot(), nodelist);
                    }
                else {
                      nodelist = inOrderTraverseIter(getRoot());
                  }
              return nodelist;
          }
          boolean isComplete(Trees root){
              if(root==null){
                  return true;
              }
              Queue q=new LinkedList();
              q.add(root);
              while(!q.isEmpty()){
                  Object Node=q.poll();
                  if(Node!=null){
                      return false;
                  }

                  }
          return true;
   }


}*/

