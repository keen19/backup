package suanfa.Lab13;

import org.apache.lucene.analysis.*;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.Reader;
import java.util.Set;

public class Demo2 extends Analyzer {
    private Set stops;

    public void Demo2(){
        stops= StopAnalyzer.ENGLISH_STOP_WORDS_SET;
    }

    public Demo2(String[] sws) {
        stops= StopFilter.makeStopSet(Version.LUCENE_36,sws,true);
        stops.addAll(StopAnalyzer.ENGLISH_STOP_WORDS_SET);
    }
    @Override
    public TokenStream tokenStream(String fieldName, Reader reader) {
        //定义分词器处理链
        return new StopFilter(Version.LUCENE_36,new LowerCaseFilter(
                Version.LUCENE_36,new LetterTokenizer(
                        Version.LUCENE_36,reader)),stops);
    }

    public static void main(String[] args) throws IOException {
        Demo2 demo2 = new Demo2(new String[]{"my", "name"});
        String str = "My name is XXX";
        AnalyzerUtils.displayTokens(demo2,str);
    }
}
