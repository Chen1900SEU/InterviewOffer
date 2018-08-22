package Interview.招商银行;

import java.util.Scanner;

/**
 * 输入一个升序的序列，然后判断与x的绝对值大小，输出k个差值绝对值小的数
 */
public class 招商Intern_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int x = sc.nextInt();
        int k = sc.nextInt();
        int l = 0;
        int r = l + k - 1;
        while (r < nums.length - 1 && nums[r + 1] < x) {//因为原数组有序，越靠近x的绝对值越小
            l++;
            r++;
        }
        while (r < nums.length - 1 && nums[r + 1] - x < Math.abs(x - nums[l])) {//在x左右的数据
            l++;
            r++;
        }
        for (int i = 1; i <= r; ++i) {
            System.out.print(nums[i]);
            if (i != r) {
                System.out.print(" ");
            }
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int x = sc.nextInt();
//        int k = sc.nextInt();
//        Map<Integer,Integer> map =new HashMap<>();
//        //str.split(" ");
//        String[] arr=str.split(" ");
//        for(int i=0;i<arr.length;i++){
//            int key = Integer.parseInt(arr[i]);
//            int abs = abs(Integer.parseInt(arr[i])-x);
//            map.put(key,map.getOrDefault(key,abs));
//
////            System.out.println(arr[i]);
//        }
//        //针对value排序
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list, (o1, o2) -> o1.getValue()-o2.getValue());
////        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
////            @Override
////            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
////                return o2.getValue()-o1.getValue();
////            }
////        });
//        //遍历
//        Iterator<Map.Entry<Integer, Integer>> entries = list.iterator();
//        for(int i =0;i<k;i++){
//            Map.Entry<Integer, Integer> entry = entries.next();
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }
////        int idex=1;
////        while(entries.hasNext()){
////            if(idex>=k){
////                break;
////            }else {
////
////
////                k++;
////            }
////        }
//        //System.out.println();
//    }
}
