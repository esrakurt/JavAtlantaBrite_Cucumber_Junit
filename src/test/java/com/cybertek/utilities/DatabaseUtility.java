package com.cybertek.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseUtility {


        private static Connection connection;
        private static Statement statement;
        private static ResultSet resultSet;


        public static void createConnection() {
            String url = "jdbc:postgresql://54.148.96.210:5432/BriteErpDemo";
            String user = "podoo";
            String password ="podoo";


            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        public static void closeConnection() {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        /**
         *
         * @param query
         * @return returns a single cell value. If the results in multiple rows and/or
         *         columns of data, only first column of the first row will be returned.
         *         The rest of the data will be ignored
         */
        public static Object getCellValue(String query) {
            return getQueryResultList(query).get(0).get(0);
        }

        /**
         *
         * @param query
         * @return returns a list of Strings which represent a row of data. If the query
         *         results in multiple rows and/or columns of data, only first row will
         *         be returned. The rest of the data will be ignored
         */
        public static List<Object> getRowList(String query) {
            return getQueryResultList(query).get(0);
        }

        /**
         *
         * @param query
         * @return returns a map which represent a row of data where key is the column
         *         name. If the query results in multiple rows and/or columns of data,
         *         only first row will be returned. The rest of the data will be ignored
         */
        public static Map<String, Object> getRowMap(String query) {
            return getQueryResultMap(query).get(0);
        }

        /**
         *
         * @param query
         * @return returns query result in a list of lists where outer list represents
         *         collection of rows and inner lists represent a single row
         */
        public static List<List<Object>> getQueryResultList(String query) {
            executeQuery(query);
            List<List<Object>> rowList = new ArrayList<>();
            ResultSetMetaData rsmd;

            try {
                rsmd = resultSet.getMetaData();
                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        row.add(resultSet.getObject(i));
                    }

                    rowList.add(row);

                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return rowList;

        }

        /**
         *
         * @param query
         * @param column
         * @return list of values of a single column from the result set
         */
        public static List<Object> getColumnData(String query, String column) {
            executeQuery(query);
            List<Object> rowList = new ArrayList<>();
            ResultSetMetaData rsmd;

            try {
                rsmd = resultSet.getMetaData();
                while (resultSet.next()) {
                    rowList.add(resultSet.getObject(column));
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return rowList;

        }

        /**
         *
         * @param query
         * @return returns query result in a list of maps where the list represents
         *         collection of rows and a map represents represent a single row with
         *         key being the column name
         */
        public static List<Map<String, Object>> getQueryResultMap(String query) {
            executeQuery(query);
            List<Map<String, Object>> rowList = new ArrayList<>();
            ResultSetMetaData rsmd;

            try {
                rsmd = resultSet.getMetaData();

                while (resultSet.next()) {

                    Map<String, Object> colNameValueMap = new HashMap<>();

                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                        colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                    }

                    rowList.add(colNameValueMap);

                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return rowList;

        }

        /**
         *
         * @param query
         * @return List of columns returned in result set
         */
        public static List<String> getColumnNames(String query) {
            executeQuery(query);
            List<String> columns = new ArrayList<>();
            ResultSetMetaData rsmd;

            try {
                rsmd = resultSet.getMetaData();
                int columnCount = rsmd.getColumnCount();

                for (int i = 1; i <= columnCount; i++) {
                    columns.add(rsmd.getColumnName(i));
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return columns;

        }

        private static void executeQuery(String query) {
            try {
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                resultSet = statement.executeQuery(query);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public static int getRowCount() throws Exception {

            resultSet.last();

            int rowCount = resultSet.getRow();
            return rowCount;

        }


//        public static void main(String[] args) throws Exception {
//            //scanner for entry
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Enter the value you are looking for :");
//            String searchObject = scan.next();
//
//            //connection info
//            String url = "jdbc:postgresql://54.148.96.210:5432/BriteErpDemo";
//            String user ="podoo";
//            String pass ="podoo";
//            createConnection();
//
//            //create table list for tables
//            List<String> tables = new ArrayList<>();
//            //database meta data for getting metadata from db such as all table names
//            DatabaseUtility dbmd = connection.getMetaData();
//            //this code is gettin all tabel data got this info from google
//            String[] types = {"TABLE"};
//            resultSet = dbmd.getTables(null, null, "%", types);
//            //this code assign all table values to table list
//            while (resultSet.next()) {
//                tables.add(resultSet.getString("TABLE_NAME"));
//            }
//
//            //here all heavy work
//            for(int i=0;i<tables.size();i++) {
//                //creating list for collumn key names in table
//                List<Object>columns = new ArrayList<>();
//                //execute query which gets all columns in i.index table
//                executeQuery("SELECT * FROM "+tables.get(i));
//                //creating and  resultSetMetaData and asignin our last query result to it.
//                ResultSetMetaData rsmd = resultSet.getMetaData();
//                //here just printing the name to see results is keep going and not freezed
//                System.out.println("===========PROGRESS ON===================="+tables.get(i));
//                //creating new arraylist for rows for every cell.Its two list because method return is two list.
//                List<List<Object>> rows = new ArrayList<>();
//                for(int j=1;j<= rsmd.getColumnCount();j++) {
//                    //here we are adding all column Key names to list we created.
//                    columns.add(rsmd.getColumnName(j));
//                    //we are assignin rows list with getQueryResultList method.
//                    rows = getQueryResultList("SELECT \""+columns.get(j-1)+"\" FROM "+tables.get(i)+";");
//                    for(int l=0;l<rows.size();l++) {
//                        //check if that cell contains searchin value.
//                        if((rows.get(l).get(0)+"").contains(searchObject))
//                            System.out.println("***********************************************FOUND***********************************************\n+"
//                                    + "Select "+columns.get(j-1)+" FROM "+tables.get(i)+"\n"+
//                                    "***********************************************FOUND***********************************************");
//
//
//                    }
//
//                }
//
//            }
//
//
//
//
//
//
//
//            System.out.println("END HERE");
//
//
//            scan.close();
//            closeConnection();
//        }


    }

