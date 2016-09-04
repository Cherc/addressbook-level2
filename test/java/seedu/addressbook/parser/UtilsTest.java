package seedu.addressbook.parser;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void isAnyNull_1NullObject_returnsTrue(){
        Object obj1 = null;
        try {
            Address phone1 = new Address("123", false);
            boolean hasNull = Utils.isAnyNull(obj1, phone1);
            assertTrue(hasNull);
        } catch (IllegalValueException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
    
    @Test
    public void isAnyNull_noNullObjects_returnsFalse(){
        try {
            Email email1 = new Email("123@123", false);
            Address phone1 = new Address("123", false);
            boolean hasNull = Utils.isAnyNull(email1, phone1);
            assertTrue(!hasNull);
        } catch (IllegalValueException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
    
}
