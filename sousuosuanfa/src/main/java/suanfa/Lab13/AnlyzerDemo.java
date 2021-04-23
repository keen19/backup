package suanfa.Lab13;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

public class AnlyzerDemo {
    public static void main(String[] args) throws IOException {
        String[] strings=examples;
        for (String text : strings) {
            analyze(text);
        }
    }

    private static void analyze(String text) throws IOException{
        System.out.println("Analyzing \"" + text + "\"");
        for (Analyzer analyzer : analyzers) {
            String name=analyzer.getClass().getSimpleName();
            System.out.println(" " + name + ":");
            System.out.println("  ");
            AnalyzerUtils.displayTokens(analyzer,text);
            System.out.println("\n");
        }
    }

    private static final String[] examples={
            "中华人民共和国",
            "美丽的广州",
            "发轮功是邪教,人人要抵制",
            "坚决维护国家统一,严厉打击藏青会,东突等恐怖主义组织"
    };
    private static final Analyzer[] analyzers=new Analyzer[]{
            new WhitespaceAnalyzer(),
            new SimpleAnalyzer(),
            new StopAnalyzer(Version.LUCENE_30),
            new StandardAnalyzer(Version.LUCENE_30),
            new SmartChineseAnalyzer(Version.LUCENE_30),
            new IKAnalyzer(),
};



}
