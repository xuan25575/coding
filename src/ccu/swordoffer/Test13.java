package ccu.swordoffer;
  /**
    * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点,
    *
    *   正常删除链表节点都得给个头指针和要删除的结点，然后从头开始遍历寻找
    *   常用的方法是使用2个指针q和pre,q在前面遍历链表查找node,而pre指向q刚遍历过的前一个节点。
    *   当q==node的时候，表示已经找到要删除的节点node了。
    *   那么只要：pre->next = q->next; delete q;即可。
    *   但是要求时间复杂度是1.
    *   思路：直接复制这个结点的下一个结点，然后再将这个结点的下一个结点删除
    *   【注意】
    *   要删除的结点是尾结点
    *   NULL为系统中的特定的那块区域！！并无法复制，所以只能从头遍历，得到该结点的前序结点，删除。
    *   如果链表只有一个结点，即这个要删除的结点也是头节点，将删除节点置为空之后，还需把头节点置为空；
    *
    *
    */
public class Test13 {
      public static class Node{
         public int value;
         public  Node next;
         public Node(int data){
            this.value = data;
        }
      }
      public static Node  removeNodeInList(Node head,Node deleteNode){
          if(head == null || deleteNode == null){
              return null;
          }
          if (deleteNode.next != null){  // 使用覆盖的方法。
              Node next =  deleteNode.next;
              deleteNode.value = next.value;
              deleteNode.next = next.next;
              next = null;
          }else if(head == deleteNode){
              deleteNode = null;
              head = null;
          }else{
              Node cur = head;
              while(cur.next != deleteNode){
                  cur = cur.next;
              }
              deleteNode = null;//释放空间
              cur.next = null;
          }
        return head;
      }

      public static void printList(Node head){
          if(head == null){
              return;
          }
          while(head != null){
              System.out.print(head.value+" ");
              head = head.next;
          }
          System.out.println();
      }


      public static void main(String[] args) {

          Node head = new Node(1);
          head.next = new Node(2);
          Node middle = head.next.next = new Node(3);
          head.next.next.next = new Node(4);
          head.next.next.next.next = new Node(5);
          Node last = head.next.next.next.next.next = new Node(6);

//          head = removeNodeInList(head, head); // 删除头结点
//          printList(head);
//          head = removeNodeInList(head, last); // 删除尾结点
//          printList(head);
//          head = removeNodeInList(head, middle); // 删除中间结点
//          printList(head);
          Node head2 = new Node(1);
          head2 = removeNodeInList(head2, head2); // 删除头结点
          printList(head2);
      }
}