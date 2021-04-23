package suanfa.lab09;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

public class GreatIndex {
    public static void main(String[] args) {
        GreatIndex greatIndex = new GreatIndex();
        try {
            greatIndex.setUp();
            greatIndex.setUp2();
            //greatIndex.DisplayDocument(greatIndex.indexDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String indexDir = "F:/2/AAA";

    private Directory directory;
    private IndexWriterConfig iwc;
    IndexWriter writer;

    private void setUp() throws Exception {
        directory = FSDirectory.open(new File(indexDir));
        Analyzer analyzer=new StandardAnalyzer(Version.LUCENE_36);
        iwc=new IndexWriterConfig(Version.LUCENE_36,analyzer);
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

        iwc.setMergePolicy(optimizeIndex());

        writer=new IndexWriter(directory, iwc);

        //建立三本书的document
        Document doc1 = new Document();
        Document doc2 = new Document();
        Document doc3 = new Document();

        doc1.add(new Field("bookname", "伐清",
                Field.Store.YES,
                Field.Index.NOT_ANALYZED_NO_NORMS));
        doc1.add(new Field("bookname", "奥术神座",
                Field.Store.YES,
                Field.Index.NOT_ANALYZED_NO_NORMS));
        doc1.add(new Field("bookname", "冰与火之歌",
                Field.Store.YES,
                Field.Index.NOT_ANALYZED_NO_NORMS));
        writer.addDocument(doc1);
        writer.addDocument(doc2);
        writer.addDocument(doc3);

        writer.commit();
        writer.close();
    }

    private String[] booknames = {"伐清", "奥术神座", "冰与火之歌"};

    public void setUp2() throws Exception {
        directory = FSDirectory.open(new File(indexDir));
        iwc=new IndexWriterConfig(Version.LUCENE_36,new StandardAnalyzer(
                Version.LUCENE_36));
        iwc.setMaxBufferedDocs(1000);
        writer = new IndexWriter(directory, iwc);
        Document doc = new Document();
        for (String bookname : booknames) {
            doc.add(new Field("bookname", bookname, Field.Store.YES,
                    Field.Index.NOT_ANALYZED));
        }
        writer.addDocument(doc);
        writer.close();
    }
    private static LogMergePolicy optimizeIndex(){
        LogMergePolicy mergePolicy=new LogByteSizeMergePolicy();
        /*
        设置segment添加文档时的合并频率
        值较小,建立索引的速度就慢,反之则快,最好>10
        达到50个文件时就合并
         */
        mergePolicy.setMergeFactor(50);
        /*
        设置segment最大合并文档数
        设置较小有利于追加索引的速度
        值大,适合批量建立索引好更快的搜索
         */
        mergePolicy.setMaxMergeDocs(5000);
        //启用复合式索引文件格式,合并多个segment
        mergePolicy.setUseCompoundFile(true);
        return mergePolicy;
    }

    //读取索引中的文档并且打印输出
    public void DisplayDocument(String INDEX_File_Path) throws IOException {
        directory=FSDirectory.open(new File(INDEX_File_Path));
        IndexReader reader= IndexReader.open(directory);
        //显示索引中的所有文档
        System.out.println("索引里面document列表:");
        for (int i = 0; i < reader.numDocs(); i++) {
            System.out.println(reader.document(i));
        }
        //输出索引中文档数目
        System.out.println("索引里面document数量是:" + reader.numDocs());
        reader.close();
    }

    //删除索引的文档
    public void DeleteDocument(String Filed_Name, String Filed_Value) throws Exception {
        directory=FSDirectory.open(new File(indexDir));
        iwc=new IndexWriterConfig(Version.LUCENE_36,new StandardAnalyzer(
                Version.LUCENE_36
        ));
        writer=new IndexWriter(directory,iwc);
        Term term=new Term(Filed_Name,Filed_Value);
        writer.deleteDocuments(term);
        writer.optimize();
        writer.commit();
        writer.close();
    }

    //更新索引中的文档
    public void UpdateDocument(String old_Filed_Name, String old_Filed_Value,
                               String new_Filed_Name, String new_Filed_Value) throws Exception {
        directory=FSDirectory.open(new File(indexDir));
        iwc=new IndexWriterConfig(Version.LUCENE_36,new StandardAnalyzer(Version.LUCENE_36));

        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        writer=new IndexWriter(directory,iwc);
        Document doc=new Document();
        doc.add(new Field("id","3",Field.Store.YES,Field.Index.ANALYZED));
        doc.add(new Field(new_Filed_Name,new_Filed_Value,Field.Store.YES,
                Field.Index.NOT_ANALYZED));

        writer.updateDocument(new Term(old_Filed_Name, old_Filed_Value), doc);
        writer.optimize();
        writer.commit();
        writer.close();
    }
}
