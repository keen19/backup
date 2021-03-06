package suanfa.Lab15;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

public class Demo1 {

    public static void main(String[] args) {
        String Index_Store_Path = "F:/2/lab05";
        File file = new File(Index_Store_Path);
        try {
            Directory Index = FSDirectory.open(file);
            IndexWriter writer = new IndexWriter(Index, new StandardAnalyzer(Version.LUCENE_CURRENT), true,
                    IndexWriter.MaxFieldLength.LIMITED);
            writer.setUseCompoundFile(false);

            Document doc1 = new Document();
            Field f11 = new Field("bookNumber", "0000001", Field.Store.YES, Field.Index.NOT_ANALYZED);
            Field f12 = new Field("bookName", " 钢铁是怎样炼成的 ", Field.Store.YES, Field.Index.ANALYZED);
            Field f13 = new Field("publishDate", "1970-01-01", Field.Store.YES, Field.Index.NOT_ANALYZED);
            doc1.add(f11);
            doc1.add(f12);
            doc1.add(f13);

            Document doc2 = new Document();
            Field f21 = new Field("bookNumber", "0000002", Field.Store.YES, Field.Index.NOT_ANALYZED);
            Field f22 = new Field("bookName", " 钢铁战士 ", Field.Store.YES, Field.Index.ANALYZED);
            Field f23 = new Field("publishDate", "1970-01-01", Field.Store.YES, Field.Index.NOT_ANALYZED);
            doc2.add(f21);
            doc2.add(f22);
            doc2.add(f23);

            Document doc3 = new Document();
            Field f31 = new Field("bookNumber", "0000003", Field.Store.YES, Field.Index.NOT_ANALYZED);
            Field f32 = new Field("bookName", " 篱笆女人和狗 ", Field.Store.YES, Field.Index.ANALYZED);
            Field f33 = new Field("publishDate", "1970-01-01", Field.Store.YES, Field.Index.NOT_ANALYZED);
            doc3.add(f31);
            doc3.add(f32);
            doc3.add(f33);

            Document doc4 = new Document();
            Field f41 = new Field("bookNumber", "0000004", Field.Store.YES, Field.Index.NOT_ANALYZED);
            Field f42 = new Field("bookName", " 女人是水做的 ", Field.Store.YES, Field.Index.ANALYZED);
            Field f43 = new Field("publishDate", "1970-01-01", Field.Store.YES, Field.Index.NOT_ANALYZED);
            doc4.add(f41);
            doc4.add(f42);
            doc4.add(f43);

            Document doc5 = new Document();
            Field f51 = new Field("bookNumber", "0000005", Field.Store.YES, Field.Index.NOT_ANALYZED);
            Field f52 = new Field("bookName", " 英雄儿女 ", Field.Store.YES, Field.Index.ANALYZED);
            Field f53 = new Field("publishDate", "1970-01-01", Field.Store.YES, Field.Index.NOT_ANALYZED);
            doc5.add(f51);
            doc5.add(f52);
            doc5.add(f53);

            Document doc6 = new Document();
            Field f61 = new Field("bookNumber", "0000006", Field.Store.YES, Field.Index.NOT_ANALYZED);
            Field f62 = new Field("bookName", " 白毛女 ", Field.Store.YES, Field.Index.ANALYZED);
            Field f63 = new Field("publishDate", "1970-01-01", Field.Store.YES, Field.Index.NOT_ANALYZED);
            doc6.add(f61);
            doc6.add(f62);
            doc6.add(f63);

            Document doc7 = new Document();
            Field f71 = new Field("bookNumber", "0000007", Field.Store.YES, Field.Index.NOT_ANALYZED);
            Field f72 = new Field("bookName", " 我的兄弟和女儿 ", Field.Store.YES, Field.Index.ANALYZED);
            Field f73 = new Field("publishDate", "1970-01-01", Field.Store.YES, Field.Index.NOT_ANALYZED);
            doc7.add(f71);
            doc7.add(f72);
            doc7.add(f73);

            writer.addDocument(doc1);
            writer.addDocument(doc2);
            writer.addDocument(doc3);
            writer.addDocument(doc4);
            writer.addDocument(doc5);
            writer.addDocument(doc6);
            writer.addDocument(doc7);
            writer.optimize();
            writer.close();

        } catch (CorruptIndexException e) {
            e.printStackTrace();
        } catch (LockObtainFailedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
