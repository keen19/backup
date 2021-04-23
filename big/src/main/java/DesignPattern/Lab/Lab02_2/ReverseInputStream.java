package DesignPattern.Lab.Lab02_2;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Stack;

public class ReverseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected ReverseInputStream(InputStream in) {
        super(in);
    }


    @Override
    public int read() throws IOException {
        int len = super.read();
        String str = String.valueOf(len);
        Stack<String> s2 = new Stack<>();
        s2.push(str);
        String getstr=s2.pop();
        int ss=Integer.parseInt(str);

        return ss;
    }

//    @Override
//    public int read(byte[] b,int offset,int len) throws IOException {
//        int result=super.read(b,offset,len);
//    }
}

