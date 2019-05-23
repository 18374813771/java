import cn.dhx.reflect.office.Office;
import cn.dhx.reflect.office.OfficeBetter;
import org.junit.Test;

public class OfficeTest {

    @Test
    public void testOffice(){
        Office office = new Office();
        office.runOffice("excel");
    }

    @Test
    public void testOfficeBetter(){
        OfficeBetter officeBetter = new OfficeBetter();
        officeBetter.runDoc("cn.dhx.reflect.office.type.Excel");
        officeBetter.runDoc("cn.dhx.reflect.office.type.Word");
    }
}
