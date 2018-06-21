package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

//class ListNodeOperation {
//
//    //创建链表
//    public ListNode createListNode(){
//        System.out.println("请输入节点值以-1结束");
//        Scanner scan = new Scanner(System.in);
//        ListNode pHead= new ListNode();
//        int temp;
//        if((temp=scan.nextInt())==-1){//头结点
//            return null;
//        }else{
//            pHead.val=temp;
//        }
//
//        ListNode p =pHead;
//        while((temp=scan.nextInt())!=-1){
//            ListNode q = new ListNode(temp);
//            p.next=q;
//            p=p.next;
//        }
//        p.next=null;
//        return pHead;
//    }
//
//    //打印链表
//    public void display(ListNode pHead){
//        while(pHead!=null){
//            System.out.print(pHead.val+"\t");
//            pHead=pHead.next;
//        }
//        System.out.println();
//    }
//    //在某位置增加一个节点，pos=0表示在头结点前插入
//    public ListNode addNode(ListNode pHead,int pos,int value){
//        ListNode q = new ListNode(value);
//        if(pos<0){
//            System.out.println("插入失败");
//            return pHead;
//        }
//        if(pos==0){//在头结点前插入
//            q.next=pHead;
//            return q;
//        }
//        ListNode p = pHead;
//        while((--pos)>0&&p!=null){
//            p=p.next;
//        }
//        if(p==null){
//            System.out.println("插入失败！");
//            return pHead;
//        }
//        q.next=p.next;
//        p.next=q;
//        return pHead;
//
//    }
//
//
//}

public class 从尾到头打印链表 {

    /**
     * @param listNode
     * @return
     */
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode != null) {
            //if(listNode !=null){
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
            // }
            //System.out.println(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
//        ListNodeOperation cls = new ListNodeOperation();
//        ListNode pHead =  new ListNode();
//        pHead=cls.createListNode();
//        System.out.println(printListFromTailToHead(pHead));

        ListNode phead = new ListNode(0);
        //phead.val=0;
        ListNode p = phead;
        for (int i = 1; i < 10; i++) {
            ListNode q = new ListNode(i);
            p.next = q;
            p = p.next;
            //l=l.next;
        }
        System.out.println(printListFromTailToHead(p));
    }
}
