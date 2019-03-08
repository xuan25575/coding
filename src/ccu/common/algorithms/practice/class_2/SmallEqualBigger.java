package ccu.common.algorithms.practice.class_2;


/**     【题目】
        给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整
        数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于
        pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于
        pivot的节点。除这个要求外，对调整后的节点顺序没有更多的要求。
        例如：链表9->0->4->5->1，pivot=3。
        调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总之，满
        足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部
        分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做
        要求。
        进阶：
        在原问题的要求之上再增加如下两个要求。
        在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左
        到右的顺序与原链表中节点的先后次序一致。
        例如：链表9->0->4->5->1，pivot=3。调整后的链表是0->1->9->4->5。
        在满足原问题要求的同时，左部分节点从左到右为0、1。在原链表中也
        是先出现0，后出现1；中间部分在本例中为空，不再讨论；右部分节点
        从左到右为9、4、5。在原链表中也是先出现9，然后出现4，最后出现5。
        如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
    */
/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 */

public class SmallEqualBigger {

    public static class Node{
        public  int value;
        public Node next;
        public Node(int data){
            this.value =  data;
        }
    }

    /**
     *  解一
     * @param head  头结点
     * @param pivot key值
     * @return 返回切分好的头结点
     */
    public static Node listPartition1(Node head, int pivot ){
        if(head == null){
            return null;
        }
        Node currentNode =  head;
        int i = 0; // 用来记录链表节点数量
        while(currentNode != null){
           i++;
           currentNode = currentNode.next;
        }
        Node[] nodeArr = new Node[i];
        currentNode  = head; // 变量重用
        for ( i = 0; i <nodeArr.length ; i++) {  // 将链表节点放入数组中 使用荷兰国旗问题解
            nodeArr[i] = currentNode;
            currentNode = currentNode.next;
        }
        arrPartition(nodeArr,pivot);
        // 切分后 将链表重新连接起来
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null; //把下一个置为空
        return nodeArr[0]; // 返回头结点
    }

    /**
     *  荷兰国旗问题的切分
     * @param arrNode  节点数组
     * @param pivot 中心点  关键值
     */
    public  static void arrPartition(Node[] arrNode,int pivot){
        int small = -1; // 边界
        int big = arrNode.length; //  边界
        int index = 0;  // 从哪个位置开始
        while(index != big){
            if(arrNode[index].value < pivot){
                swap(arrNode,++small,index++);
            }else if(arrNode[index].value == pivot){
                index++;
            }else{
                swap(arrNode,--big,index);
            }
        }
    }

    public static void swap(Node[] arrNode,int a,int b){
        Node temp = arrNode[a];
        arrNode[a] = arrNode[b];
        arrNode[b] = temp;
    }

    /**
     *
     *  题目进阶  让三部分保持一定得顺序。
     *  思路： 通过6个变量 ，将链表分成三部分
     *  然后连接起来，但是需要条件判断
     * @param head 头结点
     * @param pivot  key值
     * @return
     */
    public static Node listPartition2(Node head,int pivot){
        if(head == null){
            return null;
        }
        Node smallHead = null;
        Node smallTail = null; // 小于pivot的部分尾部节点
        Node equalHead = null;
        Node equalTail = null; // 等于pivot的部分尾部节点
        Node bigHead = null;
        Node bigTail = null; // 大于pivot尾部部分的节点
        Node next = null;  // 用于保存下一个节点

        while(head != null){
            next = head.next;
            head.next = null; // 处理头结点下一个节点
            if(head.value  < pivot){
                if(smallHead == null){
                    smallHead = head;
                    smallTail = head;
                }else{
                  smallTail.next = head; // 保存到尾部节点的下一个
                  smallTail = head; // 修改尾部节点的指向
                }
            }else if(head.value == pivot){
                if(equalHead == null){
                    equalHead = head;
                    equalTail = head;
                }else{
                    equalTail.next = head;
                    equalTail = head;
                }
            }else{
                if(bigHead == null){
                    bigHead = head;
                    bigTail = head;
                }else{
                    bigTail.next = head;
                    bigTail = head;
                }
            }
            head = next;
        }
        //small and equal reconnect
        if(smallTail != null){
            smallTail.next = equalHead;
            equalTail = equalTail == null ? smallTail :equalTail; // 用于连接big 部分
        }
        //big connect
        if(bigTail != null){ // 尾部不为空 存在这一部分
            equalTail.next = bigHead;
        }
        return  smallHead != null ? smallHead : equalHead != null ? equalHead :bigHead;  // 返回头节点 需要判断三部分是否有为空的
    }



    public static void printLinkedList(Node node){
        if(node == null){
            return;
        }
        System.out.print("Linked List:");
        while(node != null){
            System.out.print(node.value+" ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head1 = new Node(11);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);

        printLinkedList(head1);
        //Node node  = listPartition1(head1, 5);
        Node node = listPartition2(head1,5);
       printLinkedList(node);
    }



















}
