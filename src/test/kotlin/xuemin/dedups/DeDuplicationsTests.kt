package xuemin.dedups

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DeDuplicationsTests {

    @Test
    fun `Empty list result in empty list`() {
        assertTrue(deDuplications(emptyList<String>(), 1).isEmpty())
        assertTrue(deDuplications(emptyList<String>(), 10).isEmpty())
    }

    @Test
    fun `duplicates shorter than the limit are not removed`() {
        assertIterableEquals(listOf("a"), deDuplications(listOf("a"), 1))
        assertIterableEquals(listOf("a"), deDuplications(listOf("a"), 2))
        assertIterableEquals(listOf("ab"), deDuplications(listOf("ab"), 1))
        assertIterableEquals(listOf("ab"), deDuplications(listOf("ab"), 2))
        assertIterableEquals(listOf("aa"), deDuplications(listOf("aa"), 2))
        assertIterableEquals(listOf("aaa"), deDuplications(listOf("aaa"), 3))
        assertIterableEquals(listOf("abbccc"), deDuplications(listOf("abbccc"), 3))
        assertIterableEquals(listOf("aa","bb", "aa"), deDuplications(listOf("aa","bb", "aa"), 1))
    }

    @Test
    fun `consecutive duplicates longer than the limit are removed`() {
        assertIterableEquals(emptyList<String>(), deDuplications(listOf("a"), 0))
        assertIterableEquals(emptyList<String>(), deDuplications(listOf("aa", "aa"), 1))
        assertIterableEquals(emptyList<String>(), deDuplications(listOf("ab","ab","ab"), 2))
        assertIterableEquals(emptyList<String>(), deDuplications(listOf("aaa","aaa","aaa","aaa"), 3))
        assertIterableEquals(emptyList<String>(), deDuplications(listOf("a","a","a","a","a"), 3))
        assertIterableEquals(emptyList<String>(), deDuplications(listOf("a","a","a","a","a","a"), 3))
    }

    @Test
    fun `multiple separate consecutive duplicates 1 longer than the limit are removed`() {
//        assertIterableEquals(emptyList<String>(), deDuplications(listOf("a", "b"), 0))
        assertIterableEquals(listOf("c"), deDuplications(listOf("ab","ab","c", "ab", "ab"), 1))
//        assertIterableEquals(listOf("a","a","c"), deDuplications(listOf("a","a","c", "ab", "ab", "ab"), 2))
//        assertIterableEquals(listOf("aaa","aaa","aaa", "aaa", "d", "e"), deDuplications(listOf("aaa","aaa","aaa", "c", "c", "c", "c", "aaa", "d", "aaa", "aaa", "aaa", "aaa", "e", "aaa","aaa", "aaa", "aaa"), 3))
    }

}
