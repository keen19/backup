package suanfa.lab10;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

public class BasicSearch {
    public static void main(String[] args) throws Exception{
        String indexDir="F:/2/lab05";
        //打开指定目录下的索引
        Directory dir= FSDirectory.open(new File(indexDir));
        IndexReader reader=IndexReader.open(dir);
        //显示索引中的所有文件
        System.out.println("索引里面document列表:");
        for (int i = 0; i < reader.numDocs(); i++) {
            System.out.println(reader.document(i));
        }
        System.out.println("索引里面document数量是:" + reader.numDocs());
        reader.close();
        IndexSearcher searcher=new IndexSearcher(dir);
        Term t=new Term("bookname","book3");
        Query query=new TermQuery(t);
        TopDocs hits=searcher.search(query,10);
        System.out.println("查询到的文档数是:" + hits.totalHits);
        for (int i = 0; i <hits.totalHits ; i++) {
            //获取查询到的文档
            Document doc=searcher.doc(hits.scoreDocs[i].doc);
            System.out.println("查询到的文档时:"+doc);
            System.out.println("文档编号和评价分数是:"+hits.scoreDocs[i].toString());
            System.out.println("文档最高价评价分数是:"+hits.getMaxScore());
            
        }
        
    }

}

