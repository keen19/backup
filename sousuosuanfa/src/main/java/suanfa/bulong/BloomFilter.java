package suanfa.bulong;

import java.util.BitSet;

public class BloomFilter {
    private static final int SIZE=1<<24;
    BitSet bitSet=new BitSet(SIZE);
    Hash[] hashes=new Hash[8];
    private static final int seeds[]=new int[]{3,5,7,9,11,13,17,19};
    private static final String[] urls=new String[]{"https://www.sise.edu.cn/","https://blog.csdn.net/","https://www.csdn.net/"};

    public static void main(String[] args) {
        BloomFilter bloomFilter=new BloomFilter();
        for (int i = 0; i < 2; i++) {
            bloomFilter.add(urls[i]);
        }
        String url="https://www.sise.edu.cn/";
        System.out.println(url+"是否在列表中:"+bloomFilter.contains(url));
    }
    public BloomFilter(){
        for (int i = 0; i < seeds.length; i++) {
            hashes[i] =new Hash(seeds[i]);
        }
    }
    public void add(String string){
        for (Hash hash:hashes){
            bitSet.set(hash.getHash(string),true);
        }
    }
    public boolean contains(String string){
        boolean have=true;
        for (Hash hash : hashes) {
            have&=bitSet.get(hash.getHash(string));
        }
        return have;
    }
    class Hash{
        private int seed=0;
        public Hash(int seed){
            this.seed=seed;
        }
        public int getHash(String string){
            int val=0;
            int len=string.length();
            for (int i = 0; i < len; i++) {
                val=val*seed+string.charAt(i);
            }
            return val&(SIZE-1);
        }
    }
}
