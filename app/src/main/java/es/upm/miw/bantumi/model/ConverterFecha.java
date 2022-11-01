package es.upm.miw.bantumi.model;
import androidx.room.TypeConverter;

import java.util.Date;
public class ConverterFecha {

        @TypeConverter
        public static Date fromTimestamp(Long value) {
            return value != null ?  new Date(value) : null ;
        }

        @TypeConverter
        public static Long dateToTimestamp(Date date) {
            return date != null ? date.getTime()  : null ;
        }

}
