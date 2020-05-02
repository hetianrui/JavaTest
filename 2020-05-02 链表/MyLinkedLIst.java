package TestCode;

public class MyLinkedLIst {
    static Node head=new Node(0,"");
    public void add(Node val){
        Node temp=head;
        while (true){
            if(temp.next==null){
                temp.next=val;
                break;
            }
            temp=temp.next;
        }
    }
    public void addByOrder(Node val){
        Node temp=head;
        while (true){
            if(temp.next==null){
                temp.next=val;
                break;
            }
            if(temp.next.id>val.id){
                val.next=temp.next;
                temp.next=val;
                break;
            }
            if(temp.next.id==val.id){
                System.out.println(val.id+"该位置有人了，无法插入o");
                break;
            }
            temp=temp.next;
        }
    }
    public void change(Node val){
        Node temp=head.next;
        boolean flag=false;
        while (true){
            if(temp.id==val.id){
                flag=true;
                break;
            }
            if(temp==null){
                break;
            }

            temp=temp.next;
        }
        if(flag==true){
            temp.name=val.name;
        }else {
            System.out.println(val.id+"该位置不存在");
        }
    }
    public void delete(Node val){
        Node temp=head;
        boolean flag=false;
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.next.id==val.id){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            temp.next=temp.next.next;
        }else {
            System.out.println(val.id+"没有该节点，无法删除");
        }
    }
    public static int getLength(){
        if(head.next==null){
            return 0;
        }
        Node temp=head.next;
        int length=1;
        while (true){
            if(temp.next==null){
                break;
            }
            length++;
            temp=temp.next;
        }
        return length;
    }
    public  Node findKnode(Node head,int k){//找到倒数第k个节点
        if(head.next==null){
            return null;
        }

        Node temp=head.next;
        int length=getLength();

        if(k<=0||k>length){
            System.out.println("下标不合法");
            return null;
        }
        for(int i=0;i<length-k;i++){
            temp=temp.next;
        }
        return temp;
    }
    public void reverse(Node head){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node cur=head.next;
        Node newNext=null;
        Node newHead=new Node(0,"");
        while (cur!=null){
            newNext=cur.next;
            cur.next=newHead.next;
            newHead.next=cur;
            cur=newNext;
        }
        head.next=newHead.next;
    }
    public void show(){
        Node temp=head;
        while (true){
            if(head.next==null){
                System.out.println("链表为空");
            }
            if (temp.next==null){
                break;
            }
            temp=temp.next;
            System.out.println(temp.toString());
        }
    }
    public static void main(String[] args) {
        Node a=new Node(1,"小花");
        Node b=new Node(2,"小黑");
        Node c=new Node(3,"小名");
        Node d=new Node(3,"小哈");
        MyLinkedLIst linkedLIst=new MyLinkedLIst();
        linkedLIst.addByOrder(a);
        linkedLIst.addByOrder(c);
        linkedLIst.addByOrder(b);
        //linkedLIst.addByOrder(b);
        //linkedLIst.change(d);
        linkedLIst.show();
       System.out.println("**************");
       linkedLIst.reverse(head);
       linkedLIst.show();
        //linkedLIst.delete(c);
        //linkedLIst.delete(a);
        //linkedLIst.delete(b);
        //linkedLIst.delete(d);
       // System.out.println(linkedLIst.getLength());
        //Node res=linkedLIst.findKnode(head,2);


    }
}
class Node{
    int id;
    String name;
    Node next=null;
    public Node(int id,String name){
        this.id=id;
        this.name=name;

    }


    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}