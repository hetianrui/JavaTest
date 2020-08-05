class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node temp=head;
        while(true){
            if(temp==null){
                break;
            }
            Node res=new Node(temp.val);
            res.next=temp.next;
            temp.next=res;
            temp=temp.next.next;
        }
        Node cur=head;
        while(true){
            if(cur.random==null){
                cur.next.random=null;
                
            }else{
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
            if(cur==null){
                break;
            }
        }
        Node res=head.next;
        Node ree=head.next;
        Node tmp=head;
        while(res!=null){
            tmp.next=tmp.next.next;
            if(res.next!=null){
                res.next=res.next.next;
            }else{
                res.next=null;
            }
            res=res.next;
            tmp=tmp.next;
        }
        return ree;
    }
}