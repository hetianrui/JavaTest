package TestCode;

public class CirleLinkedList {
    Node first=new Node(1);
     public void add(int num){
         if(num<1){
             return;
         }
         Node cur=first;
         first.next=first;
         for(int i=0;i<num;i++){

             Node boy = new Node(i);
             cur.next = boy;
             boy.next = first;


             cur = boy;
         }
     }
     public void show(){
         Node temp=first.next;
         while (true){
             if(temp.next==first){
                 System.out.println(temp.toString());
                 break;
             }
             System.out.println(temp.toString());
             temp=temp.next;
         }
     }

    public static void main(String[] args) {
        CirleLinkedList list=new CirleLinkedList();
        list.add(4);
        list.show();
    }
}
class Node{
    int id;
    Node next;
    public Node(int id){
        this.id=id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}