package ccu.structure;

public class MyLinkedList {
    Node head ;
//    记录节点的位置
    int pos = 0;

    public MyLinkedList(){
        head = null;
    }

    class Node{
        int value;
        Node next;
        Node(){}
        Node(int value){
            this.value = value;
        }
        public void display(){
            System.out.print("   "+value);
        }
    }

    /**
     * 从尾部添加节点
     * @param node
     */
//    public void addAfterNode(Node node){
//        if(head == null){
//            head = node;
//            return;
//        }
//        while(head.next != null){
//             head = head.next;
//        }
//        head.next = node;
//    }

    /**
     * 从头部插入节点。
     * @param data
     */
    public void add(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    /**
     * 删除头结点
     * @return
     */
    public Node deleteFirstNode(){
        Node tempNode = head;
        head = tempNode.next;
        return  tempNode;
    }


    /**
     * 在任意位置插入节点
     * @param index
     * @param data
     */
    public void insertNode(int index,int data){
        if(index <1 || index > length()+1){
            throw new RuntimeException("插入不合法节点");
        }
        Node node = new Node(data);
        Node current  = head;
        Node previous = head;
        while(pos != index){
            previous =current;
            current = current.next;
            pos++;
        }
        node.next = current;
        previous.next = node;
        pos =0;
    }

    /**
     * 通过位置删除节点。
     * @param index
     * @return
     */
    public Node deleteByIndex(int index){
        Node current  = head;
        Node previous = head;
        while(index != pos){
            previous =current;
            current = current.next;
            pos++;
        }
        if(current == head){
            head = head.next;
        }else{
            pos = 0;
            previous.next = current.next;
        }
        return current;
    }

    /**
     * 根据节点数据删除。
     * @param data
     * @return
     */
    public Node  deleteByData(int data){
        Node current  = head;
        Node previous = head;
        while(current.value != data){
            if (current.next == null) {
                return null;
            }
            previous =current;
            current = current.next;
        }
        if(current == head){
            head = head.next;
        }else{
            previous.next = current.next;
        }
        return current;
    }


    public int length(){
        Node tempNode = head;
        if(tempNode == null){
            return 0;
        }
        int i =0;
        while(tempNode != null){
            i++;
            tempNode = tempNode.next;
        }
        return i;
    }


    // 显示出所有的节点信息
    public void displayAllNodes() {
        Node current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MyLinkedList linkList = new MyLinkedList();
        linkList.add(20);
        linkList.add(21);
        linkList.add(19);
        //print19,21,20
        linkList.insertNode(1, 22); //print19,22,21,20
        linkList.insertNode(2, 23); //print19,22,23,21,20
        linkList.insertNode(3, 99); //print19,22,23,99,21,20
        //调用此方法会print 19,22,23,99,21,20
        linkList.displayAllNodes();
        linkList.deleteByData(19);
        linkList.displayAllNodes();
    }
}
