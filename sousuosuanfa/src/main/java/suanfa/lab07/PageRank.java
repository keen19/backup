package suanfa.lab07;

public class PageRank {
    public static boolean checkPrecision(double[] checked,double[] ref,double precision){
        //如果两个数组的长度不一样,则没比较返回false 退出
        if (checked.length!=ref.length){
            System.out.println("lenth is not same!");
            return false;
        }
        boolean result=true;
        int len= ref.length;
        for (int i = 0; i < len; i++) {
            if (Math.abs(checked[i] - ref[i])>precision){
                result =false;
                break;
            }
        }
        return result;
    }
    public static double[] doPageRank(double[] init,int[] linkOut,int[][] links,double right){
        if (init.length!=linkOut.length){
            return null;
        }
        int len=init.length;
        double[] pr=new double[len];
        double temp=0;
        int i,j;
        for (i = 0; i < len; i++) {
            j=0;
            temp=0;
            for (j = 0; j < len; j++) {
                if ((i!=j)&&(linkOut[j]!=0)&&(links[j][i]!=0)){
                    temp += init[j]/linkOut[j];
                }
            }
            pr[i]=right +(1-right )*temp;
        }
        return pr;
    }
    public static void main(String[] args) {
        /*
        定义一个最大误差
         */
        double Max=0.0000000001;
        //定义一个权值
        double RIGHT=0.5;
        int[][] links={
                {0,1,0,1,0},
                {0,0,1,0,1},
                {0,0,0,1,0},
                {1,0,0,0,0},
                {0,0,0,1,0}
        };
        int len=links.length;
        //各点的总链出数量
        int[] linkOut=new int[len];
        for (int k = 0; k < len; k++) {
            for (int l = 0; l < len; l++) {
                linkOut[k] +=links[k][l];
            }
        }
        //用来存储PR值得结果
        double[] pr=new double[len];
        //临时变量
        double[] init=new double[len];
        //对数组的初始化
        for (int i = 0; i < len; i++) {
            init[i]=0.0;
        }
        //先做一次PageRank运算
        pr=doPageRank(init,linkOut,links,RIGHT);
        //把得到的值反复运算,只要得到要得到的精度为止
        while (!checkPrecision(pr,init,Max)){
            System.arraycopy(pr,0,init,0,len);
            pr=doPageRank(pr,linkOut,links,RIGHT);
        }
        for (int i = 0; i < len; i++) {
            System.out.println("PR("+(char)(i+65)+")="+pr[i]);
        }

        }

    }

