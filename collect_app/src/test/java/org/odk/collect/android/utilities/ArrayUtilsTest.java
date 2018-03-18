package org.odk.collect.android.utilities;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.odk.collect.android.utilities.ArrayUtils.toObject;
import static org.odk.collect.android.utilities.ArrayUtils.toPrimitive;

public class ArrayUtilsTest {

    @Test
    public void toPrimitiveCreatesPrimitiveLongArray() throws Exception {
        assertArrayEquals(new long[] {1, 2, 3}, toPrimitive(new Long[] {1L, 2L, 3L}));
    }

    @Test
    public void nullToPrimitiveCreatesEmptyPrimitiveLongArray() throws Exception {
        assertArrayEquals(new long[0], toPrimitive(null));
    }

    @Test(expected = NullPointerException.class)
    public void arrayContainingNullCausesNpe() {
        toPrimitive(new Long[] {1L, null, 3L, 4L, 5L});
    }

    @Test(expected = NullPointerException.class)
    public void arrayStartingWithNullCausesNpe() {
        toPrimitive(new Long[] {null, 2L, 3L});
    }

    @Test(expected = NullPointerException.class)
    public void arrayEndingWithNullCausesNpe() {
        toPrimitive(new Long[] {1L, 2L, null});
    }

    @Test
    public void toObjectCreatesLongArray() throws Exception {
        assertArrayEquals(new Long[] {1L, 2L, 3L}, toObject(new long[] {1, 2, 3}));
    }

    @Test
    public void nullBecomesEmptyLongArray() throws Exception {
        assertArrayEquals(new Long[0], toObject(null));
    }
}