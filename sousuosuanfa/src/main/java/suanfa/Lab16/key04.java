package suanfa.Lab16;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.search.spans.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


import java.io.File;
import java.io.IOException;

public class key04 {
    public static void main(String[] args) throws IOException {
        String Index_Store_Path="F:/2/lab05";
        File file=new File(Index_Store_Path);

        Directory Index = FSDirectory.open(file);
        IndexReader reader = IndexReader.open(Index);
        System.out.println("索引里面document列表:");
        for (int i = 0; i < reader.numDocs(); i++) {
            System.out.println(reader.document(i));
        }
        System.out.println("索引里面document数量是:" + reader.numDocs());
        @SuppressWarnings("deprecation")
        IndexSearcher searcher = new IndexSearcher(reader);
        SpanTermQuery q1 = new SpanTermQuery(new Term("bookName", "铁"));
        SpanTermQuery q2 = new SpanTermQuery(new Term("bookName", "战"));
        SpanTermQuery q3 = new SpanTermQuery(new Term("bookName", "大"));

        SpanNearQuery q4=new SpanNearQuery(new SpanTermQuery[]{q1,q2,q3},1,true);
        //SpanNotQuery q=new SpanNotQuery(q4,new SpanTermQuery(new Term("bookname","钢")));
        SpanOrQuery q=new SpanOrQuery(new SpanQuery[]{q1,q2,q3,q4});

        System.out.println("本次查询" + q);

        TopDocs results=searcher.search(q,1000);
//        TopDocs results=searcher.search(q,null,1000,new Sort(
//                new SortField("publishDate",SortField.STRING),
//                SortField.FIELD_SCORE,
//                new SortField("bookNumber",SortField.STRING,true)
//        ));
        for (ScoreDoc sd : results.scoreDocs) {
            System.out.println("---------------");
            int docID=sd.doc;
            float score=sd.score;
            Document document= searcher.doc(docID);
            System.out.println("书名:"+document.get("bookName")+"\t");
            System.out.println("得分:"+score+"\t");
            System.out.println("内部ID:"+docID+"\t");
            System.out.println("书号:"+document.get("bookNumber")+"\t");
            System.out.println("发行日期:"+document.get("publishDate")+"\t");
        }
    }
}
