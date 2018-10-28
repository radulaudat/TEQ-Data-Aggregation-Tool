package com.tdat.data.analysis;

import com.tdat.data.ColumnNotFoundException;
import com.tdat.data.TableData;
import com.tdat.data.VisitData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SingleTableReaderTest {
    private static TableData tableData = new TableData();
    private static VisitData visit1 = new VisitData();
    private static VisitData visit2 = new VisitData();
    private static SingleTableReader tableReader;
    @BeforeAll
    public static void setUp(){
        visit1.addColumnData("Col1", "11");
        visit1.addColumnData("Col2", "21");
        visit2.addColumnData("Col1", "11");
        visit2.addColumnData("Col2", "22");
        tableData.addVisitData(visit1);
        tableData.addVisitData(visit2);
        tableReader = new SingleTableReader(tableData);
    }

    @Test
    @DisplayName("Test col not found")
    void columnNotFound() throws ColumnNotFoundException {
        assertThrows(ColumnNotFoundException.class, ()->{tableReader.columnEntriesCount("dne");});
    }

    @Test
    @DisplayName("Test counting entries in multi columns")
    void multiColumnEntriesCount() throws ColumnNotFoundException {
        Map<String, Map<String, Integer>> expected = new HashMap<>();
        Map<String,Integer> col1Data = new HashMap<>();
        Map<String,Integer> col2Data = new HashMap<>();
        col1Data.put("11", 2);
        col2Data.put("21", 1);
        col2Data.put("22", 1);
        expected.put("Col1", col1Data);
        expected.put("Col2", col2Data);
        assertEquals(expected, tableReader.multiColumnEntriesCount(new ArrayList<>(Arrays.asList("Col1","Col2"))));
    }

    @Test
    @DisplayName("Test getting number of entries in table")
    void getNumEntries() {
        assertEquals(2, tableReader.getNumEntries());
    }

    @Test
    void listAllColumns() {
        Set<String> testResult = tableReader.listAllColumns();
        assertEquals(true, testResult.contains("Col1") && testResult.contains("Col2"));
    }

    @Test
    void getNumColumns() {
        assertEquals(2, tableReader.getNumColumns());
    }
}