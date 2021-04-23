package keen.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author keen1
 */
public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (source == null) {
            throw new RuntimeException("传入的值为空");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把字符串转换成日期
            return df.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("转换失败");

        }

    }
}
