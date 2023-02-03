package org.example;

import org.apache.spark.sql.*;
import org.apache.spark.sql.SparkSession;

public class SparkDemo {
    public static void main(String[] args) {

        SparkSession sparkSession = SparkSession.builder().master("local").appName("SPARKDEMO").getOrCreate();
        String filePath = SparkDemo.class.getResource("csvFile.csv").getPath();

        Dataset<Row> dataset = sparkSession.sqlContext()
                .read()
                .format("com.databricks.spark.csv")
                .option("header",true)  // for header of col top
                .load(filePath);
        dataset.show(false);    // for showing full value.....
    }
}