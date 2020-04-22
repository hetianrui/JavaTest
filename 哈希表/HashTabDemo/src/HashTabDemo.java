import java.util.Arrays;
import java.util.EnumMap;
import java.util.Scanner;

public class HashTabDemo {

    public static void main(String[] args) {
    HashTable hashTable=new HashTable(7);
     String key="";
        Scanner scanner=new Scanner(System.in);

      while (true){
          System.out.println("add 添加员工");
          System.out.println("show 显示哈希表");
          switch (key=scanner.nextLine()){
              case "add":
                  System.out.println("请输入员工id");
                  int id=scanner.nextInt();
                  System.out.println("请输入员工name");
                  scanner.nextLine();
                  String name=scanner.nextLine();
                  hashTable.add(id,name);
                  break;
              case "show":
                  hashTable.show();
                  break;
                  default:
                      System.out.println("输入有误，重新输入");
          }
      }
    }
}
class HashTable{
    private int size;
    private EmpLinkedList[] hashTable;
    public HashTable(int size){
       this.size=size;
       hashTable=new EmpLinkedList[size];

       for (int i=0;i<hashTable.length;i++){
           hashTable[i]=new EmpLinkedList();
       }
    }
    public void add(int id,String name){
        int count=Sanlie(id);
        Employee employee=new Employee(id,name);
        hashTable[count].add(employee);
    }
    public void show(){
        for(int i=0;i<size;i++){
            hashTable[i].show(i+1);
        }
    }
    public int Sanlie(int id){
        return id%size;
    }

}
class Employee{
     int id;
     String name;
     Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class EmpLinkedList{
    private Employee head;

    public void add(Employee node){
        if(head==null){
            head=node;
            return;
        }
       Employee temp=head;
        while (true){
            if(temp.next==null){
                temp.next=node;
                break;
            }
            temp=temp.next;
        }
    }
    public void show(int i){
        if(head==null){
            System.out.println("第"+i+"条链表为空");
            return;
        }
        System.out.print("第"+i+"条链表信息为: ");
        Employee temp=head;
        while (true){
            System.out.print("id="+temp.id+" "+"name="+temp.name+" ");
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        System.out.println();
    }
}