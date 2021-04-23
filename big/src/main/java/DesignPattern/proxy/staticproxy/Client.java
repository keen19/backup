package DesignPattern.proxy.staticproxy;



public class Client {
    public static void main(String[] args) {
//        TeacherDao teacherDao = new TeacherDao();
//
//        TeacherDaoProxy teacherDaoProxy=new TeacherDaoProxy(teacherDao);
//
//        teacherDaoProxy.teach();
        Solution solution = new Solution();
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        solution.maxSubArray(nums);
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            nums[i] += Math.max(nums[i - 1], 0);
            //把最大的数放入res
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
